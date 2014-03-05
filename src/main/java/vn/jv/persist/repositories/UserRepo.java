package vn.jv.persist.repositories;

import vn.jv.persist.domain.User;

/**
 * Do operations on [user] table
 * 
 * @author hunglevn@outlook.com
 *
 */
public interface UserRepo extends BaseRepo<User, Integer> {
	public User findByUserEmail(String userEmail);
}
