package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the domain database table.
 * 
 */
@Entity
@NamedQuery(name="Domain.findAll", query="SELECT d FROM Domain d")
public class Domain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOMAIN_ID")
	private int domainId;

	private String description;

	@Column(name="DOMAIN_NAME")
	private String domainName;

	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="domain")
	private List<Skill> skills;

	public Domain() {
	}

	public Domain(String domainName) {
		this.domainName = domainName;
	}

	public int getDomainId() {
		return this.domainId;
	}

	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Skill addSkill(Skill skill) {
		getSkills().add(skill);
		skill.setDomain(this);

		return skill;
	}

	public Skill removeSkill(Skill skill) {
		getSkills().remove(skill);
		skill.setDomain(null);

		return skill;
	}


}