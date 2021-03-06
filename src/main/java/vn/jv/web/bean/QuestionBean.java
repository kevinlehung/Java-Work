package vn.jv.web.bean;

import java.util.List;

/**
 * 
 * @author vodinh90@gmail.com
 * 
 */
public class QuestionBean {
	
	public interface Status {
		public static final String UNTESTED = "UNTESTED";
		public static final String TESTING = "TESTING";
		public static final String TESTED = "TESTED";
	}
	
	private int questionId;
	private String stem;
	private int duration;
	private boolean isMultipleChoice;
	private int sequence;
	private String status = Status.UNTESTED;
	private long startTime;

	private List<OptionBean> options;

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

	public List<OptionBean> getOptions() {
		return options;
	}

	public void setOptions(List<OptionBean> options) {
		this.options = options;
	}

	public boolean getIsMultipleChoice() {
		return isMultipleChoice;
	}

	public void setMultipleChoice(boolean isMultipleChoice) {
		this.isMultipleChoice = isMultipleChoice;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

}
