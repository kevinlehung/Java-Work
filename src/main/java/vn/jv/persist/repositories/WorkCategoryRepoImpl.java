package vn.jv.persist.repositories;

import javax.persistence.EntityManager;

import vn.jv.persist.domain.WorkCategory;

public class WorkCategoryRepoImpl extends BaseRepo<WorkCategory, Integer> implements IWorkCategoryRepo {
	public WorkCategoryRepoImpl(Class<WorkCategory> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}
}
