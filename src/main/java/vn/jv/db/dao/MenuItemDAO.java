package vn.jv.db.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import vn.jv.db.entity.AcRole;
import vn.jv.db.entity.MenuItem;
import vn.jv.util.Lib;

@Component
public class MenuItemDAO extends BaseDAO<Integer, MenuItem> implements IMenuItemDAO {
	
	private static final String HAS_MENU_ITEM_BY_ROLE_ID = 
		"select distinct mi.menuItemId " +
		"from MenuItem mi join mi.roleMenuItems rmi " +
		"where rmi.acRole.acRoleId = :roleId and mi.menuItemId = :menuItemId ";
	
	private static final String FIND_ALL_WITH_ORDER = "FROM MenuItem mi ORDER BY mi.parentMenuItem.menuItemId, mi.order";

	@SuppressWarnings("unchecked")
	public boolean hasMenuItemByRoleId(final int roleId, final int menuItemId) {
		Query q = em.createQuery(HAS_MENU_ITEM_BY_ROLE_ID);
		q.setParameter("roleId", roleId);
		q.setParameter("menuItemId", menuItemId);
		q.setMaxResults(1);
		List<MenuItem> menuItems = q.getResultList();
		
		if (menuItems.size() > 0) {
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<MenuItem> findAllWithOrder() {
		try {
			return findByQuery(FIND_ALL_WITH_ORDER, null);
		} catch (Exception e) {
			throw new RuntimeException("Failed to find all menu items with order", e);
		}
	}
	
	private static final String FIND_ROLE_NAMES_BY_MENU_ITEM_ID = 
		"SELECT r " +
		"FROM MenuItem mi join mi.roleMenuItems rmi join rmi.acRole r " +
		"WHERE mi.menuItemId = :menuItemId";
	@SuppressWarnings("unchecked")
	public List<AcRole> findRolesByMenuItemId(int menuItemId) {
		try {
			Map<String, Object> map = Lib.buildParamsMap("menuItemId", menuItemId);
			return findByNamedQuery(FIND_ROLE_NAMES_BY_MENU_ITEM_ID, map);
		} catch (Exception e) {
			throw new RuntimeException("Failed to find role names by [menuItemId = " + menuItemId, e);
		}
	}

	@SuppressWarnings("unchecked")
	public MenuItem findByName(final String name) {
		Query q = em.createQuery("from MenuItem where name=:name");
		q.setParameter("name", name);
		q.setMaxResults(1);
		List<MenuItem> items = q.getResultList();
		if (items.size() > 0) {
			return items.get(0);
		}
		
		return null;
	}
}
