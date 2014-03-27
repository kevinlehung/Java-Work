package vn.jv.persist.repositories;

import org.springframework.data.jpa.repository.Query;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.TTest;

/**
*
* @author vodinh90@gmail.com
*
*/
public interface TTestRepo extends BaseRepo<TTest, Integer>, TTestCustomRepo<TTest, Integer> {
	
	@Query("SELECT t FROM TTest t WHERE t.testId = ?")
	public TTest findById(Integer tTestId);
}
