package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the job_skill database table.
 * 
 */
@Entity
@Table(name="job_skill")
@NamedQuery(name="JobSkill.findAll", query="SELECT j FROM JobSkill j")
public class JobSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JOB_SKILL_ID")
	private int jobSkillId;

	//bi-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name="SKILL_ID")
	private Skill skill;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Job job;

	public JobSkill() {
	}

	public int getJobSkillId() {
		return this.jobSkillId;
	}

	public void setJobSkillId(int jobSkillId) {
		this.jobSkillId = jobSkillId;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}