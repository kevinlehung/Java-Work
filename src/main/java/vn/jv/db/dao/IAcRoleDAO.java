package vn.jv.db.dao;

import java.util.List;

import vn.jv.db.entity.AcRole;
import vn.jv.db.entity.AcRoleUser;
import vn.jv.db.entity.RoleMenuItem;

/**
 * DAO used to interact with Role
 * @author Max
 *
 */
public interface IAcRoleDAO extends IBaseDAO<Integer, AcRole> {
	/**
	 * Return main roles for given userId which are mapped in ac_role_user table, NOT
	 * including parent-child hierarchy defined in ac_role_hierarchy 
	 * @param userId
	 * @return
	 */
	public List<AcRole> findMainRolesByUserId(int userId);

	/**
	 * Return main roles for given userEmail which are mapped in ac_role_user table, NOT
	 * including parent-child hierarchy defined in ac_role_hierarchy 
	 * @param userEmail
	 * @return
	 */
	public List<AcRole> findMainRolesByUserEmail(String userEmail);
	
	/**
	 * Return parent roles (recursively) for a given roleId which are mapped in ac_role_hierarchy table
	 * @param roleId
	 * @return
	 */
	public List<AcRole> findParentRoles(int roleId);
	
	public List<AcRole> findParentRolesFromCache(int roleId);
	
	/**
	 * Return child roles (recursively) for a given roleId which are mapped in ac_role_hierarchy table
	 * @param roleId
	 * @return
	 */
	public List<AcRole> findChildRoles(int roleId);
	
	/**
	 * Return all roles (main and parent defined in both
	 * ac_role_user and ac_role_hierarchy tables) for given userId
	 * @param userId
	 * @return
	 */
	public List<AcRole> findAllRoles(int userId);
	
	/**
	 * Return all roles (main and parent defined in both
	 * ac_role_user and ac_role_hierarchy tables) for given userEmail
	 * @param userEmail
	 * @return
	 */
	public List<AcRole> findAllRoles(String userEmail);
	
	/**
	 * Return the very first instance or null if not found
	 * @param roleName
	 * @return
	 */
	public AcRole findByRoleName(String roleName);
	/*
	 * Get all roles Order by Role name asc
	 * @return list roles in acRole table
	 */
	public List<AcRole> getAllRolesAlphabetalic();
	/**
	 * Return List AcRoleUser object for given userId which are mapped in ac_role_user table, NOT
	 * including parent-child hierarchy defined in ac_role_hierarchy 
	 * @param userId
	 * @return
	 */
	public List<AcRoleUser> findAcRoleUserByUserId(int userId);
	/**
	 * Return List AcRole object for given MenuItemId which are mapped in role_menu_item table
	 * @param menuItemId
	 * @return
	 */
	
	public List<AcRole> findAcRoleByMenuId(int menuItemId);
	/**
	 * Return List AcRole object which it is not in for given MenuItemId which are mapped in role_menu_item table
	 * @param menuItemId
	 * @return
	 */
	public List<AcRole> findAcRoleNotInMenuId(int menuItemId);
	/**
	 * Return List RoleMenuItem object for given MenuItemId which are mapped in role_menu_item table
	 * @param menuItemId
	 * @return
	 */
	public List<RoleMenuItem> findRoleMenuItemByMenuItemId(int menuItemId);
	
	/**
	 * Return List AcRole object which it have not assigned for userId which
	 * are mapped in ac_role_user table
	 * 
	 * @param userId
	 * @return
	 */
	List<AcRole> findAcRoleNotAssignedUserId(int userId);
	
	/**
	 * Return available roles (recursively) for a given roleId. They are used for assigning parent roles for a role
	 * @param roleId
	 * @return
	 */
	public List<AcRole> findAvailableRoles(int roleId);
	
	/**
	 * Return direct parent roles (not recursively) for a given roleId.
	 * @param roleId
	 * @return
	 */
	public List<AcRole> findDirectParentRoles(int roleId);
	
	/**
	 * Return the unavailable Role list. 
	 * These roles are used. So, you can not remove them from AcRoleUser table.
	 * @param userId
	 * @return
	 */
	List<AcRole> findUnAvailableByUserId(int userId);
}
