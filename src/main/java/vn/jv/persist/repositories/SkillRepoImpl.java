package vn.jv.persist.repositories;

import javax.persistence.EntityManager;

import vn.jv.persist.domain.Skill;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
public class SkillRepoImpl extends BaseRepo<Skill, Integer> implements ISkillCustomRepo {

	public SkillRepoImpl(Class<Skill> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}

}
