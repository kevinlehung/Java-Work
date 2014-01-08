package vn.jv.db.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vn.jv.cache.CacheHelper;

/**
 * Contains common methods for every DAO
 * 
 *
 * @param <K>
 * @param <E>
 */
@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public class BaseDAO<K, E>  implements IBaseDAO<K, E> {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	protected CacheHelper cacheHelper = CacheHelper.getInstance();
	protected Class<E> entityClass;
	
	@PersistenceContext(unitName = "javawork")
	protected EntityManager em;

	public BaseDAO() {
		Type type = getClass().getGenericSuperclass();
		if(type instanceof ParameterizedType) {
			ParameterizedType genericSuperclass = (ParameterizedType)type;
			this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(E entity) {
		em.persist(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public E update(E entity) {
		return em.merge(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(K id) {
		E entity = findById(id);
		if(entity!=null) {
			em.remove(entity);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer removeAll() {
		Query q = em.createQuery("DELETE FROM " + entityClass.getName() + " e");
		return (Integer)q.executeUpdate();
	}

	public E findById(K id) {
		return em.find(entityClass, id);
	}
	
	public E findFirstRow() {
		Query q = em.createQuery("from " + entityClass.getName() + ")");
		q.setMaxResults(1);
		List<E> result = q.getResultList();
		
		if (result.size() > 0) {
			return result.get(0);
		}
		
		return null;
	}

	public List<E> findAll() {
		Query q = em.createQuery("SELECT e FROM " + entityClass.getName() + " e");
		return q.getResultList();
	}
	
	public List<E> findAllWithOrderColumn(final String orderColumnName,final String orderDirection){
		Query q = em.createQuery("SELECT e FROM " + entityClass.getName() + " e ORDER BY e."+orderColumnName+" "+orderDirection);
		return q.getResultList();
	}
	
	/**
	 * This method is used to execute native SQL query "SELECT * FROM TABLE_NAME WHERE COLUMN_NAME = ?"
	 * @param query
	 * @param values
	 * @return
	 */
	public List findByNativeQuery(final String query, final Object[] values){
		Query q = em.createNativeQuery(query);
		for (int i = 0; i < values.length; i++) {
			q.setParameter(i+1, values[i]);
		}
		return q.getResultList();
	}
	/**
	 * This method is used to execute Hibernate or JPA query like 
	 * "FROM WorkflowNodeMapping wfnm WHERE wfnm.workflowLookup = :workflowLookup"
	 * @param query
	 * @param params
	 * @return
	 */
	public List<E> findByQuery(final String query, final Map params) {
		Query q = em.createQuery(query);
		if(params != null) {
			Iterator<String> paramNames = params.keySet().iterator();
			while(paramNames.hasNext()) {
				String paramName = paramNames.next();
				Object paramValue = params.get(paramName);
				q.setParameter(paramName, paramValue);
			}
		}
		return q.getResultList();
	}
	
	/**
	 * get first result of query 
	 * @param query
	 * @param params
	 * @return
	 */
	public E findUniqueResult(final String query, final Map params) {
		Query q = em.createQuery(query);
		if(params != null) {
			Iterator<String> paramNames = params.keySet().iterator();
			while(paramNames.hasNext()) {
				String paramName = paramNames.next();
				Object paramValue = params.get(paramName);
				q.setParameter(paramName, paramValue);
			}
		}
		q.setMaxResults(1);
		List<E> result = q.getResultList();
		
		if (result.size() > 0) {
			return result.get(0);
		}
		
		return null;
	}
	public long getCurrentTimeSQL(){
		final String query = "select SYSDATE()";
		Query q = em.createNativeQuery(query);
		List dateList = q.getResultList();
		
		java.sql.Timestamp currentTS = (java.sql.Timestamp) dateList.get(0);
		return currentTS.getTime();
	}

	/**
	 * Execute an update query like "DELETE FROM Employee WHERE employeeId = :employeeId"
	 * If there is no parameter, we can pass NULL for params.
	 * @param query
	 * @param params
	 * @return
	 */
	public int executeUpdateQuery(String query, Map params) {
		return executeUpdateQuery(false, query, params);
	}

	/**
	 * Execute an update native query like "DELETE FROM table_name WHERE column = :employeeId"
	 * If there is no parameter, we can pass NULL for params.
	 * @param nativeQuery
	 * @param params
	 * @return
	 */
	public int executeUpdateNativeQuery(String nativeQuery, Map params) {
		return executeUpdateQuery(true, nativeQuery, params);
	}

	private int executeUpdateQuery(final boolean isNative, final String query, final Map params) {
		Query q = null;
		if (isNative) {
			q = em.createNativeQuery(query);
		} else {
			q = em.createQuery(query);
		}
		if(params != null) {
			Iterator<String> paramNames = params.keySet().iterator();
			while(paramNames.hasNext()) {
				String paramName = paramNames.next();
				Object paramValue = params.get(paramName);
				q.setParameter(paramName, paramValue);
			}
		}
		return (Integer)q.executeUpdate();
	}

	public <T> T findEntity(final Class<T> entityClass, final Object primaryKey) {
        return em.find(entityClass, primaryKey);
    }
	
	public List findByNamedQuery(final String query, final Map params) {
		Query q = em.createNamedQuery(query);
		if(params != null) {
			Iterator<String> paramNames = params.keySet().iterator();
			while(paramNames.hasNext()) {
				String paramName = paramNames.next();
				Object paramValue = params.get(paramName);
				q.setParameter(paramName, paramValue);
			}
		}
		return q.getResultList();
	}

}