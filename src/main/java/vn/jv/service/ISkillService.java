package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.User;
import vn.jv.web.bean.QuestionBean;
import vn.jv.web.bean.SkillBean;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
public interface ISkillService extends IBaseService {
	public List<Skill> findAll();

	public Skill findById(Integer skillId);
	
	public List<Skill> findByIds(List<Integer> skillIds);
	
	public List<SkillBean> findByWorkCategoryId(int workCategoryId);
	
	public List<QuestionBean> findQuestionBySkillIdAndDifferFormTestedQuestions(int skillId, User currentUser, int numOfQuestion, Integer practiceQuestionId);
	
	public QuestionBean getRandomPracticeQuestion(int skillId, User currentUser);
}
