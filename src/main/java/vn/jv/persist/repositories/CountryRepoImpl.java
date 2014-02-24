package vn.jv.persist.repositories;

import javax.persistence.EntityManager;

import vn.jv.persist.domain.Country;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public class CountryRepoImpl extends BaseRepo<Country, Integer> implements ICountryCustomRepo<Country, Integer> {

	public CountryRepoImpl(Class<Country> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}

}
