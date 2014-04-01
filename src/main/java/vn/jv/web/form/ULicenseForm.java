package vn.jv.web.form;

import java.util.Date;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Model attribute for updating ULicense actions
 *
 * @author tthieucdl@gmail.com
 *
 */
public class ULicenseForm {
	
	@NotBlank(message = "Conferring Organization is required")
	@Size(min = 2, max = 512, message = "Length of Conferring Organization must be from 2 to 512 characters")
	private String conferringOrganization;
	
	@NotBlank(message = "Professional License is required")
	@Size(min = 2, max = 512, message = "Length of Professional License must be from 2 to 512 characters")
	private String professionalLicense;
	
	@NotNull(message = "Date Issued is required")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dateIssued;
	
	@Size(max = 128,  message = "Length of License Number must be less than 128")
	private String licenseNumber;
	
	@Size(max = 1024,  message = "Length of Description must be less than 1024")
	private String description;
	
	private int userId;

	public String getConferringOrganization() {
		return conferringOrganization;
	}

	public void setConferringOrganization(String conferringOrganization) {
		this.conferringOrganization = conferringOrganization;
	}

	public String getProfessionalLicense() {
		return professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

	public Date getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(Date dateIssued) {
		this.dateIssued = dateIssued;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
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
