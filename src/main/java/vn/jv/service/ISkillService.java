package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.Skill;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
public interface ISkillService extends IBaseService {
	public List<Skill> findAll();

	public Skill findById(Integer skillId);
	
	public List<Skill> findByIds(List<Integer> skillIds);
}
