package vn.jv.persist.repositories;

import vn.jv.persist.domain.User;

public interface IUserRepo extends IBaseRepo<User, Integer>, IUserCustomRepo<User, Integer> {
	public User findByUserEmail(String userEmail);
}
