package vn.jv.persist.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the u_license table.
 * 
 */
@Entity
@Table(name = "u_license")
public class ULicense implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "LICENSE_ID")
	private Integer licenseId;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "CONFERRING_ORGANIZATION")
	private String conferringOrganization;

	@Column(name = "PROFESSIONAL_LICENSE")
	private String professionalLicense;

	@Column(name = "DATE_ISSUED")
	@DateTimeFormat(pattern = vn.jv.constant.WebConstants.FixValue.DEFAULT_DATE_FORMAT)
	@Temporal(TemporalType.DATE)
	private Date dateIssued;

	@Column(name = "LICENSE_NUMBER")
	private String licenseNumber;

	@Column(name = "DESCRIPTION")
	private String description;

	public ULicense() {
	}

	public ULicense(String conferringOrganization, String professionalLicense,
			Date dateIssued) {
		this.conferringOrganization = conferringOrganization;
		this.professionalLicense = professionalLicense;
		this.dateIssued = dateIssued;
	}

	public ULicense(User user, String conferringOrganization,
			String professionalLicense, Date dateIssued, String licenseNumber,
			String description) {
		this.user = user;
		this.conferringOrganization = conferringOrganization;
		this.professionalLicense = professionalLicense;
		this.dateIssued = dateIssued;
		this.licenseNumber = licenseNumber;
		this.description = description;
	}

	public Integer getLicenseId() {
		return this.licenseId;
	}

	public void setLicenseId(Integer licenseId) {
		this.licenseId = licenseId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getConferringOrganization() {
		return this.conferringOrganization;
	}

	public void setConferringOrganization(String conferringOrganization) {
		this.conferringOrganization = conferringOrganization;
	}

	public String getProfessionalLicense() {
		return this.professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

	public Date getDateIssued() {
		return this.dateIssued;
	}

	public void setDateIssued(Date dateIssued) {
		this.dateIssued = dateIssued;
	}

	public String getLicenseNumber() {
		return this.licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
