package vn.jv.persist.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;


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
	@Column(name="JOB_SKILL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AccessType("property")
	private int jobSkillId;

	@Column(name="JOB_ID")
	private int jobId;

	@Column(name="SKILL_ID")
	private int skillId;

	public JobSkill() {
	}

	public int getJobSkillId() {
		return this.jobSkillId;
	}

	public void setJobSkillId(int jobSkillId) {
		this.jobSkillId = jobSkillId;
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getSkillId() {
		return this.skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

}