package vn.jv.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import vn.jv.validator.constraint.NumberCheck;

/**
 * Validator for NumberCheck annotation
 * @author hunglevn@outlook.com
 *
 */
public class NumberCheckValidator implements ConstraintValidator<NumberCheck, String> {
	
	public void initialize(NumberCheck constraintAnnotation) {
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}