package vn.jv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.UserRepo;

/**
 * Contain operations relate to User
 * 
 * @author hunglevn@outlook.com
 *
 */
@Service
public class UserService extends BaseService implements IUserService {
	@Autowired
	private UserRepo userRepo;
	
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
	public User createUser(String email, String password, String purpose) {
		User user = new User();
		user.setUserEmail(email);
		user.setUserPassword(password);
		user.setPurpose(purpose);
		setDefaultUserProperties(user);
		return userRepo.save(user);
	}
	
	/**
	 * Initial default properties for user:
	 * 	+ accountLocked: false
	 *  + failedLoginAttempts: 0
	 *  + passwordExpired: false
	 *  + userActive: true
	 * @param user
	 */
	private void setDefaultUserProperties(User user) {
		user.setAccountLocked(false);
		user.setFailedLoginAttempts(0);
		user.setPasswordExpired(false);
		user.setUserActive(true);
		
	}

	public boolean emailIsRegisteredBefore(String email) {
		User userByEmail = userRepo.findByUserEmail(email);
		return userByEmail != null;
	}
}
