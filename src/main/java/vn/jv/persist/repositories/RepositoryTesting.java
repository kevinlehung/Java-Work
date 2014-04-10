package vn.jv.persist.repositories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.TOption;
import vn.jv.persist.domain.TQuestion;
import vn.jv.persist.domain.User;


public class RepositoryTesting {
	public static void main(String args[]) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RepoConfig.class);
		TQuestionRepo tQuestionRepo = ctx.getBean(TQuestionRepo.class);
		TOptionRepo tOptionRepo = ctx.getBean(TOptionRepo.class);
		UserRepo userRepo = ctx.getBean(UserRepo.class);
		SkillRepo skillRepo = ctx.getBean(SkillRepo.class);
		User user = userRepo.findOne(29);
		Skill skill = skillRepo.findOne(2);
		for (int i = 36; i < 56; i++ ) {
			TQuestion tQuestion = new TQuestion();
			tQuestion.setSkill(skill);
			tQuestion.setUser(user);
			tQuestion.setStem("Question " + i);
			tQuestion.setDuration(60);
			tQuestionRepo.save(tQuestion);
			for (int j = 0; j < 4; j++) {
				TOption tOption = new TOption();
				tOption.setDescription("Option " + i + " - " + (j+1));
				tOption.setTQuestion(tQuestion);
				if (j == 3) {
					tOption.setIsKey(true);
				}
				tOptionRepo.save(tOption);
			}
		}
	}
}
