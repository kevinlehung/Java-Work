package vn.jv.db.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaCallback;

import vn.jv.cache.CacheConstants;
import vn.jv.db.entity.AcRole;
import vn.jv.db.entity.AcRoleUser;
import vn.jv.db.entity.RoleMenuItem;
import vn.jv.db.entity.User;
import vn.jv.util.Lib;

/**
 * 
 * @author Max
 * 
 */
public class AcRoleDAO extends BaseDAO<Integer, AcRole> implements IAcRoleDAO {
	@Autowired
	@Qualifier("userDAO")
	private IUserDAO userDAO;

	/**
	 * Return main roles for given userEmail which are mapped in ac_role_user
	 * table, NOT including parent-child hierarchy defined in ac_role_hierarchy
	 * 
	 * @param userEmail
	 * @return
	 */
	public List<AcRole> findMainRolesByUserEmail(String userEmail) {
		User user = userDAO.findByEmail(userEmail);
		if (user == null) {
			throw new RuntimeException("User with email '" + userEmail
					+ "' does not exist");
		}
		return findMainRolesByUserId(user.getUserId());
	}

	/**
	 * Return main roles for given userId which are mapped in ac_role_user
	 * table, NOT including parent-child hierarchy defined in ac_role_hierarchy
	 * 
	 * @param userId
	 * @return
	 */
	public List<AcRole> findMainRolesByUserId(int userId) {
		try {
			String query = "SELECT ru.acRole FROM AcRoleUser ru WHERE ru.user.userId = :userId";
			Map<String, Object> map = Lib.buildParamsMap("userId", userId);
			return findByNamedQuery(query, map);
		} catch (Exception e) {
			throw new RuntimeException("Failed to find roles by user id '"
					+ userId + "'", e);
		}
	}

	/**
	 * Return List AcRoleUser object for given userId which are mapped in
	 * ac_role_user table, NOT including parent-child hierarchy defined in
	 * ac_role_hierarchy
	 * 
	 * @param userId
	 * @return
	 */
	public List<AcRoleUser> findAcRoleUserByUserId(int userId) {
		try {
			String query = "FROM AcRoleUser ru where ru.user.userId = :userId";
			Map<String, Object> map = Lib.buildParamsMap("userId", userId);
			return findByNamedQuery(query, map);
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to find AcRolesUser object by user id '" + userId
							+ "'", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AcRole> findParentRolesFromCache(int roleId) {
		String cacheName = CacheConstants.AcRoleDAO.FIND_PARENT_ROLES_CACHE;
		String valueKey = String.valueOf(roleId);
		List<AcRole> resultList = new ArrayList<AcRole>();
		if (cacheHelper.containsKey(cacheName, valueKey)) {
			resultList = (List<AcRole>) cacheHelper.getValueFromCache(cacheName, valueKey);
		} else {
			resultList = findParentRoles(roleId);
			cacheHelper.putToCache(cacheName, valueKey, resultList);
		}
		return resultList; 
	}
	/**
	 * Return parent roles (recursively) for a given roleId which are mapped in
	 * ac_role_hierarchy table
	 * 
	 * @param roleId
	 * @return
	 */
	public List<AcRole> findParentRoles(int roleId) {
		List<String> idsList = new ArrayList<String>();
		/**
		 * We use idsList to avoid infinite recursive
		 */
		idsList.add(roleId + "");
		try {
			String query = "SELECT rh.parentAcRole FROM AcRoleHierarchy rh WHERE rh.acRole.acRoleId = :roleId";
			Map<String, Object> map = Lib.buildParamsMap("roleId", roleId);
			List<AcRole> list = findByNamedQuery(query, map);
			List<AcRole> resultList = new ArrayList<AcRole>();
			
			for (AcRole acRole : list) {
				int childId = acRole.getAcRoleId();
				if (!idsList.contains(childId+ "")) {
					idsList.add(childId + "");
					resultList.add(acRole);
					List<AcRole> childList = findParentRolesRecursively(
							idsList, childId);
					if (!childList.isEmpty()) {
						resultList.addAll(childList);
					}
				}
			}
			return resultList;
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to find parent roles by role id [" + roleId + "]",
					e);
		}
	}

	private List<AcRole> findParentRolesRecursively(List<String> roleIdsList,
			int roleId) {
		String query = "SELECT rh.parentAcRole FROM AcRoleHierarchy rh WHERE rh.acRole.acRoleId = :roleId";
		Map<String, Object> map = Lib.buildParamsMap("roleId", roleId);
		List<AcRole> resultList = new ArrayList<AcRole>();
		List<AcRole> list = findByNamedQuery(query, map);
		
		for (AcRole acRole : list) {
			int childId = acRole.getAcRoleId();
			/**
			 * Check to avoid infinite recursive
			 */
			if (!roleIdsList.contains(childId + "")) {
				roleIdsList.add(childId + "");
				resultList.add(acRole);
				List<AcRole> childList = findParentRolesRecursively(
						roleIdsList, childId);
				if (!childList.isEmpty()) {
					resultList.addAll(childList);
				}
			}
		}
		return resultList;
	}
	
	/**
	 * Return available roles (recursively) for a given roleId. They are used for assigning parent roles for a role
	 * @param roleId
	 * @return
	 */
	public List<AcRole> findAvailableRoles(int roleId){
		List<AcRole> availableRoles = findAll();
		List<AcRole> unavailableRoles = new ArrayList<AcRole>();
		
		List<AcRole> parentRoles =	findDirectParentRoles(roleId);
		if(parentRoles != null && !parentRoles.isEmpty()){
			unavailableRoles.addAll(parentRoles);
		}
	
		AcRole currentRole = findById(roleId);
		if(currentRole != null ){
			unavailableRoles.add(currentRole);
		}
					
		//Remove Parent Role
		for (AcRole unavailableRole : unavailableRoles) {
			Iterator<AcRole> iRole = availableRoles.iterator();
			while (iRole.hasNext()) {
			   	AcRole role = iRole.next();
				if(unavailableRole.getAcRoleId() == role.getAcRoleId()){
					iRole.remove();
				}
			}
		}
				
		return availableRoles;
	}
	
		
	/**
	 * Return all roles (main and parent defined in both ac_role_user and
	 * ac_role_hierarchy tables) for given userId
	 * 
	 * @param userId
	 * @return
	 */
	public List<AcRole> findAllRoles(int userId) {
		List<AcRole> allRoles = new ArrayList<AcRole>();
		List<AcRole> mainRoles = findMainRolesByUserId(userId);
		allRoles.addAll(mainRoles);
		for (AcRole acRole : mainRoles) {
			int roleId = acRole.getAcRoleId();
			/**
			 * Find all parent roles recursively for this roleId
			 */
			List<AcRole> parentRoles = findParentRolesFromCache(roleId);
			if (!parentRoles.isEmpty()) {
				allRoles.addAll(parentRoles);
			}
		}
		/**
		 * Remove duplicate roles and inactive ones
		 */
		List<String> idsList = new ArrayList<String>();
		List<AcRole> uniqueRoles = new ArrayList<AcRole>();
		for (AcRole acRole : allRoles) {
			String id = acRole.getAcRoleId() + "";
			if (acRole.isActive() && !idsList.contains(id)) {
				uniqueRoles.add(acRole);
				idsList.add(id);
			}
		}
		return uniqueRoles;
	}

	/**
	 * Return all roles (main and parent defined in both ac_role_user and
	 * ac_role_hierarchy tables) for given userEmail
	 * 
	 * @param userEmail
	 * @return
	 */
	public List<AcRole> findAllRoles(String userEmail) {
		User user = userDAO.findByEmail(userEmail);
		if (user == null) {
			throw new RuntimeException("User with email '" + userEmail
					+ "' does not exist");
		}
		return findAllRoles(user.getUserId());
	}

	/**
	 * Return the very first instance or null if not found
	 * 
	 * @param roleName
	 * @return
	 */
	public AcRole findByRoleName(String roleName) {
		try {
			String query = "from AcRole r where r.roleName = :roleName";
			Map<String, Object> map = Lib.buildParamsMap("roleName", roleName);
			List<AcRole> list = findByNamedQuery(query, map);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find role by role name ["
					+ roleName + "]", e);
		}
	}

	public List<AcRole> getAllRolesAlphabetalic() {
		try {
			Query q = em.createQuery("Select r from AcRole r order by r.roleName ");
			return q.getResultList();
		} catch (Exception ex) {
			throw new RuntimeException(
					"Failed to get All Roles sorted by Alphabetalic " + ex);
		}
	}

	/**
	 * Return List AcRole object for given MenuItemId which are mapped in
	 * role_menu_item table
	 * 
	 * @param menuItemId
	 * @return
	 */
	public List<AcRole> findAcRoleByMenuId(int menuItemId) {
		try {
			String query = "SELECT rmi.acRole FROM RoleMenuItem rmi JOIN rmi.menuItem m WHERE m.menuItemId = :menuItemId";
			Map<String, Object> map = Lib.buildParamsMap("menuItemId",
					menuItemId);
			List<AcRole> lstAcRoles = findByNamedQuery(query,
					map);
			return lstAcRoles;
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to find RoleMenuItem object by menuItem id '"
							+ menuItemId + "'", e);
		}
	}

	/**
	 * Return List RoleMenuItem object for given MenuItemId which are mapped in
	 * role_menu_item table
	 * 
	 * @param menuItemId
	 * @return
	 */
	public List<RoleMenuItem> findRoleMenuItemByMenuItemId(int menuItemId) {
		try {
			String query = "FROM RoleMenuItem rm where rm.menuItem.menuItemId = :menuItemId";
			Map<String, Object> map = Lib.buildParamsMap("menuItemId",
					menuItemId);
			return findByNamedQuery(query, map);
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to find RoleMenuItem object by menuItem id '"
							+ menuItemId + "'", e);
		}
	}

	/**
	 * Return List AcRole object which it is not in for given MenuItemId which
	 * are mapped in role_menu_item table
	 * 
	 * @param menuItemId
	 * @return
	 */
	public List<AcRole> findAcRoleNotInMenuId(int menuItemId) {
		try {
			String query = "SELECT r FROM AcRole r where r not in (Select rm.acRole FROM RoleMenuItem rm where rm.menuItem.menuItemId = :menuItemId)";
			Map<String, Object> map = Lib.buildParamsMap("menuItemId",
					menuItemId);
			return findByNamedQuery(query, map);
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to find RoleMenuItem object by menuItem id '"
							+ menuItemId + "'", e);
		}

	}
	/**
	 * Return List AcRole object which it have not assigned for userId which
	 * are mapped in ac_role_user table
	 * 
	 * @param userId
	 * @return
	 */
	public List<AcRole> findAcRoleNotAssignedUserId(int userId) {
		try {
			String query = "SELECT r FROM AcRole r where r not in (Select rm.acRole FROM AcRoleUser rm where rm.user.userId = :userId)";
			Map<String, Object> map = Lib.buildParamsMap("userId",
					userId);
			return findByNamedQuery(query, map);
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to find AcRole object not assigned by userid '"
							+ userId + "'", e);
		}

	}

	public List<AcRole> findChildRoles(int roleId) {
		List<String> idsList = new ArrayList<String>();
		/**
		 * We use idsList to avoid infinite recursive
		 */
		idsList.add(roleId + "");
		try {
			String query = "SELECT DISTINCT rh.acRole FROM AcRoleHierarchy rh JOIN rh.parentAcRole pr WHERE pr.acRoleId = :roleId";
			Map<String, Object> map = Lib.buildParamsMap("roleId", roleId);
			List<AcRole> list = findByNamedQuery(query, map);
			List<AcRole> resultList = new ArrayList<AcRole>();
			for (AcRole acRole : list) {
				int childId = acRole.getAcRoleId();
				if (!idsList.contains(childId + "")) {
					idsList.add(childId + "");
					resultList.add(acRole);
					List<AcRole> childList = findChilcRolesRecursively(
							idsList, childId);
					if (!childList.isEmpty()) {
						resultList.addAll(childList);
					}
				}
			}
			return resultList;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find child roles by role id [" + roleId + "]", e);
		}
	}

	private List<AcRole> findChilcRolesRecursively(List<String> roleIdsList,
			int roleId) {
		String query = "SELECT DISTINCT rh.acRole FROM AcRoleHierarchy rh JOIN rh.parentAcRole pr WHERE pr.acRoleId = :roleId";
		Map<String, Object> map = Lib.buildParamsMap("roleId", roleId);
		List<AcRole> resultList = new ArrayList<AcRole>();
		List<AcRole> list = findByNamedQuery(query, map);
		for (AcRole acRole : list) {
			int childId = acRole.getAcRoleId();
			/**
			 * Check to avoid infinite recursive
			 */
			if (!roleIdsList.contains(childId + "")) {
				roleIdsList.add(childId + "");
				resultList.add(acRole);
				List<AcRole> childList = findParentRolesRecursively(
						roleIdsList, childId);
				if (!childList.isEmpty()) {
					resultList.addAll(childList);
				}
			}
		}
		return resultList;
	}
	
	public List<AcRole> findDirectParentRoles(int roleId) {
		try {
			String query = "SELECT rh.parentAcRole FROM AcRoleHierarchy rh JOIN rh.acRole r WHERE r.acRoleId = :roleId";
			Map<String, Object> map = Lib.buildParamsMap("roleId", roleId);
			List<AcRole> directParentRoles = findByNamedQuery(query, map);
			if(directParentRoles != null){
				return directParentRoles;
			}
			return Collections.EMPTY_LIST;
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to find direct parent roles by role id [" + roleId + "]",
					e);
		}
	}
	
	/**
	 * Return the unavailable Role list. 
	 * These roles are used. So, you can not remove them from AcRoleUser table.
	 * @param userId
	 * @return
	 */
	public List<AcRole> findUnAvailableByUserId(int userId){
		try {
			String query = " SELECT r FROM AcRoleUser ru JOIN ru.user u JOIN ru.acRole r" +
					 	   " WHERE u.userId = :userId AND ( ru " +
					 	   " IN (SELECT rui FROM LoanBatchImagePage lbip JOIN lbip.acRoleUser rui)" +
					 	   " OR ru IN (SELECT rid FROM DocumentDe de JOIN de.acRoleUser rid) )";
			Map<String, Object> map = Lib.buildParamsMap("userId", userId);
			List<AcRole> list = findByNamedQuery(query, map);
			if (list != null && !list.isEmpty()) {
				return list;
			}
			return Collections.EMPTY_LIST;
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to find unAvailable AcRoleUser by [userId=" + userId + "]", e);
		}
	}
}
