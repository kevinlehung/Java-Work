package vn.jv.web.bean;

import java.util.Date;
import java.util.List;

import vn.jv.persist.domain.City;
import vn.jv.persist.domain.Country;
import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.WorkCategory;

/**
 * This bean contains information relates to a job
 * 
 * @author hunglevn@outlook.com
 *
 */
public class JobViewBean {
	private String title;
	
	private String description;

	private List<Skill> requiredSkills;

	private String customRequiredSkill;
	
	private long salaryFromAmount;
	
	private long salaryToAmount;

	private String salaryType;
	
	private String otherOption;
	
	private WorkCategory workCategory;

	private City city;
	
	private Country country;
	
	private Date createdDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Skill> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(List<Skill> requiredSkills) {
		this.requiredSkills = requiredSkills;
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

	public String getOtherOption() {
		return otherOption;
	}

	public void setOtherOption(String otherOption) {
		this.otherOption = otherOption;
	}

	public WorkCategory getWorkCategory() {
		return workCategory;
	}

	public void setWorkCategory(WorkCategory workCategory) {
		this.workCategory = workCategory;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
