package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the work_category database table.
 * 
 */
@Entity
@Table(name="work_category")
@NamedQuery(name="WorkCategory.findAll", query="SELECT w FROM WorkCategory w")
public class WorkCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="WORK_CATEGORY_ID")
	private int workCategoryId;

	private String domain;
	
	private String technology;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="workCategory")
	private List<Job> jobs;

	//bi-directional many-to-one association to TQuestion
	@OneToMany(mappedBy="workCategory")
	private List<TQuestion> tQuestions;

	//bi-directional many-to-one association to WorkCategory
	@ManyToOne
	@JoinColumn(name="PARENT_WORK_CATEGORY_ID")
	private WorkCategory workCategory;

	//bi-directional many-to-one association to WorkCategory
	@OneToMany(mappedBy="workCategory")
	private List<WorkCategory> workCategories;



	public WorkCategory() {
	}

	public WorkCategory(int workCategoryId) {
		this.workCategoryId = workCategoryId;
	}
	
	public WorkCategory(int workCategoryId, String domain, String technology) {
		this.workCategoryId = workCategoryId;
		this.domain = domain;
		this.technology = technology;
	}
	
	public int getWorkCategoryId() {
		return this.workCategoryId;
	}

	public void setWorkCategoryId(int workCategoryId) {
		this.workCategoryId = workCategoryId;
	}

	public String getTechnology() {
		return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setWorkCategory(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setWorkCategory(null);

		return job;
	}

	public List<TQuestion> getTQuestions() {
		return this.tQuestions;
	}

	public void setTQuestions(List<TQuestion> TQuestions) {
		this.tQuestions = TQuestions;
	}

	public TQuestion addTQuestion(TQuestion TQuestion) {
		getTQuestions().add(TQuestion);
		TQuestion.setWorkCategory(this);

		return TQuestion;
	}

	public TQuestion removeTQuestion(TQuestion TQuestion) {
		getTQuestions().remove(TQuestion);
		TQuestion.setWorkCategory(null);

		return TQuestion;
	}

	public WorkCategory getWorkCategory() {
		return this.workCategory;
	}

	public void setWorkCategory(WorkCategory workCategory) {
		this.workCategory = workCategory;
	}

	public List<WorkCategory> getWorkCategories() {
		return this.workCategories;
	}

	public void setWorkCategories(List<WorkCategory> workCategories) {
		this.workCategories = workCategories;
	}

	public WorkCategory addWorkCategory(WorkCategory workCategory) {
		getWorkCategories().add(workCategory);
		workCategory.setWorkCategory(this);

		return workCategory;
	}

	public WorkCategory removeWorkCategory(WorkCategory workCategory) {
		getWorkCategories().remove(workCategory);
		workCategory.setWorkCategory(null);

		return workCategory;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}