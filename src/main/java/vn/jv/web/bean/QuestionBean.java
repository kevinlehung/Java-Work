package vn.jv.web.bean;

import java.util.List;

/**
*
* @author vodinh90@gmail.com
*
*/
public class QuestionBean {
	private Integer questionId;
	private String stem;
	private boolean isMultipleChoice;
	private List<OptionBean> options;
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
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
}
