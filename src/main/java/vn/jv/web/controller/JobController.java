package vn.jv.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JobController extends BaseController {
	@RequestMapping(value="/jobs_list", method = RequestMethod.GET)
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		return "jobs_list";
	}
}
