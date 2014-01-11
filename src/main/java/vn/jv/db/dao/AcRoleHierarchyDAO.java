package vn.jv.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import vn.jv.db.entity.AcRoleHierarchy;
import vn.jv.util.Lib;

@Component
public class AcRoleHierarchyDAO extends BaseDAO<Integer, AcRoleHierarchy> implements IAcRoleHierarchyDAO {
	
	private static final String FIND_PARENT_ROLE = "SELECT parentAcRole.roleName FROM AcRoleHierarchy WHERE acRole.acRoleId = :roleId";

	@SuppressWarnings("unchecked")
	public List<String> findParentRoleNames(int roleId) {
		try {
			
			Map<String, Object> map = Lib.buildParamsMap("roleId", roleId);
			List<String> list = findByNamedQuery(FIND_PARENT_ROLE, map);
			return list;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find parent role names by role id [" + roleId + "]", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AcRoleHierarchy> findParentRoles(int roleId) {
		try {
			String query = "SELECT rh FROM AcRoleHierarchy rh JOIN rh.acRole r WHERE r.acRoleId = :roleId";
			Map<String, Object> map = Lib.buildParamsMap("roleId", roleId);
			List<AcRoleHierarchy> list = findByNamedQuery(query, map);
			return list;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find parent role by role id [" + roleId + "]", e);
		}
	}
}
