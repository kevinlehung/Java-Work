package vn.jv.persist.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the t_user_test database table.
 * 
 */
@Entity
@Table(name="t_user_test")
public class TUserTest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="T_USER_TEST_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tUserTestId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="TEST_ID")
	private int testId;
	
	@Column(name="DURATION")
	private int duration;
	
	@Column(name="CORRECT_COUNT")
	private int correctCount;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="RETEST_COUNT")
	private int retestCount;
	
	@Column(name="FINISHED_DATED")
	private Date finishedDated;
	
	public TUserTest() {
		
	}

	public int gettUserTestId() {
		return tUserTestId;
	}

	public void settUserTestId(int tUserTestId) {
		this.tUserTestId = tUserTestId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRetestCount() {
		return retestCount;
	}

	public void setRetestCount(int retestCount) {
		this.retestCount = retestCount;
	}

	public Date getFinishedDated() {
		return finishedDated;
	}

	public void setFinishedDated(Date finishedDated) {
		this.finishedDated = finishedDated;
	}
}
