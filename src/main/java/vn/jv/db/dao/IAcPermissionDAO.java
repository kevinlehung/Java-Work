package vn.jv.db.dao;

import java.util.List;
import java.util.Map;

import vn.jv.db.entity.AcAction;
import vn.jv.db.entity.AcPermission;
import vn.jv.db.entity.AcResource;

/**
 * 
 * @author Max
 *
 */
public interface IAcPermissionDAO extends IBaseDAO<Integer, AcPermission> {
	/**
	 * Find permissions for a given role
	 * @param roleId
	 * @return
	 */
	public Map<AcAction, AcResource> findPermissionsForRole(int roleId);
	
	public Map<AcAction, AcResource> findPermissionsForRoleFromCache(int roleId);
	/**
	 * Return the very first instance or null if not found
	 * @param acActionId
	 * @param acResourceId
	 * @return
	 */
	public AcPermission findPermissionByActionIdAndResourceId(int acActionId, int acResourceId);
	
	/**
	 * Find resource names by roleId, NOT including parent-child hierarchy defined in ac_role_hierarchy
	 * 
	 * @param roleId
	 * @return
	 */
	List<String> findResourceNamesByRoleId(int roleId);

	public List<AcPermission> findPermissionsByResourceId(Integer acResourceId);
}
