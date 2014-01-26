package vn.jv.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.jv.constant.WebConstants;
import vn.jv.service.IUserService;
import vn.jv.web.form.UserSignUpForm;
import vn.jv.web.validator.UserSignUpFormValidator;

@Controller(value="/sec/sign_up")
public class SignUpController extends BaseController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	UserSignUpFormValidator userSignUpFormValidator;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userSignUpFormValidator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView showSignUpPage(HttpServletRequest request, HttpServletResponse response, @ModelAttribute UserSignUpForm userSignUpForm) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		//request.setAttribute("userSignUpForm", new UserSignUpForm());
        return new ModelAndView(WebConstants.Views.SIGN_UP, "model", model);
    }
	
    @RequestMapping(method = RequestMethod.POST)
    public String doSignup(HttpServletRequest request, HttpServletResponse response,
    		@Valid @ModelAttribute UserSignUpForm userSignUpForm, BindingResult result) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		boolean hasError = result.hasErrors();
		if (!hasError) {
			userService.createUser(userSignUpForm.getEmail(), userSignUpForm.getPassword(), userSignUpForm.getPurpose());
			return WebConstants.Views.SIGN_UP_SUCCESS;
		} else {
			return WebConstants.Views.SIGN_UP;
		}
    }

}