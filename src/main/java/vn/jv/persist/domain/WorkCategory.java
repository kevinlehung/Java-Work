package vn.jv.persist.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;


/**
 * The persistent class for the work_category database table.
 * 
 */
@Entity
@Table(name="work_category")
@NamedQuery(name="WorkCategory.findAll", query="SELECT w FROM WorkCategory w")
public class WorkCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="WORK_CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AccessType("property")
	private int workCategoryId;

	private String domain;

	private String technology;

	public WorkCategory(int workCategoryId, String domain, String technology) {
		this.workCategoryId = workCategoryId;
		this.domain = domain;
		this.technology = technology;
	}
	
	public WorkCategory() {
	}

	public int getWorkCategoryId() {
		return this.workCategoryId;
	}

	public void setWorkCategoryId(int workCategoryId) {
		this.workCategoryId = workCategoryId;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTechnology() {
		return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

}