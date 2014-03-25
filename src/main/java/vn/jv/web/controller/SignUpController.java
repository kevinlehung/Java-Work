package vn.jv.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.jv.constant.WebConstants;
import vn.jv.persist.domain.User;
import vn.jv.service.IUserService;
import vn.jv.web.form.UserSignUpForm;
import vn.jv.web.validator.UserSignUpFormValidator;

/**
 * Process sign-up.
 * 
 * Auto login after sign-up successfully.
 * 
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class SignUpController extends BaseController {
    @Autowired@Qualifier("jvAuthenticationManager")
    protected AuthenticationManager authenticationManager;
    
	@Autowired
	IUserService userService;
	
	@Autowired
	UserSignUpFormValidator userSignUpFormValidator;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userSignUpFormValidator);
    }
	
	@RequestMapping(value="/sec/sign_up", method = RequestMethod.GET)
    public ModelAndView showSignUpPage(HttpServletRequest request, HttpServletResponse response, @ModelAttribute UserSignUpForm userSignUpForm) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		//request.setAttribute("userSignUpForm", new UserSignUpForm());
        return new ModelAndView(WebConstants.Views.SIGN_UP, "model", model);
    }
	
    @RequestMapping(value="/sec/sign_up", method = RequestMethod.POST)
    public String doSignup(HttpServletRequest request, HttpServletResponse response,
    		@Valid @ModelAttribute UserSignUpForm userSignUpForm, BindingResult result) throws IOException {
		boolean hasError = result.hasErrors();
		if (!hasError) {
			User user = userService.createUser(userSignUpForm.getEmail(), userSignUpForm.getPassword(), userSignUpForm.getPurpose());
			authenticateUserAndSetSession(user, request);
			return WebConstants.Views.SIGN_UP_SUCCESS;
		} else {
			return WebConstants.Views.SIGN_UP;
		}
    }
    
	private void authenticateUserAndSetSession(User user,
			HttpServletRequest request) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				user.getUserEmail(), user.getUserPassword());

		// generate session if one doesn't exist
		request.getSession();

		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager
				.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}

}