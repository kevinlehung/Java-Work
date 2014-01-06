package vn.jv.db.dao;

import java.util.List;

import vn.jv.db.entity.AcRoleHierarchy;

public interface IAcRoleHierarchyDAO extends IBaseDAO<Integer, AcRoleHierarchy> {

	List<String> findParentRoleNames(int roleId);
	
	List<AcRoleHierarchy> findParentRoles(int roleId);
}
