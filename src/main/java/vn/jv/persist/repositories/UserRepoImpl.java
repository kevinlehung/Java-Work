package vn.jv.persist.repositories;

import javax.persistence.EntityManager;

import vn.jv.persist.domain.User;

public class UserRepoImpl extends BaseRepo<User, Integer> implements IUserCustomRepo<User, Integer> {

	public UserRepoImpl(Class<User> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		// TODO Auto-generated constructor stub
	}

}
