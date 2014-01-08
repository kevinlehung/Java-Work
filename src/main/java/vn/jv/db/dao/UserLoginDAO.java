package vn.jv.db.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vn.jv.db.entity.User;
import vn.jv.db.entity.UserLogin;
import vn.jv.util.Lib;

/**
 * 
 * 
 *
 */
public class UserLoginDAO extends BaseDAO<Integer, UserLogin> implements IUserLoginDAO {
	
	/**
	 * Track new login by adding one row with type "LOGIN" into UserLogin table and
	 * output to Syslog
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public UserLogin auditNewLogin(String ip, User user, Timestamp loginTime, boolean status, String timeZone) {
		String userName = user.getUserEmail();
		User loginedUser = new User();
		loginedUser.setUserId(user.getUserId());
		UserLogin newLogin = new UserLogin();
		newLogin.setUser(loginedUser);
		newLogin.setLoginTime(loginTime);
		newLogin.setIp(ip);
		newLogin.setUserName(userName);
		newLogin.setStatus(status);
		newLogin.setTimeZone(timeZone);
		newLogin.setSysLog(UserLogin.NOT_CONFIGURED_SYSLOG);
		newLogin.setType(UserLogin.TYPE_LOGIN);
		save(newLogin);
		return newLogin;
	}
	
	/**
	 * Track new logout by adding one row with type "LOGOUT" into UserLogin table and
	 * output to Syslog
	 */	
	@Transactional(propagation = Propagation.REQUIRED)
	public void auditLogout(String ip, User user, Timestamp logoutTime, String timeZone) {
		String userName = user.getUserEmail();
		User logoutUser = new User();
		logoutUser.setUserId(user.getUserId());
		UserLogin newLogout = new UserLogin();
		newLogout.setUser(logoutUser);
		newLogout.setLoginTime(logoutTime);
		newLogout.setIp(ip);
		newLogout.setUserName(userName);
		newLogout.setStatus(true);
		newLogout.setTimeZone(timeZone);
		newLogout.setSysLog(UserLogin.NOT_CONFIGURED_SYSLOG);
		newLogout.setType(UserLogin.TYPE_LOGOUT);
		save(newLogout);		
	}
	
	private static final String FIND_LAST_SUCCESS_LOGIN = 
			"FROM UserLogin ul WHERE ul.user.userId = :userId and ul.status = :status and ul.type = :type ORDER BY loginTime DESC";
	
	public UserLogin findLastSuccessLogin(Integer userId) {
		try {
			Map<String, Object> map = Lib.buildParamsMap(new String[] { "userId", "status", "type" },
					new Object[] { userId, UserLogin.LOGIN_SUCCESS, UserLogin.TYPE_LOGIN });
			return findUniqueResult(FIND_LAST_SUCCESS_LOGIN, map);
		} catch (Exception e) {
			throw new RuntimeException("Failed to find last success login time with [userId=" + userId + "]", e);
		}
	}
	
	private static final String FIND_BY_USER_ID_AND_TYPE = 
			"FROM UserLogin ul WHERE ul.user.userId = :userId and ul.type = :type ORDER BY loginTime DESC";	
	public List<UserLogin> findByUserIdAndType(Integer userId, String type) {
		try {
			Map<String, Object> map = Lib.buildParamsMap(new String[] { "userId", "type" },
					new Object[] { userId, type });
			return findByQuery(FIND_BY_USER_ID_AND_TYPE, map);
		} catch (Exception e) {
			throw new RuntimeException("Failed to find user login by [userId=" + userId + ", type=" + type + "]", e);
		}
	}
}
