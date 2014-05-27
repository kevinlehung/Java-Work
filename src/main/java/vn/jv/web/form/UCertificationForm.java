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
public class UCertificationForm {
	
	private int uCertificationId;
	
	@NotBlank(message = "Conferring Organization is required")
	@Size(min = 2, max = 512, message = "Length of Conferring Organization must be from 2 to 512 characters")
	private String conferringOrganization;
	
	@NotBlank(message = "Professional Certificate is required")
	@Size(min = 2, max = 512, message = "Length of Professinal Certificate must be from 2 to 512 characters")
	private String professionalCertificate;
	
	@NotNull(message = "Date Awarded is required")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dateAwarded;
	
	@Size(max = 128,  message = "Length of Certificate Number must be less than 128")
	private String certificateNumber;
	
	@Size(max = 1024,  message = "Length of Description must be less than 1024")
	private String description;
	
	private int userId;
	
	public String getConferringOrganization() {
		return conferringOrganization;
	}

	public void setConferringOrganization(String conferringOrganization) {
		this.conferringOrganization = conferringOrganization;
	}

	public String getProfessionalCertificate() {
		return professionalCertificate;
	}

	public void setProfessionalCertificate(String professionalCertificate) {
		this.professionalCertificate = professionalCertificate;
	}

	public Date getDateAwarded() {
		return dateAwarded;
	}

	public void setDateAwarded(Date dateAwarded) {
		this.dateAwarded = dateAwarded;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
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

	public int getuCertificationId() {
		return uCertificationId;
	}

	public void setuCertificationId(int uCertificationId) {
		this.uCertificationId = uCertificationId;
	}

}
