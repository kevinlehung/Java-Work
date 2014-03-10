package vn.jv.persist.repositories;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.Skill;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
public interface SkillRepo extends BaseRepo<Skill, Integer>, SkillCustomRepo<Skill, Integer> {
}
