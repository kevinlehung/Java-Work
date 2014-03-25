package vn.jv.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.jv.constant.WebConstants;

public class PasswordController  extends BaseController {
	
    @RequestMapping("/forgot_password")
    public ModelAndView showForgotPasswordPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(WebConstants.Views.FORGOT_PASSWORD, "model", model);
    }
	
    @RequestMapping("/reset_password")
    public ModelAndView resetPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(WebConstants.Views.PASSWORD_IS_SENT, "model", model);
    }

}