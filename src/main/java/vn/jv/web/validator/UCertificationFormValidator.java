package vn.jv.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vn.jv.web.form.UCertificationForm;

/**
 * Validator for UCertification form
 *
 * @author tthieucdl@gmail.com
 *
 */
public class UCertificationFormValidator implements Validator {

	public boolean supports(Class<?> candidate) {
		// TODO Auto-generated method stub
		return UCertificationForm.class.isAssignableFrom(candidate);
	}

	public void validate(Object target, Errors errors) {
		UCertificationForm uCertificationForm = (UCertificationForm)target;
	}

}
