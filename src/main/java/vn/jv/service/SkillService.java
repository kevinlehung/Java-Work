package vn.jv.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.City;
import vn.jv.persist.domain.Country;
import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.TOption;
import vn.jv.persist.domain.TQuestion;
import vn.jv.persist.domain.User;
import vn.jv.persist.domain.WorkCategory;
import vn.jv.persist.repositories.SkillRepo;
import vn.jv.persist.repositories.TOptionRepo;
import vn.jv.persist.repositories.TQuestionRepo;
import vn.jv.web.bean.OptionBean;
import vn.jv.web.bean.QuestionBean;
import vn.jv.web.bean.SkillBean;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
@Service("skillService")
public class SkillService extends BaseService implements ISkillService {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SkillRepo skillRepo;
	
	@Autowired
	TQuestionRepo tQuestionRepo;
	
	@Autowired
	TOptionRepo tOptionRepo;
	
	@Cacheable("SkillService.findAll")
	public List<Skill> findAll() {
		return skillRepo.findAll();
	}

	public List<Skill> findByIds(List<Integer> skillIds) {
		List<Skill> skills = new ArrayList<Skill>();
		if (skillIds != null) {
			for (Integer skillId : skillIds) {
				Skill skill = findById(skillId);
				skills.add(skill);
			}
		}
		return skills;
	}

	@Cacheable(value = {"SkillService.findById"}, key = "#skillId")
	public Skill findById(Integer skillId) {
		return skillRepo.findOne(skillId);
	}
	
	@Cacheable(value = "SkillService.findByWorkCategoryId", key="#workCategoryId")
	public List<SkillBean> findByWorkCategoryId(int workCategoryId) {
		List<Skill> skills = skillRepo.findByWorkCategory(new WorkCategory(workCategoryId));
		List<SkillBean> skillBeans = new ArrayList<SkillBean>();
		for (Skill skill : skills) {
			skillBeans.add(new SkillBean(skill.getSkillId(), skill.getName(), skill.getWorkCategory().getWorkCategoryId()));
		}
		return skillBeans;
	}
	
	public List<QuestionBean> findQuestionBySkillIdAndDifferFormTestedQuestions(int skillId, User currentUser, int numOfQuestion, Integer practiceQuestionId) {
		List<QuestionBean> questionBeans = null;
		List<TQuestion> randomQuestions = null;
		//get list of tested question ids of current user
		List<Integer> testedQuestionIds = tQuestionRepo.getTestedQuestionIdsBySkillIdAndUserId(skillId, currentUser.getUserId());
		if ((testedQuestionIds == null || testedQuestionIds.isEmpty()) && practiceQuestionId == null) {
			randomQuestions = tQuestionRepo.getRandomTQuestionBySkillIdAndDifferFromTestedQuestionByNativeQuery(skillId, numOfQuestion);
		} else {
			if (testedQuestionIds != null && !testedQuestionIds.contains(practiceQuestionId)) {
				testedQuestionIds.add(practiceQuestionId);
			} else {
				testedQuestionIds = new ArrayList<Integer>();
				testedQuestionIds.add(practiceQuestionId);
			}
			randomQuestions = tQuestionRepo.getRandomTQuestionBySkillIdAndDifferFromTestedQuestionByNativeQuery(skillId, numOfQuestion, testedQuestionIds);
		}
		if (randomQuestions == null || randomQuestions.isEmpty()) {
			return questionBeans;
		}
		questionBeans = buildListQuestionBean(randomQuestions);
		return questionBeans;
	}
	
	public QuestionBean getRandomPracticeQuestion(int skillId, User currentUser) {
		List<QuestionBean> questionBeans = findQuestionBySkillIdAndDifferFormTestedQuestions(skillId, currentUser, 1, null);
		if (questionBeans == null || questionBeans.isEmpty()) {
			return null;
		}
		return questionBeans.get(0);
	}
	
	private List<QuestionBean> buildListQuestionBean(List<TQuestion> tQuestions) {
		List<QuestionBean> questionBeans = new ArrayList<QuestionBean>();
		for (TQuestion tQuestion : tQuestions) {
			QuestionBean questionBean = new QuestionBean();
			questionBean.setQuestionId(tQuestion.getQuestionId());
			questionBean.setStem(tQuestion.getStem());
			questionBean.setMultipleChoice(tQuestion.getIsMultipleChoice());
			List<TOption> tOptions = tOptionRepo.findByTQuestionId(tQuestion.getQuestionId());
			questionBean.setOptions(buildListOptionBean(tOptions));
			
			questionBeans.add(questionBean);
		}
		return questionBeans;
	}
	
	private List<OptionBean> buildListOptionBean(List<TOption> tOptions) {
		List<OptionBean> optionBeans = new ArrayList<OptionBean>();
		if (tOptions == null || tOptions.isEmpty()) {
			return optionBeans;
		}
		for (TOption tOption : tOptions) {
			OptionBean optionBean = new OptionBean();
			optionBean.setOptionId(tOption.getTOptionId());
			optionBean.setDescription(tOption.getDescription());
			
			optionBeans.add(optionBean);
		}
		return optionBeans;
	}

}
