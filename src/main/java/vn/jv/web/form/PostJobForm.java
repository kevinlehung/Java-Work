package vn.jv.web.form;

/**
 * Backing form object for Post Job feature.
 * 
 * @author hunglevn@outlook.com
 *
 */
public class PostJobForm {
	private String title;
	
	private String description;

	private String requiredSkill;

	private int salaryAmount;

	private String salaryType;

	private String status;

	private int workCategoryId;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequiredSkill() {
		return requiredSkill;
	}

	public void setRequiredSkill(String requiredSkill) {
		this.requiredSkill = requiredSkill;
	}

	public int getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(int salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public String getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWorkCategoryId() {
		return workCategoryId;
	}

	public void setWorkCategoryId(int workCategoryId) {
		this.workCategoryId = workCategoryId;
	}

	
}
