package vn.jv.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.jv.constant.WebConstants;
import vn.jv.db.dao.IUserLoginDAO;

@Controller
public class SignInController extends BaseController {
	@Autowired
	@Qualifier("userLoginDAO")
	private IUserLoginDAO userLoginDAO;
	
    @RequestMapping("/sign_in")
    public ModelAndView showLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(WebConstants.Views.SIGN_IN, "model", model);
    }
	
    @RequestMapping("/sign_in_fail")
    public ModelAndView loginFail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
        String error = "Invalid Username or Password.";
		model.put("error", error);
        return new ModelAndView(WebConstants.Views.SIGN_IN, "model", model);
    }
    
    @RequestMapping("/sessionExpired")
    public ModelAndView sessionExpired(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView(WebConstants.Views.SESSION_EXPIRED);
    }

}
