package vn.jv.db.dao;

import java.sql.Timestamp;
import java.util.List;

import vn.jv.db.entity.User;
import vn.jv.db.entity.UserLogin;

public interface IUserLoginDAO extends IBaseDAO<Integer, UserLogin> {
	public UserLogin auditNewLogin(String ip, User user, Timestamp loginTime, boolean status, String timeZone);
	public void auditLogout(String ip, User user, Timestamp logoutTime, String timeZone);
	public UserLogin findLastSuccessLogin(Integer userId);
	public List<UserLogin> findByUserIdAndType(Integer userId, String type);
}
