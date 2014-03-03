package vn.jv.web.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import vn.jv.persist.domain.Job;
import vn.jv.validator.constraint.EnumCheck;

/**
 * Backing form object for Post Job feature.
 * 
 * @author hunglevn@outlook.com
 *
 */
public class PostJobForm {
	@NotBlank(message = "Title for the job is required.")
	@Size(min = 8, max = 64, message = "Length of title must be from 8 to 64 characters")
	private String title;
	
	@NotBlank(message = "Description for the job is required.")
	@Size(min = 32, max = 1024, message = "Length of description must be from 32 to 1024 characters")
	private String description;

	private List<Integer> requiredSkillIds;

	@NotBlank(message = "Skills for the job is required.")
	@Size(min = 16, max = 1024, message = "Length of description must be from 16 to 512 characters")
	private String customRequiredSkill;
	
	private long salaryFromAmount;
	
	private long salaryToAmount;

	@EnumCheck(enumValues = {Job.SalaryType.FIXED_PRICE, Job.SalaryType.PER_HOUR, Job.SalaryType.PER_MONTH})
	private String salaryType;
	
	private String otherOption;
	
	@Min(value = 1, message = "Must select a catefory of work.")
	private int workCategoryId;

	private int cityId;
	
	private int countryId;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getRequiredSkillIds() {
		return requiredSkillIds;
	}

	public void setRequiredSkillIds(List<Integer> requiredSkillIds) {
		this.requiredSkillIds = requiredSkillIds;
	}

	public String getCustomRequiredSkill() {
		return customRequiredSkill;
	}

	public void setCustomRequiredSkill(String customRequiredSkill) {
		this.customRequiredSkill = customRequiredSkill;
	}

	public long getSalaryFromAmount() {
		return salaryFromAmount;
	}

	public void setSalaryFromAmount(long salaryFromAmount) {
		this.salaryFromAmount = salaryFromAmount;
	}

	public long getSalaryToAmount() {
		return salaryToAmount;
	}

	public void setSalaryToAmount(long salaryToAmount) {
		this.salaryToAmount = salaryToAmount;
	}
	
	public String getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOtherOption() {
		return otherOption;
	}

	public void setOtherOption(String otherOption) {
		this.otherOption = otherOption;
	}

	public int getWorkCategoryId() {
		return workCategoryId;
	}

	public void setWorkCategoryId(int workCategoryId) {
		this.workCategoryId = workCategoryId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	
}