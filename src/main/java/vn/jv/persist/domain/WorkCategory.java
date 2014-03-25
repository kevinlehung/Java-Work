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

	@Column(name="WORK_CATEGORY_NAME")
	private String workCategoryName;
	
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


	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="workCategory")
	private List<Skill> skills;
	
	public WorkCategory() {
	}

	public WorkCategory(int workCategoryId) {
		this.workCategoryId = workCategoryId;
	}
	
	public WorkCategory(int workCategoryId, String workCategoryName, String technology) {
		this.workCategoryId = workCategoryId;
		this.workCategoryName = workCategoryName;
	}
	
	public int getWorkCategoryId() {
		return this.workCategoryId;
	}

	public void setWorkCategoryId(int workCategoryId) {
		this.workCategoryId = workCategoryId;
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

	public String getWorkCategoryName() {
		return workCategoryName;
	}

	public void setWorkCategoryName(String workCategoryName) {
		this.workCategoryName = workCategoryName;
	}

}