package vn.jv.db.dao;

import javax.persistence.Query;

import vn.jv.db.entity.AcAction;

/**
 * 
 *
 */
public class AcActionDAO extends BaseDAO<Integer, AcAction> implements IAcActionDAO {

	/**
	 * Return the very first instance or null if not found
	 * @param actionName
	 * @return
	 */
	public AcAction findByActionName(String actionName) {
		try {
			Query query = em.createNamedQuery("from AcAction a where a.actionName = :actionName");
			query.setParameter("actionName", actionName);
			query.setMaxResults(1);
			return (AcAction)query.getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Failed to find AcAction by action name [" + actionName + "]", e);
		}
	}

}
