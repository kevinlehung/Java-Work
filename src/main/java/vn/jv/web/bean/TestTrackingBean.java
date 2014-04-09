package vn.jv.web.bean;

import java.util.List;

import vn.jv.persist.domain.TTest;

/**
 *
 * @author vodinh90@gmail.com
 *
 */
public class TestTrackingBean {
	
	private TTest tTest;
	private List<QuestionBean> questionBeans;
	private int correctCount;
	private int currentQuestionSequence;
	private long currentStartTimeQuestion;
	
	public TTest gettTest() {
		return tTest;
	}
	public void settTest(TTest tTest) {
		this.tTest = tTest;
	}
	public List<QuestionBean> getQuestionBeans() {
		return questionBeans;
	}
	public void setQuestionBeans(List<QuestionBean> questionBeans) {
		this.questionBeans = questionBeans;
	}

	public int getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}

	public int getCurrentQuestionSequence() {
		return currentQuestionSequence;
	}

	public void setCurrentQuestionSequence(int currentQuestionSequence) {
		this.currentQuestionSequence = currentQuestionSequence;
	}

	public long getCurrentStartTimeQuestion() {
		return currentStartTimeQuestion;
	}

	public void setCurrentStartTimeQuestion(long currentStartTimeQuestion) {
		this.currentStartTimeQuestion = currentStartTimeQuestion;
	}
}
