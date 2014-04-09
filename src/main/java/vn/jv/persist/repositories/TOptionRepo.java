package vn.jv.persist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.TOption;

/**
*
* @author vodinh90@gmail.com
*
*/
public interface TOptionRepo extends BaseRepo<TOption, Integer>, TOptionCustomRepo {
	
	@Query("FROM TOption to WHERE to.tQuestion.questionId = :questionId")
	public List<TOption> findByTQuestionId(@Param("questionId") int questionId);
	
	@Query("SELECT to.tOptionId FROM TOption to WHERE to.tQuestion.questionId = :questionId AND to.isKey = true")
	public List<Integer> findKeyOptionByQuestionId(@Param("questionId") int questionId);
}
