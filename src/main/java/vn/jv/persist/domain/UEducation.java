package vn.jv.persist.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the u_education table.
 * 
 */
@Entity
@Table(name = "u_education")
public class UEducation implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EDUCATION_ID")
	private int educationId;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@Column(name = "INSTITUTION_NAME")
	private String institutionName;

	@Column(name = "DEGREE_TYPE")
	private String degreeType;

	@Column(name = "GRADUATION_START_DATE")
	private Date graduationStartDate;

	@Column(name = "GRADUATION_END_DATE")
	private Date graduationEndDate;

	@Column(name = "DESCRIPTION")
	private String description;

	public UEducation() {
	}

	public UEducation(int educationId, User user, String institutionName,
			String degreeType, Date graduationStartDate, Date graduationEndDate) {
		this.educationId = educationId;
		this.user = user;
		this.institutionName = institutionName;
		this.degreeType = degreeType;
		this.graduationStartDate = graduationStartDate;
		this.graduationEndDate = graduationEndDate;
	}

	public UEducation(int educationId, User user, String institutionName,
			String degreeType, Date graduationStartDate,
			Date graduationEndDate, String description) {
		this.educationId = educationId;
		this.user = user;
		this.institutionName = institutionName;
		this.degreeType = degreeType;
		this.graduationStartDate = graduationStartDate;
		this.graduationEndDate = graduationEndDate;
		this.description = description;
	}

	public int getEducationId() {
		return this.educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getInstitutionName() {
		return this.institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getDegreeType() {
		return this.degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public Date getGraduationStartDate() {
		return this.graduationStartDate;
	}

	public void setGraduationStartDate(Date graduationStartDate) {
		this.graduationStartDate = graduationStartDate;
	}

	public Date getGraduationEndDate() {
		return this.graduationEndDate;
	}

	public void setGraduationEndDate(Date graduationEndDate) {
		this.graduationEndDate = graduationEndDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
