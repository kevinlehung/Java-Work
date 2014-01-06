package vn.jv.db.dao;

import java.util.List;

import vn.jv.db.entity.AcResource;
import vn.jv.web.bean.RoleResourceBean;

public interface IAcResourceDAO extends IBaseDAO<Integer, AcResource> {

	/**
	 * Return the very first instance or null if not found
	 * @param resourceIdentifier
	 * @return
	 */
	public AcResource findByResourceIdentifier(String resourceIdentifier); 
	
	/**
	 * Find <RoleResourceBean> by role id
	 * 
	 * @param acRoleId
	 * @return
	 */
	List<RoleResourceBean> findRoleResourceBeanByRoleId(int acRoleId);

	/**
	 * Find acResource by resourceName. Return the very first instance or null if not found
	 * @param resourceIdentifier
	 * @return
	 */
	public AcResource findByResourceName(String resourceName);
}
