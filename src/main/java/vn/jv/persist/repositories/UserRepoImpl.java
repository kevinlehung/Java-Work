package vn.jv.persist.repositories;

import javax.persistence.EntityManager;

import vn.jv.persist.domain.User;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
public class UserRepoImpl extends BaseRepo<User, Integer> implements IUserCustomRepo<User, Integer> {

	public UserRepoImpl(Class<User> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}

}
