package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.TQuestion;
import vn.jv.persist.domain.TTest;
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
	
	public List<TQuestion> getTestQuestions(int skillId, User currentUser, int numOfQuestion, Integer practiceQuestionId);
	
	public QuestionBean getRandomPracticeQuestion(int skillId, User currentUser);
	
	public QuestionBean  getQuestionBeanByQuestionId(int questionId);

	public TTest saveTestInforOfUser(int skillId, List<TQuestion> tQuestions, User user, List<QuestionBean> questionBeans);
	
	public List<QuestionBean> buildListQuestionBean(List<TQuestion> tQuestions);
}
