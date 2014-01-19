package vn.jv.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.jv.constant.WebConstants;
import vn.jv.db.dao.IUserLoginDAO;

@Controller
public class JobController extends BaseController {
	@Autowired
	@Qualifier("userLoginDAO")
	private IUserLoginDAO userLoginDAO;
	
    @RequestMapping("/jobs_list")
    public ModelAndView showLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(WebConstants.Views.JOBS_LIST, "model", model);
    }
}
