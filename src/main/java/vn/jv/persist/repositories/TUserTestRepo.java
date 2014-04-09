package vn.jv.persist.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.TUserTest;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public interface TUserTestRepo  extends BaseRepo<TUserTest, Integer> , TUserTestCustomRepo {
	
	@Query("SELECT ut FROM TUserTest ut JOIN ut.user u JOIN ut.tTest t WHERE u.userId = :userId AND t.testId = :testId")
	public TUserTest findByUserIdAndTestId(@Param("userId") int userId, @Param("testId") int testId);
}
