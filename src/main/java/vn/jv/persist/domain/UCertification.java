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

/**
 * The persistent class for the u_certification table.
 * 
 */
@Entity
@Table(name = "u_certification")
public class UCertification implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CERTIFICATION_ID")
	private Integer certificationId;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@Column(name = "CONFERRING_ORGANIZATION")
	private String conferringOrganization;

	@Column(name = "PROFESSIONAL_CERTIFICATE")
	private String professionalCertificate;

	@Column(name = "DATE_AWARDED")
	private Date dateAwarded;

	@Column(name = "CERTIFICATE_NUMBER")
	private String certificateNumber;

	@Column(name = "DESCRIPTION")
	private String description;

	public UCertification() {
	}

	public UCertification(User user, String conferringOrganization,
			String professionalCertificate, Date dateAwarded) {
		this.user = user;
		this.conferringOrganization = conferringOrganization;
		this.professionalCertificate = professionalCertificate;
		this.dateAwarded = dateAwarded;
	}

	public UCertification(User user, String conferringOrganization,
			String professionalCertificate, Date dateAwarded,
			String certificateNumber, String description) {
		this.user = user;
		this.conferringOrganization = conferringOrganization;
		this.professionalCertificate = professionalCertificate;
		this.dateAwarded = dateAwarded;
		this.certificateNumber = certificateNumber;
		this.description = description;
	}

	public Integer getCertificationId() {
		return this.certificationId;
	}

	public void setCertificationId(Integer certificationId) {
		this.certificationId = certificationId;
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

	public String getProfessionalCertificate() {
		return this.professionalCertificate;
	}

	public void setProfessionalCertificate(String professionalCertificate) {
		this.professionalCertificate = professionalCertificate;
	}

	public Date getDateAwarded() {
		return this.dateAwarded;
	}

	public void setDateAwarded(Date dateAwarded) {
		this.dateAwarded = dateAwarded;
	}

	public String getCertificateNumber() {
		return this.certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
