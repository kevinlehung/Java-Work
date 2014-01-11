package vn.jv.db.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import vn.jv.db.entity.AcAction;
import vn.jv.db.entity.AcResource;
import vn.jv.util.Lib;
import vn.jv.web.bean.RoleResourceBean;

@Component
public class AcResourceDAO extends BaseDAO<Integer, AcResource> implements IAcResourceDAO {

	/**
	 * Return the very first instance or null if not found
	 * @param resourceIdentifier
	 * @return
	 */
	public AcResource findByResourceIdentifier(String resourceIdentifier) {
		try {
			String query = "from AcResource r where r.resourceIdentifier = :resourceIdentifier";
			Map<String, Object> map = Lib.buildParamsMap("resourceIdentifier", resourceIdentifier);
			List<AcResource> list = findByNamedQuery(query, map);
			if(list!=null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find AcResource by ResourceIdentifier [" + resourceIdentifier + "]", e);
		}
	}

	private static final String FIND_ROLE_RESOURCE_BEAN_BY_ROLE_ID = 
		"SELECT rp.acPermission.acPermissionId, rp.acPermission.acResource, rp.acPermission.acAction " +
		"from AcRole r JOIN r.acRolePermissions rp " +
		"where r.acRoleId = :roleId";

	@SuppressWarnings("unchecked")
	public List<RoleResourceBean> findRoleResourceBeanByRoleId(int acRoleId) {
		try {
			List<AcResource> acResources = findAll();
			
			Map<String, Object> map = Lib.buildParamsMap("roleId", acRoleId);
			List<Object[]> list = findByNamedQuery(FIND_ROLE_RESOURCE_BEAN_BY_ROLE_ID, map);
			
			List<RoleResourceBean> roleResourceBeans = new ArrayList<RoleResourceBean>();
			for (AcResource acResource : acResources) {
				RoleResourceBean roleResourceBean = new RoleResourceBean();
				roleResourceBean.setAcResource(acResource);
				
				for (Object[] item : list) {
					AcResource ar = (AcResource) item[1];
					if (acResource.getAcResourceId().equals(ar.getAcResourceId())) {
						Integer acPermissionId = (Integer) item[0];
						AcAction acAction = (AcAction) item[2];
						
						roleResourceBean.setAcPermissionId(acPermissionId);
						roleResourceBean.setAcAction(acAction);
						break;
					}
				}
				
				roleResourceBeans.add(roleResourceBean);
			}
			
			return roleResourceBeans;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find role resource by role id [" + acRoleId + "]", e);
		}
	}

	public AcResource findByResourceName(String resourceName) {
		try {
			String query = "from AcResource r where r.resourceName = :resourceName";
			Map<String, Object> map = Lib.buildParamsMap("resourceName", resourceName);
			List<AcResource> list = findByNamedQuery(query, map);
			if(list!=null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find AcResource by ResourceName [" + resourceName + "]", e);
		}
	}
}
