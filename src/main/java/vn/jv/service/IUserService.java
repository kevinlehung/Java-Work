package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.User;
import vn.jv.web.bean.ScoreUserBean;

public interface IUserService extends IBaseService {
	/**
	 * Create user with minimum fields and set default properties:
	 * 	+ accountLocked: false
	 *  + failedLoginAttempts: 0
	 *  + passwordExpired: false
	 *  + userActive: true
	 * @param email
	 * @param password
	 * @param purpose
	 * @return
	 */
	public User createUser(String email, String password, String purpose);
	
	/**
	 * Check if email has been registered before.
	 * 
	 * @param email
	 * @return
	 */
	public boolean emailIsRegisteredBefore(String email);
	/**
	 * Find test max score each skill of user..
	 * 
	 * @param currentUser
	 * @return
	 */
	public List<ScoreUserBean> findMaxScoreByUser(User currentUser);
	
}
