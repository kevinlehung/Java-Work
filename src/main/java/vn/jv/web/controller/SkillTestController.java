package vn.jv.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.jv.constant.WebConstants;

/**
 * This controller is to process Skill testing
 *  
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class SkillTestController  extends BaseController {
	@RequestMapping("/u/skill/{workCategoryId}/test")
	public String skillTest(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("workCategoryId") int workCategoryId, Model model) throws IOException {
		return WebConstants.Views.SKILL_TEST;
	}
	
	@RequestMapping("/u/skill/{workCategoryId}/test/practice")
	public String viewPracticeQuestion(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("workCategoryId") int workCategoryId, Model model) throws IOException {
		return WebConstants.Views.SKILL_TEST_PRACTICE;
	}
	
	@RequestMapping("/u/skill/{workCategoryId}/test/practice/complete")
	public String completePracticeQuestion(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("workCategoryId") int workCategoryId, Model model) throws IOException {
		//return WebConstants.Views.SKILL_TEST_PRACTICE_OUT_OF_TIME;
		return WebConstants.Views.SKILL_TEST_PRACTICE_COMPLETE;
	}
	
	@RequestMapping("/u/skill/{workCategoryId}/test/question")
	public String requestQuestion(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("workCategoryId") int workCategoryId, Model model) throws IOException {
		return WebConstants.Views.SKILL_TEST_QUESTION;
	}
	
	@RequestMapping("/u/skill/{workCategoryId}/test/question/complete")
	public String completeQuestion(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("workCategoryId") int workCategoryId, Model model) throws IOException {
		//return WebConstants.Views.SKILL_TEST_QUESTION_COMPLETE;
		return WebConstants.Views.SKILL_TEST_QUESTION_TIMEOUT;
	}
}