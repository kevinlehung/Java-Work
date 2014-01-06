package vn.jv.db.dao;

import java.util.List;

import vn.jv.db.entity.AcRolePermission;

public interface IAcRolePermissionDAO extends IBaseDAO<Integer, AcRolePermission> {
	
	/**
	 * Return the very first instance or null if not found
	 * @param acRoleId
	 * @param acPermissionId
	 * @return
	 */
	public AcRolePermission findByRoleIdAndPermissionId(int acRoleId, int acPermissionId);
	
	/**
	 * Find all AcRolePermission by acRoleId and acResourceId
	 * 
	 * @param acRoleId
	 * @param acResourceId
	 * @return
	 */
	List<AcRolePermission> findByRoleIdAndResourceId(int acRoleId, int acResourceId);
	
	List<AcRolePermission> findByPermissionId(int permissionId);
}
