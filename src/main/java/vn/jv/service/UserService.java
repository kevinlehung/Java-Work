package vn.jv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.TUserTestRepo;
import vn.jv.persist.repositories.UserRepo;
import vn.jv.web.bean.ScoreUserBean;

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
	@Autowired
	private TUserTestRepo userTestRepo;
	
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
		user.setActive(true);
		
	}

	public boolean emailIsRegisteredBefore(String email) {
		User userByEmail = userRepo.findByUserEmail(email);
		return userByEmail != null;
	}

	public List<ScoreUserBean> findMaxScoreByUser(User currentUser) {
		List<ScoreUserBean> scoreUserBeans = new ArrayList<ScoreUserBean>();
		List<Object[]> objs = userTestRepo.findMaxScoreByUser(currentUser.getUserId());
		for(Object[] obj : objs)
		{
			ScoreUserBean scoreUserBean = new ScoreUserBean();
			scoreUserBean.setMaxScore((Integer) obj[0]);
			scoreUserBean.setSkillId((Integer) obj[1]);
			scoreUserBean.setName((String) obj[2]);
			scoreUserBeans.add(scoreUserBean);
		}
		return scoreUserBeans;
	}
	
	
}
