package vn.jv.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.jv.constant.WebConstants;

/**
 * This Controller is for displaying applied jobs of user in past
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class JobHistoryController extends BaseController {
	@RequestMapping("/u/job/history")
	public String viewJobHistory(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		return WebConstants.Views.USER_JOBS_HISTORY;
	}
}