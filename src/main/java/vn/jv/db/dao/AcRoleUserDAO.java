package vn.jv.db.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import vn.jv.db.entity.AcRole;
import vn.jv.db.entity.AcRoleUser;
import vn.jv.util.Lib;

@Component
public class AcRoleUserDAO extends BaseDAO<Integer, AcRoleUser> implements IAcRoleUserDAO {

	/**
	 * Return the very first instance or null if not found
	 * @param userId
	 * @param acRoleId
	 * @return
	 */
	public AcRoleUser findByUserIdAndRoleId(int userId, int acRoleId) {
		AcRoleUser acRoleUser = null;
		
		try {
			String query = "SELECT ru FROM AcRoleUser ru " +
					"WHERE ru.user.userId = :userId AND ru.acRole.acRoleId = :acRoleId";
			Map<String, Object> map = Lib.buildParamsMap(new String[] {"userId", "acRoleId"}, new Integer[] {userId, acRoleId});
			List<AcRoleUser> list = findByNamedQuery(query, map);
			if(list !=null && !list.isEmpty()) {
				acRoleUser =  list.get(0);
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to find AcPermission by [userId=" + userId + ", acRoleId=" + acRoleId + "]", e);
		}
		
		return acRoleUser;

	}

	/***
	 * Return list AcRole object for given userId
	 * 
	 * @param userId
	 * @return
	 */
	public List<AcRole> findAcRoleByUserId(int userId) {
		try {
			String query = "SELECT ru.acRole FROM AcRoleUser ru "
					+ "WHERE ru.user.userId = :userId";
			Map<String, Object> map = Lib.buildParamsMap("userId", userId);
			List<AcRole> list = findByNamedQuery(query, map);
			if (list != null && !list.isEmpty()) {
				return list;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to find AcRole by [userId=" + userId + "]", e);
		}
	}
		
	/**
	 * Return the available role list. 
	 * These roles are used. So, you can remove them from AcRoleUser table.
	 * @param userId
	 * @return
	 */
	public List<AcRoleUser> findAvailableByUserId(int userId){
		try {
			String query = " SELECT ru FROM AcRoleUser ru JOIN ru.user u " +
					 	   " WHERE u.userId = :userId AND ru " +
					 	   " NOT IN (SELECT rui FROM LoanBatchImagePage lbip JOIN lbip.acRoleUser rui)" +
					 	   " AND ru NOT IN (SELECT rid FROM DocumentDe de JOIN de.acRoleUser rid)";
			Map<String, Object> map = Lib.buildParamsMap("userId", userId);
			List<AcRoleUser> list = findByNamedQuery(query, map);
			if (list != null) {
				return list;
			}
			return Collections.EMPTY_LIST;
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to find available AcRoleUser by [userId=" + userId + "]", e);
		}
	}

}
