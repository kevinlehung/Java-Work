package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_test_question database table.
 * 
 */
@Entity
@Table(name="t_test_question")
@NamedQuery(name="TTestQuestion.findAll", query="SELECT t FROM TTestQuestion t")
public class TTestQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEST_QUESTION_ID")
	private int testQuestionId;

	private int sequence;

	//bi-directional many-to-one association to TQuestion
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private TQuestion tQuestion;

	//bi-directional many-to-one association to TTest
	@ManyToOne
	@JoinColumn(name="TEST_ID")
	private TTest tTest;

	public TTestQuestion() {
	}

	public int getTestQuestionId() {
		return this.testQuestionId;
	}

	public void setTestQuestionId(int testQuestionId) {
		this.testQuestionId = testQuestionId;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public TQuestion getTQuestion() {
		return this.tQuestion;
	}

	public void setTQuestion(TQuestion TQuestion) {
		this.tQuestion = TQuestion;
	}

	public TTest getTTest() {
		return this.tTest;
	}

	public void setTTest(TTest TTest) {
		this.tTest = TTest;
	}

}