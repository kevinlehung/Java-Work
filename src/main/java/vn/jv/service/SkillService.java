package vn.jv.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.TOption;
import vn.jv.persist.domain.TQuestion;
import vn.jv.persist.domain.TTest;
import vn.jv.persist.domain.TTestQuestion;
import vn.jv.persist.domain.TUserTest;
import vn.jv.persist.domain.User;
import vn.jv.persist.domain.WorkCategory;
import vn.jv.persist.repositories.SkillRepo;
import vn.jv.persist.repositories.TOptionRepo;
import vn.jv.persist.repositories.TQuestionRepo;
import vn.jv.persist.repositories.TTestRepo;
import vn.jv.web.bean.OptionBean;
import vn.jv.web.bean.QuestionBean;
import vn.jv.web.bean.SkillBean;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
@Service("skillService")
public class SkillService extends BaseService implements ISkillService {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SkillRepo skillRepo;
	
	@Autowired
	TQuestionRepo tQuestionRepo;
	
	@Autowired
	TOptionRepo tOptionRepo;
	
	@Autowired
	TTestRepo tTestRepo;
	
	@Autowired
	ITTestService tTestService;
	
	@Autowired
	ITTestQuestionService tTestQuestionService;
	
	@Autowired
	ITUserTestService tUserTestService;
	
	@Cacheable("SkillService.findAll")
	public List<Skill> findAll() {
		return skillRepo.findAll();
	}

	public List<Skill> findByIds(List<Integer> skillIds) {
		List<Skill> skills = new ArrayList<Skill>();
		if (skillIds != null) {
			for (Integer skillId : skillIds) {
				Skill skill = findById(skillId);
				skills.add(skill);
			}
		}
		return skills;
	}

	@Cacheable(value = {"SkillService.findById"}, key = "#skillId")
	public Skill findById(Integer skillId) {
		return skillRepo.findOne(skillId);
	}
	
	@Cacheable(value = "SkillService.findByWorkCategoryId", key="#workCategoryId")
	public List<SkillBean> findByWorkCategoryId(int workCategoryId) {
		List<Skill> skills = skillRepo.findByWorkCategory(new WorkCategory(workCategoryId));
		List<SkillBean> skillBeans = new ArrayList<SkillBean>();
		for (Skill skill : skills) {
			skillBeans.add(new SkillBean(skill.getSkillId(), skill.getName(), skill.getWorkCategory().getWorkCategoryId()));
		}
		return skillBeans;
	}
	
	private List<TQuestion> findQuestionBySkillIdAndDifferFormTestedQuestions(int skillId, User currentUser, int numOfQuestion, Integer practiceQuestionId) {
		List<TQuestion> randomQuestions = null;
		//get list of tested question ids of current user
		List<Integer> testedQuestionIds = tQuestionRepo.getTestedQuestionIdsBySkillIdAndUserId(skillId, currentUser.getUserId());
		List<Integer> excludeQuestionIds = new ArrayList<Integer>();
		if (practiceQuestionId != null) {
			excludeQuestionIds.add(practiceQuestionId);
		}
		if (testedQuestionIds != null && !testedQuestionIds.isEmpty()) {
			excludeQuestionIds.addAll(testedQuestionIds);
		}
		if (excludeQuestionIds.isEmpty()) {
			randomQuestions = tQuestionRepo.getRandomTQuestionBySkillIdAndDifferFromTestedQuestionByNativeQuery(skillId, numOfQuestion);
		} else {
			randomQuestions = tQuestionRepo.getRandomTQuestionBySkillIdAndDifferFromTestedQuestionByNativeQuery(skillId, numOfQuestion, excludeQuestionIds);
		}
		if (randomQuestions == null || randomQuestions.isEmpty() || randomQuestions.size() < numOfQuestion) {
			return null;
		}
		return randomQuestions;
	}
	
	public List<TQuestion> getTestQuestions(int skillId, User currentUser, int numOfQuestion, Integer practiceQuestionId) {
		List<TQuestion> tQuestions = findQuestionBySkillIdAndDifferFormTestedQuestions(skillId, currentUser, numOfQuestion, practiceQuestionId);
		return tQuestions;
	}
	
	/**
	 * save test information and set sequence value to questionBeans
	 * @param skillId
	 * @param randomQuestions
	 * @param user
	 * @param questionBeans
	 * @return TTest
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public TTest saveTestInforOfUser(int skillId, List<TQuestion> tQuestions, User user, List<QuestionBean> questionBeans) {
		try {
			// calculate total time of a test
			int totalTime = 0;
			for (TQuestion tQuestion : tQuestions) {
				totalTime += tQuestion.getDuration();
			}
			Skill skill = findById(skillId);
			int totalQuestion = tQuestions.size();
			//create new TTest object 
			TTest tTest = tTestService.saveTTest(totalQuestion, totalTime, skill);
			// create new TTestQuestion mapping TTest with TQuestion
			for (int i = 0; i < tQuestions.size(); i++) {
				TTestQuestion tTestQuestion = tTestQuestionService.saveTTestQuestion(tQuestions.get(i), tTest, i);
				tTest.addTTestQuestion(tTestQuestion);
				//set sequence value to questionBeans
				questionBeans.get(i).setSequence(i);
			}
			// create new TUserTest
			TUserTest tUserTest = tUserTestService.saveTUserTest(tTest, user);
			tTest.addTUserTest(tUserTest);
			
			return tTest;
		} catch (Exception e) {
			throw new RuntimeException("Failed to save Test information of userId#" + user.getUserId() + "] and skillId#" + skillId, e);
		}
	}
	
	public QuestionBean getRandomPracticeQuestion(int skillId, User currentUser) {
		int numOfQuestion = 1;
		List<TQuestion> tQuestions = findQuestionBySkillIdAndDifferFormTestedQuestions(skillId, currentUser, numOfQuestion, null);
		if (tQuestions == null || tQuestions.isEmpty()) {
			return null;
		}
		List<QuestionBean> questionBeans = buildListQuestionBean(tQuestions);
		return questionBeans.get(0);
	}
	
	public QuestionBean getQuestionBeanByQuestionId(int questionId) {
		TQuestion tQuestion = tQuestionRepo.findOne(questionId);
		if (tQuestion == null) {
			return null;
		}
		return buildQuestionBean(tQuestion);
	}
	
	public List<QuestionBean> buildListQuestionBean(List<TQuestion> tQuestions) {
		List<QuestionBean> questionBeans = new ArrayList<QuestionBean>();
		for (int i = 0; i < tQuestions.size(); i++) {
			questionBeans.add(buildQuestionBean(tQuestions.get(i)));
		}
		return questionBeans;
	}
	
	private QuestionBean buildQuestionBean(TQuestion tQuestion) {
		QuestionBean questionBean = new QuestionBean();
		questionBean.setQuestionId(tQuestion.getQuestionId());
		questionBean.setStem(tQuestion.getStem());
		questionBean.setDuration(tQuestion.getDuration());
		questionBean.setMultipleChoice(tQuestion.getIsMultipleChoice());
		List<TOption> tOptions = tOptionRepo.findByTQuestionId(tQuestion.getQuestionId());
		questionBean.setOptions(buildListOptionBean(tOptions));
		return questionBean;
	}
	
	private List<OptionBean> buildListOptionBean(List<TOption> tOptions) {
		List<OptionBean> optionBeans = new ArrayList<OptionBean>();
		if (tOptions == null || tOptions.isEmpty()) {
			return optionBeans;
		}
		for (TOption tOption : tOptions) {
			OptionBean optionBean = new OptionBean();
			optionBean.setOptionId(tOption.getTOptionId());
			optionBean.setDescription(tOption.getDescription());
			
			optionBeans.add(optionBean);
		}
		return optionBeans;
	}

}
