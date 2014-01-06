package vn.jv.db.dao;

import java.util.List;

import vn.jv.db.entity.AcRole;
import vn.jv.db.entity.AcRoleUser;

public interface IAcRoleUserDAO extends IBaseDAO<Integer, AcRoleUser> {
	/**
	 * Return the very first instance or null if not found
	 * 
	 * @param userId
	 * @param acRoleId
	 * @return
	 */
	public AcRoleUser findByUserIdAndRoleId(int userId, int acRoleId);

	/***
	 * Return list AcRole object for given userId
	 * 
	 * @param userId
	 * @return
	 */
	public List<AcRole> findAcRoleByUserId(int userId);
	
	/**
	 * Return the available role list. 
	 * These roles are used. So, you can remove them from AcRoleUser table.
	 * @param userId
	 * @return
	 */
	List<AcRoleUser> findAvailableByUserId(int userId);
}
