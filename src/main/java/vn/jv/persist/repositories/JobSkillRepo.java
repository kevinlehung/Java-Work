package vn.jv.persist.repositories;

import java.util.List;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.Job;
import vn.jv.persist.domain.JobSkill;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface JobSkillRepo extends BaseRepo<JobSkill, Integer>, JobSkillCustomRepo<JobSkill, Integer> {
	public List<JobSkill> findByJob(Job job);
}
