package vn.jv.persist.repositories;

import java.util.List;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.WorkCategory;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
public interface SkillRepo extends BaseRepo<Skill, Integer>, SkillCustomRepo<Skill, Integer> {
	
	List<Skill> findByWorkCategory(WorkCategory workCategory);
}
