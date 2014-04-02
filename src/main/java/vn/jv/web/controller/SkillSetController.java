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
import vn.jv.persist.domain.User;
import vn.jv.persist.domain.WorkCategory;
import vn.jv.security.bean.JvUserDetails;
import vn.jv.service.IUserService;
import vn.jv.service.IWorkCategoryService;
import vn.jv.web.bean.ScoreUserBean;
import vn.jv.web.common.util.SecurityUtil;

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
	@Autowired
	private IUserService userService;
	@RequestMapping("/u/skills/list")
	public String viewSkillSet(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		JvUserDetails userDetail = SecurityUtil.getUserDetail();
		User jvUser = userDetail.getJvUser();
		List<ScoreUserBean> scoreUserBeans = userService.findMaxScoreByUser(jvUser);
		model.addAttribute("scoreUserBeans",scoreUserBeans);
		List<WorkCategory> workCategories = workCategoryService.findAll();
		model.addAttribute("workCategories",workCategories);
		return WebConstants.Views.SKILL_SET;
	}
	
}
