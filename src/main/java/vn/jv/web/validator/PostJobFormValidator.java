package vn.jv.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vn.jv.web.form.PostJobForm;

/**
 * Validator for post job form
 * 
 * @author hunglevn@outlook.com
 *
 */
public class PostJobFormValidator implements Validator {

	public boolean supports(Class<?> candidate) {
		return PostJobForm.class.isAssignableFrom(candidate);
	}

	public void validate(Object target, Errors errors) {
		PostJobForm postJobForm = (PostJobForm)target;
		
		
	}

}
