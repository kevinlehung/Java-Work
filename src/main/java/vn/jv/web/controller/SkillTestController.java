package vn.jv.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.jv.constant.WebConstants;
import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.TQuestionRepo;
import vn.jv.security.bean.JvUserDetails;
import vn.jv.service.ISkillService;
import vn.jv.web.bean.QuestionBean;
import vn.jv.web.common.util.SecurityUtil;

/**
 * This controller is to process Skill testing
 *  
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class SkillTestController  extends BaseController {
	
	@Autowired
	private ISkillService skillService;
	
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
	public String viewPracticeQuestion(HttpServletRequest request, HttpServletResponse response, 
										@PathVariable("skillId") Integer skillId, Model model) throws IOException {
		Skill skill = skillService.findById(skillId);
		model.addAttribute("skill", skill);
		JvUserDetails userDetail = SecurityUtil.getUserDetail();
		User jvUser = userDetail.getJvUser();
		//get practice question
		QuestionBean question = skillService.getRandomPracticeQuestion(skillId, jvUser);
		if (question == null) {
			String errorMsg = "Cannot find any practice question";
			model.addAttribute("errorMsg", errorMsg);
			return WebConstants.Views.SKILL_TEST;
		}
		model.addAttribute("question", question);
		int timeout = 1;
		model.addAttribute("timeout", timeout);
		return WebConstants.Views.SKILL_TEST_PRACTICE;
	}
	
	@RequestMapping(value="/u/skill/{skillId}/test/practice/complete", method=RequestMethod.POST)
	public String completePracticeQuestion(HttpServletRequest request, HttpServletResponse response, 
											@PathVariable("skillId") Integer skillId, 
											@RequestParam(value="choice", required=false) Integer optionId,
											@RequestParam(value="questionId", required=true) Integer questionId, Model model) throws IOException {
		
		return WebConstants.Views.SKILL_TEST_PRACTICE_COMPLETE;
	}
	
	@RequestMapping("/u/skill/{skillId}/test/question")
	public String requestQuestion(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("skillId") int skillId, Model model) throws IOException {
		return WebConstants.Views.SKILL_TEST_QUESTION;
	}
	
	@RequestMapping("/u/skill/{skillId}/test/question/complete")
	public String completeQuestion(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("skillId") int skillId, Model model) throws IOException {
		//return WebConstants.Views.SKILL_TEST_QUESTION_COMPLETE;
		return WebConstants.Views.SKILL_TEST_QUESTION_TIMEOUT;
	}
}