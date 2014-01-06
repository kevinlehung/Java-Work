package vn.jv.db.dao;

import java.util.List;

import vn.jv.db.entity.AcRole;
import vn.jv.db.entity.MenuItem;

public interface IMenuItemDAO extends IBaseDAO<Integer, MenuItem> {
	
	/**
	 * Check if <code>roleId</code> has <code>menuItemId</code> or not. Note
	 * that this method doesn't include role hierarchy structure.
	 * 
	 * @param roleId role id to check
	 * @param menuItemId menu item id
	 * @return
	 */
	boolean hasMenuItemByRoleId(final int roleId, final int menuItemId);
	
	/**
	 * Find all menu items, they will be ordered by parentMenuItem and order
	 * 
	 * @return
	 */
	List<MenuItem> findAllWithOrder();
	
	/**
     * Find all roles by menu item id
	 *	
	 * @param menuItemId
	 * @return
	 */
	List<AcRole> findRolesByMenuItemId(int menuItemId);

	/**
	 * Find menu item by name
	 * 
	 * @param name
	 * @return
	 */
	MenuItem findByName(String name);
}
