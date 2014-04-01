package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the t_test database table.
 * 
 */
@Entity
@Table(name = "t_test")
@NamedQuery(name = "TTest.findAll", query = "SELECT t FROM TTest t")
public class TTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEST_ID")
	private int testId;

	@Column(name = "DATE_CREATED")
	private Timestamp dateCreated;

	@Column(name = "DATE_UPDATED")
	private Timestamp dateUpdated;

	@Column(name = "TOTAL_QUESTION")
	private int totalQuestion;

	@Column(name = "TOTAL_TIME")
	private int totalTime;

	// bi-directional many-to-one association to TTestQuestion
	@OneToMany(mappedBy = "tTest")
	private List<TTestQuestion> tTestQuestions;

	// bi-directional many-to-one association to TUserTest
	@OneToMany(mappedBy = "tTest")
	private List<TUserTest> tUserTests;

	public TTest() {
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public int getTotalQuestion() {
		return this.totalQuestion;
	}

	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public int getTotalTime() {
		return this.totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public List<TTestQuestion> getTTestQuestions() {
		return this.tTestQuestions;
	}

	public void setTTestQuestions(List<TTestQuestion> TTestQuestions) {
		this.tTestQuestions = TTestQuestions;
	}

	public TTestQuestion addTTestQuestion(TTestQuestion TTestQuestion) {
		getTTestQuestions().add(TTestQuestion);
		TTestQuestion.setTTest(this);

		return TTestQuestion;
	}

	public TTestQuestion removeTTestQuestion(TTestQuestion TTestQuestion) {
		getTTestQuestions().remove(TTestQuestion);
		TTestQuestion.setTTest(null);

		return TTestQuestion;
	}

	public List<TUserTest> getTUserTests() {
		return this.tUserTests;
	}

	public void setTUserTests(List<TUserTest> TUserTests) {
		this.tUserTests = TUserTests;
	}

	public TUserTest addTUserTest(TUserTest TUserTest) {
		getTUserTests().add(TUserTest);
		TUserTest.setTTest(this);

		return TUserTest;
	}

	public TUserTest removeTUserTest(TUserTest TUserTest) {
		getTUserTests().remove(TUserTest);
		TUserTest.setTTest(null);

		return TUserTest;
	}

}