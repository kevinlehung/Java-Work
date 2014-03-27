package vn.jv.web.bean;

import java.io.Serializable;

/**
 *
 * @author jeff
 *
 */
public class SkillBean implements Serializable {
	private int skillId;
	private String skillName;
	private int workCategoryId;

	public SkillBean() {
		
	}
	
	public SkillBean(int skillId, String skillName, int workCategoryId) {
		this.skillId = skillId;
		this.skillName = skillName;
		this.workCategoryId = workCategoryId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getWorkCategoryId() {
		return workCategoryId;
	}

	public void setWorkCategoryId(int workCategoryId) {
		this.workCategoryId = workCategoryId;
	}


	
}
