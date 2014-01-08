package vn.jv.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface used for every DAO
 * 
 *
 * @param <K>
 * @param <E>
 */
@SuppressWarnings({ "rawtypes", "deprecation" })
public interface IBaseDAO<K, E> {
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(E entity);
	
	@Transactional(propagation = Propagation.REQUIRED)
	public E update(E entity);
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(K id);
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer removeAll();
	
	public E findById(K id);
	public E findFirstRow();
	public List<E> findAll();
	public List<E> findAllWithOrderColumn(String orderColumnName,String orderDirection);
	
	/**
	 * This method is used to execute native SQL query "SELECT * FROM TABLE_NAME WHERE COLUMN_NAME = ?"
	 * @param query
	 * @param values
	 * @return
	 */
	public Object findByNativeQuery(final String query, final Object[] values);
	
	/**
	 * This method is used to execute Hibernate or JPA query like "FROM WorkflowNodeMapping wfnm WHERE wfnm.workflowLookup = :workflowLookup"
	 * @param query
	 * @param params
	 * @return
	 */
	public List<E> findByQuery(final String query, final Map params);
	
	public List findByNamedQuery(final String query, final Map params);
	
	/**
	 * Execute an update query like "DELETE FROM Employee WHERE employeeId = :employeeId"
	 * If there is no parameter, we can pass NULL for params.
	 * @param query
	 * @param params
	 * @return
	 */
	public int executeUpdateQuery(final String query, final Map params);
	
	/**
	 * Execute an update query like "DELETE FROM employee WHERE employee_id = :employeeId"
	 * If there is no parameter, we can pass NULL for params.
	 * @param nativeQuery
	 * @param params
	 * @return
	 */
	public int executeUpdateNativeQuery(final String nativeQuery, final Map params);
	
	public <T> T findEntity(final Class<T> entityClass, final Object primaryKey);
	
}
