package vn.jv.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.jv.constant.WebConstants;

/**
 * Controller for actions relate to skills.
 * 
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class SkillSetController extends BaseController {
	@RequestMapping("/u/skills/list")
	public String viewSkillSet(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		return WebConstants.Views.SKILL_SET;
	}
}
