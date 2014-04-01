package vn.jv.web.form;

import java.util.Date;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Model Attribute for updating Education actions
 *
 * @author tthieucdl@gmail.com
 *
 */
public class UEducationForm {
	
	@NotBlank(message = "Institution Name is required")
	@Size(min = 2, max = 512, message = "Length of Institution Name must be from 2 to 512 characters")
	private String institutionName;

	@NotBlank(message = "Degree Type is required")
	@Size(min = 2, max = 512,  message = "Length of Degree Type must be from 2 to 512 characters")
	private String degreeType;
	
	@NotNull(message = "Graduation Start Date is required")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date graduationStartDate;
	
	@NotNull(message = "Graduation End Date is required")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date graduationEndDate;
	
	@Size(max = 1024,  message = "Length of Description must be less than 1024")
	private String description;
	
	private int userId;

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public Date getGraduationStartDate() {
		return graduationStartDate;
	}

	public void setGraduationStartDate(Date graduationStartDate) {
		this.graduationStartDate = graduationStartDate;
	}

	public Date getGraduationEndDate() {
		return graduationEndDate;
	}

	public void setGraduationEndDate(Date graduationEndDate) {
		this.graduationEndDate = graduationEndDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
