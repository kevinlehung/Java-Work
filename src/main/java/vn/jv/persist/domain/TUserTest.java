package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_user_test database table.
 * 
 */
@Entity
@Table(name="t_user_test")
@NamedQuery(name="TUserTest.findAll", query="SELECT t FROM TUserTest t")
public class TUserTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="T_USER_TEST_ID")
	private int tUserTestId;

	@Column(name="CORRECT_COUNT")
	private int correctCount;

	private int duration;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FINISHED_DATED")
	private Date finishedDated;

	@Column(name="RETEST_COUNT")
	private int retestCount;

	private int score;

	//bi-directional many-to-one association to TTest
	@ManyToOne
	@JoinColumn(name="TEST_ID")
	private TTest tTest;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public TUserTest() {
	}

	public int getTUserTestId() {
		return this.tUserTestId;
	}

	public void setTUserTestId(int tUserTestId) {
		this.tUserTestId = tUserTestId;
	}

	public int getCorrectCount() {
		return this.correctCount;
	}

	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getFinishedDated() {
		return this.finishedDated;
	}

	public void setFinishedDated(Date finishedDated) {
		this.finishedDated = finishedDated;
	}

	public int getRetestCount() {
		return this.retestCount;
	}

	public void setRetestCount(int retestCount) {
		this.retestCount = retestCount;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public TTest getTTest() {
		return this.tTest;
	}

	public void setTTest(TTest TTest) {
		this.tTest = TTest;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}