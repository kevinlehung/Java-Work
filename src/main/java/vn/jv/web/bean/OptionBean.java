package vn.jv.web.bean;

/**
*
* @author vodinh90@gmail.com
*
*/
public class OptionBean {
	private Integer optionId;
	private String description;
	private Boolean isKey;
	private Boolean isChoiced;
	
	public Integer getOptionId() {
		return optionId;
	}
	
	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
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

	public Boolean getIsChoiced() {
		return isChoiced;
	}

	public void setIsChoiced(Boolean isChoiced) {
		this.isChoiced = isChoiced;
	}
}
