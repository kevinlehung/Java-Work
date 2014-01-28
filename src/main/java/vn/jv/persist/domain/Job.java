package vn.jv.persist.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;

import java.util.Date;


/**
 * The persistent class for the job database table.
 * 
 */
@Entity
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JOB_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AccessType("property")
	private int jobId;

	@Column(name="CREATE_USER_ID")
	private int createUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	private String description;

	@Column(name="REQUIRED_SKILL")
	private String requiredSkill;

	@Column(name="SALARY_AMOUNT")
	private int salaryAmount;

	@Column(name="SALARY_TYPE")
	private String salaryType;

	private String status;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	@Column(name="WORK_CATEGORY_ID")
	private int workCategoryId;

	public Job() {
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequiredSkill() {
		return this.requiredSkill;
	}

	public void setRequiredSkill(String requiredSkill) {
		this.requiredSkill = requiredSkill;
	}

	public int getSalaryAmount() {
		return this.salaryAmount;
	}

	public void setSalaryAmount(int salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public String getSalaryType() {
		return this.salaryType;
	}

	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getWorkCategoryId() {
		return this.workCategoryId;
	}

	public void setWorkCategoryId(int workCategoryId) {
		this.workCategoryId = workCategoryId;
	}

}