package vn.jv.db.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import vn.jv.db.entity.UserPassword;
import vn.jv.util.Lib;

public class UserPasswordDAO extends BaseDAO<Integer, UserPassword> implements IUserPasswordDAO {
	
	private static final String FIND_BY_USER_ID = 
			"FROM UserPassword up WHERE up.user.userId = :userId ORDER BY up.dateCreated DESC";
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UserPassword> findByUserId(Integer userId, final int numberResult) {
		try {
			final Map<String, Object> map = Lib.buildParamsMap(new String[] { "userId" }, new Object[] { userId });
			Query q = em.createQuery(FIND_BY_USER_ID);
			if(map != null) {
				Iterator<String> paramNames = map.keySet().iterator();
				while(paramNames.hasNext()) {
					String paramName = paramNames.next();
					Object paramValue = map.get(paramName);
					q.setParameter(paramName, paramValue);
				}
			}
			q.setMaxResults(numberResult);
			return q.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Failed to find UserPassword by [userId=" + userId + ", numberResult=" + numberResult + "]", e);
		}
	}
}
