package vn.jv.persist.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class BaseRepoImpl<T, ID extends Serializable> implements BaseRepo<T, ID> {
	@Autowired
	EntityManagerFactory emf;
	
	private SimpleJpaRepository<T, ID> target;	
	
	protected Class<T> domainClass;

	protected @PersistenceContext EntityManager entityManager;

	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@PostConstruct
	public void init() {
		// this is needed to retrieve the Class instance associated with the generic definition T
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType genericSuperclass = (ParameterizedType) type;
			this.domainClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
			JpaEntityInformation jpaEntityInformation = (JpaEntityInformation<T, ID>) JpaEntityInformationSupport.getMetadata(this.domainClass, entityManager);
			target = new SimpleJpaRepository<T, ID>(jpaEntityInformation, entityManager);
		}
	}

	public List<T> findAll() {
		return target.findAll();
	}

	public List<T> findAll(Sort sort) {
		return target.findAll(sort);
	}

	public List<T> findAll(Iterable<ID> ids) {
		return target.findAll(ids);
	}

	@Transactional
	public <S extends T> List<S> save(Iterable<S> entities) {
		return target.save(entities);
	}

	public void flush() {
		target.flush();
		
	}

	@Transactional
	public T saveAndFlush(T entity) {
		return target.saveAndFlush(entity);
	}

	@Transactional
	public void deleteInBatch(Iterable<T> entities) {
		target.deleteInBatch(entities);
		
	}

	@Transactional
	public void deleteAllInBatch() {
		target.deleteAllInBatch();
		
	}

	public Page<T> findAll(Pageable pageable) {
		return target.findAll(pageable);
	}
	
	@Transactional
	public <S extends T> S save(S entity) {
		return target.save(entity);
	}

	public T findOne(ID id) {
		return target.findOne(id);
	}

	public boolean exists(ID id) {
		return target.exists(id);
	}

	public long count() {
		return target.count();
	}

	@Transactional
	public void delete(ID id) {
		target.delete(id);
	}

	@Transactional
	public void delete(T entity) {
		target.delete(entity);
	}

	@Transactional
	public void delete(Iterable<? extends T> entities) {
		target.delete(entities);
	}

	@Transactional
	public void deleteAll() {
		target.deleteAll();
	}

	public T findOne(Specification<T> spec) {
		return target.findOne(spec);
	}

	public List<T> findAll(Specification<T> spec) {
		return target.findAll(spec);
	}

	public Page<T> findAll(Specification<T> spec, Pageable pageable) {
		return target.findAll(spec, pageable);
	}

	public List<T> findAll(Specification<T> spec, Sort sort) {
		return target.findAll(spec, sort);
	}

	public long count(Specification<T> spec) {
		return target.count(spec);
	}

}
