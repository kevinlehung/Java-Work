package vn.jv.db.dao;

import java.util.List;

import vn.jv.db.entity.User;

/**
 * 
 * 
 *
 */
public interface IUserDAO extends IBaseDAO<Integer, User> {
	public User findByEmail(String email);
	public List<User> findByRoleName(String roleName);
	public User findByPasswordHash(String passwordHash);
}
