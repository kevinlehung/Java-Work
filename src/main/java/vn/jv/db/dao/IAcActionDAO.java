package vn.jv.db.dao;

import vn.jv.db.entity.AcAction;

public interface IAcActionDAO extends IBaseDAO<Integer, AcAction> {

	/**
	 * Return the very first instance or null if not found
	 * @param actionName
	 * @return
	 */
	public AcAction findByActionName(String actionName);
}
