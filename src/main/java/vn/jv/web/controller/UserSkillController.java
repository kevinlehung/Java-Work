package vn.jv.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.jv.constant.WebConstants;

/**
 * This controller is for displaying skills of user
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class UserSkillController extends BaseController {
	@RequestMapping("/u/skills")
	public String viewUserSkills(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		return WebConstants.Views.USER_SKILLS;
	}
}