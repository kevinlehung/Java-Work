package vn.jv.web.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vn.jv.service.IUserService;
import vn.jv.web.form.UserSignUpForm;

/**
 * Validate UserSignUpForm bean.
 * UserSignUpForm is binded to form on sign-up page.
 * 
 * @author hunglevn@outlook.com
 *
 */
@Service
public class UserSignUpFormValidator implements Validator {
	@Autowired
	IUserService userService;
	
	public boolean supports(Class<?> candidate) {
		return UserSignUpForm.class.isAssignableFrom(candidate);
	}

	public void validate(Object target, Errors errors) {
		UserSignUpForm userSignUpForm = (UserSignUpForm)target;
		
		String email = userSignUpForm.getEmail();
		boolean emailIsRegisteredBefore = userService.emailIsRegisteredBefore(email);
		if (emailIsRegisteredBefore) {
			errors.rejectValue("email", "duplicated.email", null, "This email is not available.");
		}
		
		String password = userSignUpForm.getPassword();
		String confirmPassword = userSignUpForm.getConfirmPassword();
		
		if (StringUtils.isNotBlank(password) && !password.equals(confirmPassword)) {
			errors.rejectValue("confirmPassword", "match.password", null, "Please enter the same value again.");
		}
	}

}
