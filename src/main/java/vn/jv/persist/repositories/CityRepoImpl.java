package vn.jv.persist.repositories;

import javax.persistence.EntityManager;

import vn.jv.persist.domain.City;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public class CityRepoImpl extends BaseRepo<City, Integer> implements ICityCustomRepo<City, Integer> {

	public CityRepoImpl(Class<City> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}

}
