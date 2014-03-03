package vn.jv.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import vn.jv.validator.constraint.AssertEqual;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public class AssertEqualValidator implements ConstraintValidator<AssertEqual, String> {
	double value;
	public void initialize(AssertEqual constraintAnnotation) {
		this.value = constraintAnnotation.value();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return this.value == Double.parseDouble(value);
	}

}
