package vn.jv.persist.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the job database table.
 * 
 */
@Entity
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	public interface Status {
		public static final String OPENING = "OPENING";
		public static final String CLOSED = "CLOSED";
	}
	
	public interface SalaryType {
		public static final String FIXED_PRICE = "FIXED_PRICE";
		public static final String PER_HOUR = "PER_HOUR";
		public static final String PER_MONTH = "PER_MONTH";
	}
	
	public interface SalaryTypeText {
		public static final String FIXED_PRICE = "Fixed Price";
		public static final String PER_HOUR = "Hourly";
		public static final String PER_MONTH = "Monthly";
	}
	
	public static Map<String,String> SALARY_TYPE_TEXT_MAPPING = new HashMap<String, String>();
	static {
		SALARY_TYPE_TEXT_MAPPING.put(SalaryType.FIXED_PRICE, SalaryTypeText.FIXED_PRICE);
		SALARY_TYPE_TEXT_MAPPING.put(SalaryType.PER_HOUR, SalaryTypeText.PER_HOUR);
		SALARY_TYPE_TEXT_MAPPING.put(SalaryType.PER_MONTH, SalaryTypeText.PER_MONTH);
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JOB_ID")
	private int jobId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="CUSTOM_REQUIRED_SKILL")
	private String customRequiredSkill;

	private String description;

	@Column(name="OTHER_OPTION")
	private String otherOption;

	@Column(name="SALARY_FROM_AMOUNT")
	private double salaryFromAmount;

	@Column(name="SALARY_TO_AMOUNT")
	private double salaryToAmount;

	@Column(name="SALARY_TYPE")
	private String salaryType;

	private String status;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	//bi-directional many-to-one association to WorkCategory
	@ManyToOne
	@JoinColumn(name="WORK_CATEGORY_ID")
	private WorkCategory workCategory;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CITY_ID")
	private City city;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="CREATE_USER_ID")
	private User createUser;

	//bi-directional many-to-one association to JobApply
	@OneToMany(mappedBy="job")
	private List<JobApply> jobApplies;

	//bi-directional many-to-one association to JobSkill
	@OneToMany(mappedBy="job")
	private List<JobSkill> jobSkills;

	public Job() {
	}
	
	public Job(int jobId) {
		this.jobId = jobId;
	}
	
	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomRequiredSkill() {
		return this.customRequiredSkill;
	}

	public void setCustomRequiredSkill(String customRequiredSkill) {
		this.customRequiredSkill = customRequiredSkill;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOtherOption() {
		return this.otherOption;
	}

	public void setOtherOption(String otherOption) {
		this.otherOption = otherOption;
	}

	public double getSalaryFromAmount() {
		return this.salaryFromAmount;
	}

	public void setSalaryFromAmount(double salaryFromAmount) {
		this.salaryFromAmount = salaryFromAmount;
	}

	public double getSalaryToAmount() {
		return this.salaryToAmount;
	}

	public void setSalaryToAmount(double salaryToAmount) {
		this.salaryToAmount = salaryToAmount;
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

	public WorkCategory getWorkCategory() {
		return this.workCategory;
	}

	public void setWorkCategory(WorkCategory workCategory) {
		this.workCategory = workCategory;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public List<JobApply> getJobApplies() {
		return this.jobApplies;
	}

	public void setJobApplies(List<JobApply> jobApplies) {
		this.jobApplies = jobApplies;
	}

	public JobApply addJobApply(JobApply jobApply) {
		getJobApplies().add(jobApply);
		jobApply.setJob(this);

		return jobApply;
	}

	public JobApply removeJobApply(JobApply jobApply) {
		getJobApplies().remove(jobApply);
		jobApply.setJob(null);

		return jobApply;
	}

	public List<JobSkill> getJobSkills() {
		return this.jobSkills;
	}

	public void setJobSkills(List<JobSkill> jobSkills) {
		this.jobSkills = jobSkills;
	}

	public JobSkill addJobSkill(JobSkill jobSkill) {
		getJobSkills().add(jobSkill);
		jobSkill.setJob(this);

		return jobSkill;
	}

	public JobSkill removeJobSkill(JobSkill jobSkill) {
		getJobSkills().remove(jobSkill);
		jobSkill.setJob(null);

		return jobSkill;
	}

}