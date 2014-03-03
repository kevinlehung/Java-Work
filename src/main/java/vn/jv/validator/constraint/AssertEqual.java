package vn.jv.validator.constraint;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import vn.jv.validator.AssertEqualValidator;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Documented
@Constraint(validatedBy = {AssertEqualValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface AssertEqual {
	String message() default "{vn.jv.validator.constraint.AssertEqual.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	double value();
}
