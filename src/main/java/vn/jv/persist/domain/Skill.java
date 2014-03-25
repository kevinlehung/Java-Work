package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the skill database table.
 * 
 */
@Entity
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SKILL_ID")
	private int skillId;

	private String description;

	private String name;

	//bi-directional many-to-one association to JobSkill
	@OneToMany(mappedBy="skill")
	private List<JobSkill> jobSkills;

	//bi-directional many-to-one association to Domain
	@ManyToOne
	@JoinColumn(name="WORK_CATEGORY_ID")
	private WorkCategory workCategory;

	public Skill() {
	}

	public Skill(int skillId) {
		this.skillId = skillId;
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

	public List<JobSkill> getJobSkills() {
		return this.jobSkills;
	}

	public void setJobSkills(List<JobSkill> jobSkills) {
		this.jobSkills = jobSkills;
	}

	public JobSkill addJobSkill(JobSkill jobSkill) {
		getJobSkills().add(jobSkill);
		jobSkill.setSkill(this);

		return jobSkill;
	}

	public JobSkill removeJobSkill(JobSkill jobSkill) {
		getJobSkills().remove(jobSkill);
		jobSkill.setSkill(null);

		return jobSkill;
	}

	public WorkCategory getWorkCategory() {
		return workCategory;
	}

	public void setWorkCategory(WorkCategory workCategory) {
		this.workCategory = workCategory;
	}


}