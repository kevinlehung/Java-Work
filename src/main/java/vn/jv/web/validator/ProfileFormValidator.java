package vn.jv.web.validator;

import org.apache.commons.lang.StringUtils;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vn.jv.web.form.ProfileForm;

/**
 * Used for validating Profile Form
 * @author tthieucdl@gmail.com
 *
 */
public class ProfileFormValidator implements Validator {

	public boolean supports(Class<?> candidate) {
		return ProfileForm.class.isAssignableFrom(candidate);
	}

	public void validate(Object target, Errors errors) {
		ProfileForm profileForm = (ProfileForm) target;
		
		if(profileForm.isSimpleCheck()) {
			//valid Overview
			if((StringUtils.isEmpty(profileForm.getOverview())) 
					|| (profileForm.getOverview().length()<3) || (profileForm.getOverview().length()>1024)) {
				errors.rejectValue("overview", "overviewError","Length of Overview must be from 3 to 1024 characters");
			}
			
			//valid Service Description
			if((StringUtils.isNotEmpty(profileForm.getServiceDescription())) 
					&& ((profileForm.getServiceDescription().length()<3) || (profileForm.getServiceDescription().length()>1024))) {
				errors.rejectValue("serviceDescription", "serviceDesriptionError", "Length of Service Description must be from 3 to 1024 characters");
			}
		} else {
			// valid TagLine
			if((StringUtils.isEmpty(profileForm.getTagline())) 
					|| (profileForm.getTagline().length()<3) || (profileForm.getTagline().length()>128)) {
				errors.rejectValue("tagline", "taglineError", "Length of Tagline must be from 3 to 128 characters");
			}
			
			//valid Overview
			if((StringUtils.isEmpty(profileForm.getOverview())) 
					|| (profileForm.getOverview().length()<3) || (profileForm.getOverview().length()>1024)) {
				errors.rejectValue("overview", "overviewError","Length of Overview must be from 3 to 1024 characters");
			}
			
			//valid Hourly Rate
			if(profileForm.getHourlyRate()<0) {
				errors.rejectValue("hourlyRate", "hourlyRateError","Hourly Rate must be greater than or equal 0");
			}
			
			//valid Experience
			if((StringUtils.isEmpty(profileForm.getExperience())) 
					|| (profileForm.getExperience().length()<3) || (profileForm.getExperience().length()>1024)) {
				errors.rejectValue("experience", "experienceError", "Length of Experience must be from 3 to 1024 characters");
			}
			
			//valid Service Description
			if((StringUtils.isNotEmpty(profileForm.getServiceDescription())) 
					&& ((profileForm.getServiceDescription().length()<3) || (profileForm.getServiceDescription().length()>1024))) {
				errors.rejectValue("serviceDescription", "serviceDescriptionError", "Length of Service Description must be from 3 to 1024 characters");
			}
		}
	}

}
