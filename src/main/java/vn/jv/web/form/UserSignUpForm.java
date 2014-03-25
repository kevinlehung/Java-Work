package vn.jv.web.form;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import vn.jv.persist.domain.User;
import vn.jv.validator.constraint.EnumCheck;

/**
 * Form for sign_up page
 * 
 * @author hunglevn@outlook.com
 *
 */
public class UserSignUpForm {
	@NotBlank(message = "Email address is required.")
	@Email(message = "Email address must be well-formed.")
	private String email;
	
	@Length (min = 6, max = 32, message = "Password length is between 6 to 32 characters.")
	private String password;
	
	private String confirmPassword;
	
	@AssertTrue(message = "You must accept user agreement.")
	private boolean acceptAgreement;
	
	/**
	 * HIRE/WORK
	 */
	@EnumCheck(enumValues = {User.PURPOSE.HIRE, User.PURPOSE.WORK}, message = "Do you want to hire or work?")
	private String purpose;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isAcceptAgreement() {
		return acceptAgreement;
	}

	public void setAcceptAgreement(boolean acceptAgreement) {
		this.acceptAgreement = acceptAgreement;
	}
	
	
}
