package vn.jv.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import vn.jv.cache.CacheConstants;
import vn.jv.db.entity.AcAction;
import vn.jv.db.entity.AcPermission;
import vn.jv.db.entity.AcResource;
import vn.jv.util.Lib;

@Component
public class AcPermissionDAO extends BaseDAO<Integer, AcPermission> implements IAcPermissionDAO {
	
	private static final String FIND_RESOURCES_FOR_ROLE = "SELECT rp.acPermission.acResource.resourceName FROM AcRolePermission rp WHERE rp.acRole.acRoleId = :roleId";

	public Map<AcAction, AcResource> findPermissionsForRoleFromCache(int roleId) {
		String cacheName = CacheConstants.AcPermissionDAO.FIND_PERMISSIONS_FOR_ROLE_CACHE;
		String valueKey = String.valueOf(roleId);
		Map<AcAction, AcResource> resultList = new HashMap<AcAction, AcResource>();
		if (cacheHelper.containsKey(cacheName, valueKey)) {
			resultList = (Map<AcAction, AcResource>) cacheHelper.getValueFromCache(cacheName, valueKey);
		} else {
			resultList = findPermissionsForRole(roleId);
			cacheHelper.putToCache(cacheName, valueKey, resultList);
		}
		return resultList; 
	}
	
	/**
	 * Find permissions for a given role
	 * @param roleId
	 * @return
	 */
	public Map<AcAction, AcResource> findPermissionsForRole(int roleId) {
		try {
			String query = "SELECT p.acAction, p.acResource FROM AcRolePermission rp " +
					"JOIN rp.acPermission p " +
					"WHERE rp.acRole.acRoleId = :roleId";
			Map<String, Object> map = Lib.buildParamsMap("roleId", roleId);
			List list = findByNamedQuery(query, map);
			Map<AcAction, AcResource> result = new HashMap<AcAction, AcResource>();
			for (int i = 0; i < list.size(); i++) {
				Object[] item = (Object[]) list.get(i);
				AcAction acAction = (AcAction) item[0];
				AcResource acResource = (AcResource) item[1];
				if(result.containsKey(acAction)) {
					AcAction clone = clone(acAction);
					result.put(clone, acResource);
				} else {
					result.put(acAction, acResource);
				}
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find roles by role id '" + roleId + "'", e);
		}
	}
	
	private AcAction clone(AcAction acAction) {
		AcAction clone = new AcAction();
		BeanUtils.copyProperties(acAction, clone);
		return clone;
	}

	/**
	 * Return the very first instance or null if not found
	 * @param acActionId
	 * @param acResourceId
	 * @return
	 */
	public AcPermission findPermissionByActionIdAndResourceId(int acActionId, int acResourceId) {
		try {
			String query = "SELECT p FROM AcPermission p JOIN p.acAction a JOIN p.acResource r " +
					"WHERE a.acActionId = :acActionId AND r.acResourceId = :acResourceId";
			Map<String, Object> map = Lib.buildParamsMap(new String[] {"acActionId", "acResourceId"}, new Integer[] {acActionId, acResourceId});
			List<AcPermission> list = findByNamedQuery(query, map);
			if(list!=null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find AcPermission by [acActionId=" + acActionId + ", acResourceId=" + acResourceId + "]", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findResourceNamesByRoleId(int roleId) {
		try {
			Map<String, Object> map = Lib.buildParamsMap("roleId", roleId);
			List<String> list = findByNamedQuery(FIND_RESOURCES_FOR_ROLE, map);
			return list;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find resource names by role id '" + roleId + "'", e);
		}
	}

	public List<AcPermission> findPermissionsByResourceId(Integer acResourceId) {
		try {
			String query = "SELECT p FROM AcPermission p JOIN p.acResource r " +
					"WHERE r.acResourceId = :acResourceId";
			Map<String, Object> map = Lib.buildParamsMap(new String[] {"acResourceId"}, new Integer[] {acResourceId});
			List<AcPermission> list = findByNamedQuery(query, map);
			return list;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find AcPermission by [acResourceId=" + acResourceId + "]", e);
		}
	}
}
