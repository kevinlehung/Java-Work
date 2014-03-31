package vn.jv.web.form;

import java.util.Date;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Model Attribute for Updated Education Actions
 *
 * @author tthieucdl@gmail.com
 *
 */
public class UCertificationForm {
	
	private int certificationId;
	
	@NotBlank(message = "Conferring Organization is required")
	@Size(min = 2, max = 512, message = "Length of Conferring Organization must be from 2 to 512 characters")
	private String conferringOrganization;
	
	@NotBlank(message = "Professional Certificate is required")
	@Size(min = 2, max = 512, message = "Length of Professinal Certificate must be from 2 to 512 characters")
	private String professionalCertificate;
	
	@NotNull(message = "Date Awarded is required")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dateAwarded;
	
	private String certificateNumber;
	
	private String description;
	
	private int userId;

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}
	
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

}
