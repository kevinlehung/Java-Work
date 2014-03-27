package vn.jv.persist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.TQuestion;

public interface TQuestionRepo extends BaseRepo<TQuestion, Integer>, TQuestionCustomRepo {
	
	@Query(value = "SELECT * FROM T_QUESTION WHERE SKILL_ID = :skillId AND QUESTION_ID NOT IN (:listIds) ORDER BY RAND() LIMIT :numOfQuestion", nativeQuery = true)
	public List<TQuestion> getRandomTQuestionBySkillIdAndDifferFromTestedQuestionByNativeQuery(@Param("skillId")int skillId, 
																			@Param("numOfQuestion")int numOfQuestion,
																			@Param("listIds") List<Integer> testedIds);
	
	@Query(value = "SELECT * FROM T_QUESTION WHERE SKILL_ID = :skillId ORDER BY RAND() LIMIT :numOfQuestion", nativeQuery = true)
	public List<TQuestion> getRandomTQuestionBySkillIdAndDifferFromTestedQuestionByNativeQuery(@Param("skillId")int skillId, @Param("numOfQuestion")int numOfQuestion);
	
	@Query("SELECT tq.questionId FROM TQuestion tq JOIN tq.tTestQuestions ttq JOIN ttq.tTest tt JOIN tt.tUserTests tut WHERE tq.skill.skillId = :skillId AND tut.user.userId = :userId")
	public List<Integer> getTestedQuestionIdsBySkillIdAndUserId(@Param("skillId") int skilId, @Param("userId") int userId);
}
