package vn.jv.persist.repositories;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepo<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements IBaseRepo<T, ID> {
	@Autowired
	EntityManagerFactory emf;
	
	protected EntityManager entityManager;
	
	@PostConstruct
	public void init() {
		entityManager = emf.createEntityManager();
		
	}
	
	public BaseRepo(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

}
