package vn.jv.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.jv.constant.WebConstants;
import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.TQuestion;
import vn.jv.persist.domain.TTest;
import vn.jv.persist.domain.User;
import vn.jv.service.ISkillService;
import vn.jv.service.ITOptionService;
import vn.jv.service.ITQuestionService;
import vn.jv.service.ITUserTestService;
import vn.jv.web.bean.OptionBean;
import vn.jv.web.bean.QuestionBean;
import vn.jv.web.bean.QuestionBean.Status;
import vn.jv.web.bean.TestTrackingBean;
import vn.jv.web.common.util.SecurityUtil;

/**
 * This controller is to process Skill testing
 *  
 * @author hunglevn@outlook.com
 *
 */
@Controller
@SessionAttributes("skill")
public class SkillTestController  extends BaseController {
	
	private static final String START_TIME_PRACTICE_QUESTION = "start_time_practice_question";
	private static final String TEST_TRACKING = "test_tracking";
	
	@Autowired
	private ISkillService skillService;
	
	@Autowired
	private ITOptionService tOptionService;
	
	@Autowired
	private ITQuestionService tQuestionService;
	
	@Autowired
	private ITUserTestService tUserTestService;
	
	@RequestMapping("/u/skill/{skillId}/test")
	public String skillTest(HttpServletRequest request, HttpServletResponse response, 
							@PathVariable("skillId") Integer skillId, Model model) throws IOException {
		Skill skill = skillService.findById(skillId);
		String errorMsg = null;
		if (skill == null) {
			errorMsg = "Cannot find this test";
			model.addAttribute("errorMsg", errorMsg);
			return WebConstants.Views.SKILL_SET;
		}
		model.addAttribute("skill", skill);
		return WebConstants.Views.SKILL_TEST;
	}
	
	@RequestMapping("/u/skill/{skillId}/test/practice")
	public String viewPracticeQuestion( @ModelAttribute("skill") Skill skill,
										HttpServletRequest request, HttpServletResponse response, 
										@PathVariable("skillId") Integer skillId, Model model, 
										RedirectAttributes redirectAttributes) throws Exception {
		model.addAttribute("skill", skill);
		User jvUser = SecurityUtil.getCurrentUser();
		//get practice question
		QuestionBean question = skillService.getRandomPracticeQuestion(skillId, jvUser);
		if (question == null) {
			String errorMsg = "Cannot find any practice question";
			redirectAttributes.addFlashAttribute("errorMsg", errorMsg);
			return "redirect:/u/skill/" + skillId + "/test" + WebConstants.PAGE_SUFFIX;
		}
		model.addAttribute("question", question);
		HttpSession session = request.getSession();
		session.setAttribute(START_TIME_PRACTICE_QUESTION + question.getQuestionId(), System.currentTimeMillis());
		return WebConstants.Views.SKILL_TEST_PRACTICE;
	}
	
	@RequestMapping(value="/u/skill/{skillId}/test/practice/complete", method=RequestMethod.POST)
	public String completePracticeQuestion( @ModelAttribute("skill") Skill skill,
											HttpServletRequest request, HttpServletResponse response, 
											@PathVariable("skillId") Integer skillId, 
											@RequestParam(value="choices", required=false) List<Integer> choiceOptionIds,
											@RequestParam(value="questionId", required=true) Integer questionId, Model model) throws IOException {
		Long startTime = (Long) request.getSession().getAttribute(START_TIME_PRACTICE_QUESTION + questionId);
		Long duration = (System.currentTimeMillis() - startTime) / 1000;
		request.getSession().removeAttribute(START_TIME_PRACTICE_QUESTION + questionId);
		QuestionBean question = skillService.getQuestionBeanByQuestionId(questionId);
		List<Integer> keys = tOptionService.findKeyOptionOfQuestion(questionId);
		//set option key to OptionBean of QuestionBean
		setKeyAndChoicedOptionBeanOfQuestionBean(question.getOptions(), keys, choiceOptionIds);
		model.addAttribute("skill", skill);
		model.addAttribute("question", question);
		request.getSession().setAttribute("practiceQuestionId" + skillId, questionId);
		if (duration > question.getDuration()) {
			return WebConstants.Views.SKILL_TEST_PRACTICE_OUT_OF_TIME;
		}
		if (choiceOptionIds == null || choiceOptionIds.isEmpty()) {
			model.addAttribute("isCorrect", false);
			return WebConstants.Views.SKILL_TEST_PRACTICE_COMPLETE;
		}
		if (!CollectionUtils.isEqualCollection(choiceOptionIds, keys)) {
			model.addAttribute("isCorrect", false);
		} else {
			model.addAttribute("isCorrect", true);
		}
		
		return WebConstants.Views.SKILL_TEST_PRACTICE_COMPLETE;
	}
	
	@RequestMapping("/u/skill/{skillId}/test/question")
	public String requestQuestion(@ModelAttribute("skill") Skill skill, HttpServletRequest request, 
									HttpServletResponse response, @PathVariable("skillId") int skillId, Model model) throws IOException {
		String errorMsg = null;
		Integer practiceQuestionId = (Integer) request.getSession().getAttribute("practiceQuestionId" + skillId);
		if (practiceQuestionId != null) {
			request.getSession().removeAttribute("practiceQuestionId" + skillId);
		}
		model.addAttribute("skill", skill);
		User currentUser = SecurityUtil.getCurrentUser();
		TestTrackingBean testTrackingBean = (TestTrackingBean) request.getSession().getAttribute(TEST_TRACKING + "-" + currentUser.getUserId() + "-" + skillId);
		/**
		 *  creates new test for the first time requesting
		 */
		if (testTrackingBean == null) {
			testTrackingBean = createNewTTestForUserTaking(request, model, currentUser, skillId, practiceQuestionId);
			if (testTrackingBean == null) {
				errorMsg = "Cannot find any question";
				model.addAttribute("errorMsg", errorMsg);
				return WebConstants.Views.SKILL_TEST_QUESTION;
			}
			request.getSession().setAttribute(TEST_TRACKING + "-" + currentUser.getUserId() + "-" + skillId, testTrackingBean);
		}
		QuestionBean question = getEligibleQuestionBean(testTrackingBean, skill);
		if (question == null) {
			//give them a message
			errorMsg = "Failed to get question";
			model.addAttribute("errorMsg", errorMsg);
			return WebConstants.Views.SKILL_TEST_QUESTION;
		}
		model.addAttribute("question", question);
		return WebConstants.Views.SKILL_TEST_QUESTION;
	}
	
	private QuestionBean getEligibleQuestionBean(TestTrackingBean testTrackingBean, Skill skill) {
		int currentSequence = testTrackingBean.getCurrentQuestionSequence();
		List<QuestionBean> questionBeans = testTrackingBean.getQuestionBeans();
		if (currentSequence >= questionBeans.size()) {
			return null;
		}
		QuestionBean question = questionBeans.get(currentSequence);
		if (question.getStatus().equalsIgnoreCase(Status.TESTING) || question.getStatus().equalsIgnoreCase(Status.TESTED)) {
			currentSequence += 1;
			if (currentSequence >= questionBeans.size()) {
				return null;
			}
			testTrackingBean.setCurrentQuestionSequence(currentSequence);
			question = getEligibleQuestionBean(testTrackingBean, skill);
		}
		//mark question is in testing status
		question.setStatus(Status.TESTING);
		//set start time of tested question
		question.setStartTime(System.currentTimeMillis());
		log.info("Skill: #" + skill.getSkillId() + ". Eligible questionBean: id#"+ question.getQuestionId() + 
				", currentSequence#" + currentSequence + ", startTime["+ question.getStartTime() +"]");
		return question;
	}
	
	@RequestMapping(value="/u/skill/{skillId}/test/question/complete", method=RequestMethod.POST)
	public String completeQuestion(HttpServletRequest request, HttpServletResponse response, 
									@PathVariable("skillId") int skillId, @ModelAttribute("skill") Skill skill, 
									@RequestParam(value="choices", required=false) List<Integer> choiceOptionIds,
									@RequestParam(value="questionId", required=true) Integer questionId, Model model) throws IOException {
		long finishedTime = System.currentTimeMillis();
		User currentUser = SecurityUtil.getCurrentUser();
		TestTrackingBean testTrackingBean = (TestTrackingBean) request.getSession().getAttribute(TEST_TRACKING + "-" + currentUser.getUserId() + "-" + skillId);
		//find submited questionBean by id in list questionBeans of TestTrackingBean
		QuestionBean questionBean = getQuestionBeanInListById(questionId, testTrackingBean.getQuestionBeans());
		//change status from testing to tested 
		questionBean.setStatus(Status.TESTED);
		List<Integer> keys = tOptionService.findKeyOptionOfQuestion(questionId);
		//set option key to OptionBean of QuestionBean
		setKeyAndChoicedOptionBeanOfQuestionBean(questionBean.getOptions(), keys, choiceOptionIds);
		model.addAttribute("skill", skill);
		model.addAttribute("question", questionBean);
		Long startTime = questionBean.getStartTime();
		Long duration = (finishedTime - startTime) / 1000;
		//Check if there is the final question
		int sequence = testTrackingBean.getCurrentQuestionSequence();
		if (sequence == (testTrackingBean.getQuestionBeans().size() - 1)) {
			/**
			 * check if in testTrackingBean still has testing question alive, 
			 * otherwise remove testTrackingBean from session
			 */
			if (!isContainsAliveTestingQuestion(testTrackingBean.getQuestionBeans())) {
				//update correct count and score test
				tUserTestService.updateScoreAndCorrectCountTest(currentUser, testTrackingBean);
				request.getSession().removeAttribute(TEST_TRACKING + "-" + currentUser.getUserId() + "-" + skillId);
			}
			model.addAttribute("isCompletedTest", true);
		}
		log.info("Skill: #" + skill.getSkillId() + ". Complete QuestionBean: id#"+ questionBean.getQuestionId() + 
				", currentSequence#" + sequence + ", startTime["+ questionBean.getStartTime() + 
				"], finisedTime[" + finishedTime + "], duration[" + duration + "]");
		if (duration > questionBean.getDuration()) {
			return WebConstants.Views.SKILL_TEST_QUESTION_TIMEOUT;
		}
		boolean isCorrect = false;
		if (choiceOptionIds == null || choiceOptionIds.isEmpty()) {
			model.addAttribute("isCorrect", isCorrect);
			return WebConstants.Views.SKILL_TEST_QUESTION_COMPLETE;
		}
		if (!CollectionUtils.isEqualCollection(choiceOptionIds, keys)) {
			model.addAttribute("isCorrect", isCorrect);
		} else {
			isCorrect = true;
			model.addAttribute("isCorrect", isCorrect);
			testTrackingBean.setCorrectCount((testTrackingBean.getCorrectCount() + 1));
		}
		return WebConstants.Views.SKILL_TEST_QUESTION_COMPLETE;
	}
	
	private boolean isContainsAliveTestingQuestion(List<QuestionBean> questionBeans) {
		for (QuestionBean questionBean : questionBeans) {
			Long startTime = questionBean.getStartTime();
			Long duration = (System.currentTimeMillis() - startTime) / 1000;
			if (questionBean.getStatus().equalsIgnoreCase(Status.TESTING) && duration <= questionBean.getDuration()) {
				return true;
			}
		}
		return false;
	}
	
	private QuestionBean getQuestionBeanInListById(Integer questionId, List<QuestionBean> questionBeans) {
		for (int i = 0; i < questionBeans.size(); i ++) {
			if (questionBeans.get(i).getQuestionId() == questionId) {
				return questionBeans.get(i);
			}
		}
		return null;
	}
	
	private TestTrackingBean createNewTTestForUserTaking(HttpServletRequest request, Model model, User currentUser, int skillId, Integer practiceQuestionId) {
		int numOfQuestions = 5;
		TestTrackingBean testTrackingBean = new TestTrackingBean();
		List<TQuestion> tQuestions = skillService.getTestQuestions(skillId, currentUser, numOfQuestions, practiceQuestionId);
		if (tQuestions == null || tQuestions.isEmpty()) {
			return null;
		}
		List<QuestionBean> questionBeans = skillService.buildListQuestionBean(tQuestions);
		TTest tTest = skillService.saveTestInforOfUser(skillId, tQuestions, currentUser, questionBeans);
		testTrackingBean.setQuestionBeans(questionBeans);
		testTrackingBean.settTest(tTest);
		return testTrackingBean;
	}
	
	private void setKeyAndChoicedOptionBeanOfQuestionBean(List<OptionBean> optionBeans, List<Integer> keys, List<Integer> choices) {
		for (int i = 0; i < optionBeans.size(); i++) {
			if (keys.contains(optionBeans.get(i).getOptionId())) {
				optionBeans.get(i).setIsKey(true);
			}
			if (choices != null && !choices.isEmpty()) {
				if (choices.contains(optionBeans.get(i).getOptionId())) {
					optionBeans.get(i).setIsChoiced(true);
				}
			}
		}
	}
	
}