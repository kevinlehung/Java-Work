package vn.jv.persist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.TUserTest;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
public interface TUserTestRepo extends BaseRepo<TUserTest, Integer>,TUserTestCustomRepo {
	public static final String FIND_MAXSCORE_BY_USER = "SELECT MAX(ut.score), sk.skillId, sk.name FROM TUserTest ut"
			+ " JOIN ut.tTest t JOIN t.skill sk"
			+ " WHERE ut.user.userId = :userId"
			+ " GROUP BY sk.skillId";
	/**
	 * Find test max score each skill of user.
	 * 
	 * @param userId
	 * @return
	 */
    @Query(FIND_MAXSCORE_BY_USER)
	public List<Object[]> findMaxScoreByUser(@Param("userId") int userId);
}
