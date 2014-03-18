package vn.jv.persist.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the t_question database table.
 * 
 */
@Entity
@Table(name="t_question")
public class TQuestion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="QUESTION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	
	@Column(name="STEM")
	private String stem;
	
	@Column(name="IS_MULTIPLE_CHOICE")
	private Boolean isMultipleChoice;
	
	@Column(name="DURATION")
	private int duration;
	
	@Column(name="TEST_ID")
	private int testId;
	
	public TQuestion() {
		
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getStem() {
		return stem;
	}

	public void setStem(String stem) {
		this.stem = stem;
	}

	public Boolean getIsMultipleChoice() {
		return isMultipleChoice;
	}

	public void setIsMultipleChoice(Boolean isMultipleChoice) {
		this.isMultipleChoice = isMultipleChoice;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}
	
}
