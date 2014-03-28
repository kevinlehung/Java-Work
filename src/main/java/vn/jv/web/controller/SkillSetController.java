package vn.jv.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.jv.constant.WebConstants;
import vn.jv.persist.domain.WorkCategory;
import vn.jv.service.IWorkCategoryService;

/**
 * Controller for actions relate to skills.
 * 
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class SkillSetController extends BaseController {
	@Autowired
	private IWorkCategoryService workCategoryService;
	@RequestMapping("/u/skills/list")
	public String viewSkillSet(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		List<WorkCategory> workCategories = workCategoryService.findAll();
		model.addAttribute("workCategories",workCategories);
		return WebConstants.Views.SKILL_SET;
	}
	
}
