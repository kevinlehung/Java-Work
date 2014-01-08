package vn.jv.db.dao;

import java.util.List;
import java.util.Map;

import vn.jv.db.entity.AcRolePermission;
import vn.jv.util.Lib;

/**
 * 
 * 
 *
 */
public class AcRolePermissionDAO extends BaseDAO<Integer, AcRolePermission> implements IAcRolePermissionDAO {

	/**
	 * Return the very first instance or null if not found
	 * @param acRoleId
	 * @param acPermissionId
	 * @return
	 */
	public AcRolePermission findByRoleIdAndPermissionId(int acRoleId, int acPermissionId) {
		try {
			String query = "SELECT rp FROM AcRolePermission rp JOIN rp.acRole r JOIN rp.acPermission p " +
					"WHERE r.acRoleId = :acRoleId AND p.acPermissionId = :acPermissionId";
			Map<String, Object> map = Lib.buildParamsMap(new String[] {"acRoleId", "acPermissionId"}, new Integer[] {acRoleId, acPermissionId});
			List<AcRolePermission> list = findByNamedQuery(query, map);
			if(list!=null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find AcRolePermission by [acRoleId=" + acRoleId + ", acPermissionId=" + acPermissionId + "]", e);
		}
	}
	
	
	private static final String FIND_BY_ROLE_ID_AND_RESOURCE_ID = 
		"SELECT rp " +
		"FROM AcRolePermission rp " +
		"WHERE rp.acRole.acRoleId = :acRoleId AND rp.acPermission.acResource.acResourceId = :acResourceId";
	@SuppressWarnings("unchecked")
	public List<AcRolePermission> findByRoleIdAndResourceId(int acRoleId, int acResourceId) {
		try {
			Map<String, Object> map = Lib.buildParamsMap(new String[] {"acRoleId", "acResourceId"}, new Integer[] {acRoleId, acResourceId});
			List<AcRolePermission> list = findByNamedQuery(FIND_BY_ROLE_ID_AND_RESOURCE_ID, map);
			return list;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find by [acRoleId=" + acRoleId + ", acResourceId=" + acResourceId + "]", e);
		}
	}
	
	private static final String FIND_BY_PERMISSION_ID = 
		"SELECT rp " +
		"FROM AcRolePermission rp " +
		"WHERE rp.acPermission.acPermissionId = :acPermissionId";
	@SuppressWarnings("unchecked")
	public List<AcRolePermission> findByPermissionId(int permissionId) {
		try {
			Map<String, Object> map = Lib.buildParamsMap(new String[] {"acPermissionId"}, new Integer[] {permissionId});
			List<AcRolePermission> list = findByNamedQuery(FIND_BY_PERMISSION_ID, map);
			return list;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find by [acPermissionId=" + permissionId, e);
		}
	}

}
