package vn.jv.persist.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the t_option database table.
 * 
 */
@Entity
@Table(name="t_option")
public class TOption implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="T_OPTION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tOptionId;

	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="IS_KEY")
	private Boolean isKey;
	
	@Column(name="QUESTION_ID")
	private int questionId;
	
	public TOption() {
		
	}

	public int gettOptionId() {
		return tOptionId;
	}

	public void settOptionId(int tOptionId) {
		this.tOptionId = tOptionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsKey() {
		return isKey;
	}

	public void setIsKey(Boolean isKey) {
		this.isKey = isKey;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
}
