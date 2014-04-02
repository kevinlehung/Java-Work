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
import vn.jv.security.bean.JvUserDetails;
import vn.jv.service.IUserService;
import vn.jv.web.bean.ScoreUserBean;
import vn.jv.web.common.util.SecurityUtil;

/**
 * This controller is for displaying skills of user
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class UserSkillController extends BaseController {
	@Autowired
	private IUserService userService;
	@RequestMapping("/u/skills")
	public String viewUserSkills(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		JvUserDetails userDetail = SecurityUtil.getUserDetail();
		User jvUser = userDetail.getJvUser();
		List<ScoreUserBean> scoreUserBeans = userService.findMaxScoreByUser(jvUser);
		model.addAttribute("scoreUserBeans",scoreUserBeans);
		return WebConstants.Views.USER_SKILLS;
	}
}