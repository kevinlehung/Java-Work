package vn.jv.persist.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the t_test database table.
 * 
 */
@Entity
@Table(name="t_test")
public class TTest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="TEST_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TOTAL_QUESTION")
	private int totalQuestion;
	
	@Column(name="TOTAL_TIME")
	private int totalTime;
	
	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;
	
	@Column(name="DATE_UPDATED")
	private Timestamp dateUpdated;
	
	@Column(name="WORK_CATEGORY_ID")
	private int workCategoryId;
	
	@Column(name="CREATED_USER_ID")
	private int createdUserId;

	public TTest() {
		
	}
	
	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public int getWorkCategoryId() {
		return workCategoryId;
	}

	public void setWorkCategoryId(int workCategoryId) {
		this.workCategoryId = workCategoryId;
	}

	public int getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(int createdUserId) {
		this.createdUserId = createdUserId;
	}
}
