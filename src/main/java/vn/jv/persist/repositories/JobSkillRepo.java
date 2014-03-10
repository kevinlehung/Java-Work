package vn.jv.persist.repositories;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.JobSkill;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface JobSkillRepo extends BaseRepo<JobSkill, Integer>, JobSkillCustomRepo<JobSkill, Integer> {

}
