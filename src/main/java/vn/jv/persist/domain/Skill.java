package vn.jv.persist.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;


/**
 * The persistent class for the skill database table.
 * 
 */
@Entity
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SKILL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AccessType("property")
	private int skillId;

	private String description;

	private String name;

	public Skill() {
	}

	public int getSkillId() {
		return this.skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}