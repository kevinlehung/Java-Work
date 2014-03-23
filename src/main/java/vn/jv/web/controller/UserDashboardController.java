package vn.jv.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.jv.constant.WebConstants;

/**
 * This controller is for displaying the page: My Account => Overview
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class UserDashboardController extends BaseController {
	@RequestMapping("/u/dashboard")
	public String viewUserDashboard(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
}
