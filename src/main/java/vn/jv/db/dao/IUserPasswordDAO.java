package vn.jv.db.dao;

import java.util.List;

import vn.jv.db.entity.UserPassword;

public interface IUserPasswordDAO extends IBaseDAO<Integer, UserPassword> {

	List<UserPassword> findByUserId(Integer userId, final int numberResult);
}
