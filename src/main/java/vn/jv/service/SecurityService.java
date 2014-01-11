package vn.jv.service;

import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import vn.jv.config.ConfigManager;
import vn.jv.constant.ConfigConstants;
import vn.jv.constant.MailTemplateConstants;
import vn.jv.constant.WebConstants;
import vn.jv.db.dao.IAcPermissionDAO;
import vn.jv.db.dao.IAcRoleDAO;
import vn.jv.db.dao.IAcRoleUserDAO;
import vn.jv.db.dao.IMenuItemDAO;
import vn.jv.db.dao.IUserDAO;
import vn.jv.db.dao.IUserPasswordDAO;
import vn.jv.db.entity.AcAction;
import vn.jv.db.entity.AcResource;
import vn.jv.db.entity.AcRole;
import vn.jv.db.entity.AcRoleUser;
import vn.jv.db.entity.MenuItem;
import vn.jv.db.entity.User;
import vn.jv.db.entity.UserPassword;
import vn.jv.email.IMailSender;
import vn.jv.util.DateUtil;
import vn.jv.util.Lib;
import vn.jv.util.PasswordEnforcementUtil;
import vn.jv.util.PasswordGeneratorUtil;

@Service
public class SecurityService implements ISecurityService {
	@Autowired
	@Qualifier("acRoleDAO")
	private IAcRoleDAO acRoleDAO;
	@Autowired
	@Qualifier("acPermissionDAO")
	private IAcPermissionDAO acPermissionDAO;
	@Autowired
	@Qualifier("menuItemDAO")
	private IMenuItemDAO menuItemDAO;
	@Autowired
	@Qualifier("userDAO")
	private IUserDAO userDAO;
	@Autowired
	@Qualifier("mailSender")
	private IMailSender mailSender;
	@Autowired
	@Qualifier("passwordEncoder")
	private ShaPasswordEncoder passwordEncoder;

	@Autowired
	@Qualifier("acRoleUserDAO")
	private IAcRoleUserDAO acRoleUserDAO;
	@Autowired
	@Qualifier("userPasswordDAO")
	private IUserPasswordDAO userPasswordDAO;

	/**
	 * Check ac_xxx tables to see if userEmail has permission to access this
	 * resourceIdentifier
	 * 
	 * @param userEmail
	 * @param resourceIdentifier
	 * @return
	 */
	public boolean hasPermission(String userEmail, String resourceIdentifier) {
		User user = userDAO.findByEmail(userEmail);
		if (user == null) {
			throw new RuntimeException("User with email '" + userEmail
					+ "' does not exist");
		}
		return hasPermission(user.getUserId(), resourceIdentifier);
	}

	/**
	 * Check ac_xxx tables to see if userId has permission to access this
	 * resourceIdentifier
	 * 
	 * @param userEmail
	 * @param resourceIdentifier
	 * @return
	 */

	public boolean hasPermission(int userId, String resourceIdentifier) {
		try {
			List<AcRole> allRoles = acRoleDAO.findAllRoles(userId);
			return hasPermission(allRoles, resourceIdentifier);
		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to check permission for user id '" + userId
							+ "' on resource '" + resourceIdentifier + "'", e);
		}
	}

	/**
	 * Check if given roles have permission to resourceIdentifier
	 * 
	 * @param roles
	 * @param resourceIdentifier
	 * @return
	 */
	public boolean hasPermission(List<AcRole> roles, String resourceIdentifier) {
		if (roles == null || roles.isEmpty()) {
			return false;
		}
		for (AcRole acRole : roles) {
			/**
			 * Super Admin can access everything
			 */
			if (WebConstants.SUPER_ADMIN.equals(acRole.getRoleName())) {
				return true;
			}
			Map<AcAction, AcResource> permissions = acPermissionDAO
					.findPermissionsForRoleFromCache(acRole.getAcRoleId());
			for (Iterator<AcResource> values = permissions.values().iterator(); values
					.hasNext();) {
				AcResource resource = values.next();
				if (resource.getResourceIdentifier().equals(resourceIdentifier)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Find menu items by users. This method includes checking role hierarchy of
	 * the user.
	 * 
	 * @param userId
	 *            user id to find
	 * @return
	 */
	public List<MenuItem> findMenuItemsByUserId(int userId) {
		try {
			List<AcRole> allRoles = acRoleDAO.findAllRoles(userId);
			return findMenuItemsByRoles(allRoles);
		} catch (Exception e) {
			throw new RuntimeException("Failed to find menu items for user '"
					+ userId + "'", e);
		}
	}

	public List<MenuItem> findMenuItemsByRoles(List<AcRole> roles) {
		List<MenuItem> result = new ArrayList<MenuItem>();
		if (roles == null || roles.isEmpty()) {
			return result;
		}

		List<MenuItem> menuItems = menuItemDAO.findAllWithOrder();
		for (MenuItem menuItem : menuItems) {
			boolean hasMenuItem = hasMenuItem(roles, menuItem);
			if (hasMenuItem) {
				result.add(menuItem);
			}
		}
		return result;
	}

	private boolean hasMenuItem(List<AcRole> allRoles, MenuItem menuItem) {
		for (AcRole acRole : allRoles) {
			boolean hasMenuItem = menuItemDAO.hasMenuItemByRoleId(
					acRole.getAcRoleId(), menuItem.getMenuItemId());
			if (hasMenuItem) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Reset password: 1. Generate a password meeting complexity rules 2. Email
	 * the password to the user 3. Set flag requiring user to change password at
	 * next login
	 * 
	 * @param userEmail
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public String resetPassword(String userEmail) {
		User user = userDAO.findByEmail(userEmail);
		if (user == null) {
			throw new RuntimeException("User with email '" + userEmail
					+ "' does not exist");
		}
		String newPassword = PasswordGeneratorUtil.generatePassword(16, 3, 3);
		String encodedPass = passwordEncoder.encodePassword(newPassword,
				userEmail);
		user.setUserPassword(encodedPass);
		user.setPasswordExpired(true);
		user.setPasswordLastChangedDate(Calendar.getInstance().getTime());
		userDAO.update(user);
		
		trackUserPassword(user, encodedPass);
		
		/**
		 * Send email to user to inform this new password
		 */
		String userName = user.getUserName();
		if (userName == null || userName.isEmpty()) {
			userName = user.getUserEmail();
		}
		Map<String, Object> templateVars = Lib.buildParamsMap(new String[] {
				"userName", "newPassword" }, new String[] { userName,
				newPassword });
		mailSender.sendUsingFreeMarkerTemplate(userEmail, "Password Changed",
				MailTemplateConstants.PASSWORD_CHANGED, templateVars);
		return newPassword;
	}

	/**
	 * Reset password: 1. Generate a password meeting complexity rules 2. Email
	 * the password to the user 3. Set flag requiring user to change password at
	 * next login
	 * 
	 * @param userEmail
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public String resetPassword(String userEmail, boolean initEmailPassword,
			String argPassNew) {

		User user = userDAO.findByEmail(userEmail);
		if (user == null) {
			throw new RuntimeException("User with email '" + userEmail
					+ "' does not exi;st");
		}
		String newPassword = "";
		if (initEmailPassword) {
			newPassword = PasswordGeneratorUtil.generatePassword(16, 3, 3);
		} else {
			newPassword = argPassNew;
		}

		String encodedPass = passwordEncoder.encodePassword(newPassword,
				userEmail);
		user.setUserPassword(encodedPass);
		user.setPasswordExpired(true);
		user.setPasswordLastChangedDate(Calendar.getInstance().getTime());
		userDAO.update(user);
		
		trackUserPassword(user, encodedPass);
		
		/**
		 * Send email to user to inform this new password
		 */
		if (initEmailPassword) {
			String userName = user.getUserName();
			if (userName == null || userName.isEmpty()) {
				userName = user.getUserEmail();
			}
			Map<String, Object> templateVars = Lib.buildParamsMap(new String[] {
					"userName", "newPassword" }, new String[] { userName,
					newPassword });
			mailSender.sendUsingFreeMarkerTemplate(userEmail,
					"Password Changed", MailTemplateConstants.PASSWORD_CHANGED,
					templateVars);
		}
		return newPassword;
	}

	/**
	 * Change password of a user: 1. Validate the current password - if correct,
	 * validate the complexity of the new password 2. If current password is
	 * invalid return error message "Authentication Failure" 3. If the
	 * complexity of the new password is incorrect, return error message
	 * "New password does not meet complexity requirements" 4. If password is
	 * successfully changed return the standard authentication message to the
	 * client (roles & session)
	 * 
	 * @param userEmail
	 * @param oldPassword
	 * @param newPassword
	 * @return User who has changed his password successfully
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public User changePassword(String userEmail, String oldPassword,
			String newPassword) {
		User user = userDAO.findByEmail(userEmail);
		if (user == null) {
			throw new RuntimeException("User with email '" + userEmail
					+ "' does not exist");
		}
		return changePassword(user, oldPassword, newPassword);
	}

	/**
	 * Change password of a user: 1. Validate the current password - if correct,
	 * validate the complexity of the new password 2. If current password is
	 * invalid return error message "Authentication Failure" 3. If the
	 * complexity of the new password is incorrect, return error message
	 * "New password does not meet complexity requirements" 4. If password is
	 * successfully changed return the standard authentication message to the
	 * client (roles & session)
	 * 
	 * @param user
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	
	@Transactional(propagation = Propagation.REQUIRED)
	public User changePassword(User user, String oldPassword, String newPassword) {
		if (user == null) {
			throw new RuntimeException("Null User is not allowed");
		}
		String userEmail = user.getUserEmail();
		String encodedPass = passwordEncoder.encodePassword(oldPassword,
				userEmail);
		if (!encodedPass.equals(user.getUserPassword())) {
			throw new BadCredentialsException("Authentication failure");
		}
		try {
			PasswordEnforcementUtil.validatePassword(newPassword);
		} catch (Exception e) {
			throw new RuntimeException(
					"New password does not meet complexity requirements", e);
		}
		String newEncodedPass = passwordEncoder.encodePassword(newPassword,	userEmail);
		int defaultPasswordHistory = ConfigManager.getInstance().getIntProperty(ConfigConstants.DEFAULT_PASSWORD_HISTORY);
		List<UserPassword> userPasswords = userPasswordDAO.findByUserId(user.getUserId(), defaultPasswordHistory);
		for (UserPassword userPassword : userPasswords) {
			if (newEncodedPass.equals(userPassword.getUserPassword())) {
				throw new RuntimeException("New password has been used in the last " + defaultPasswordHistory + " times. Please enter a differenct password.");
			}
		}
		
		user.setUserPassword(newEncodedPass);
		user.setPasswordLastChangedDate(Calendar.getInstance().getTime());
		user.setPasswordExpired(false);
		userDAO.update(user);
		
		trackUserPassword(user, newEncodedPass);
		
		return user;
	}

	private void trackUserPassword(User user, String newEncodedPass) {
		UserPassword userPassword = new UserPassword();
		userPassword.setUser(user);
		userPassword.setUserPassword(newEncodedPass);
		userPassword.setDateCreated(DateUtil.currentTime());
		userPasswordDAO.save(userPassword);
	}

	/**
	 * Create a new user into User table 1. If field Email Initial Password is
	 * checked then system will be generate Password and email to user by email
	 * 2. Set PasswordExpired is true mean that user must change login in the
	 * first time login
	 * 
	 * @param User
	 *            user object
	 * @param isEmailInitPassword
	 * @return void
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void createUser(User user, boolean isEmailInitPassowrd) {

		String autoPassword = PasswordGeneratorUtil.generatePassword(16, 3, 3);
		String userEmail = user.getUserEmail();
		String userName = user.getUserName();
		user.setPasswordLastChangedDate(Calendar.getInstance().getTime());
		user.setPasswordExpired(true);
		user.setAccountLocked(false);
		user.setUserActive(true);

		if (userName == null || userName.isEmpty()) {
			userName = user.getUserEmail();
		}
		
		String encodedPass = null;
		if (isEmailInitPassowrd) {
			encodedPass = passwordEncoder.encodePassword(autoPassword, userEmail);
		} else {
			String password = user.getUserPassword();
			encodedPass = passwordEncoder.encodePassword(password, userEmail);
		}
		
		user.setUserPassword(encodedPass);

		// 1. Insert new user into User table
		userDAO.save(user);
		
		trackUserPassword(user, encodedPass);

		// Send email
		if (isEmailInitPassowrd) {
			Map<String, Object> templateVars = Lib.buildParamsMap(new String[] {
					"userName", "newPassword" }, new String[] { userName,
					autoPassword });
			mailSender.sendUsingFreeMarkerTemplate(userEmail,
					"Your Password Account",
					MailTemplateConstants.EMAIL_INITIAL_PASSWORD, templateVars);
		}

		// 3. Insert into RoleUser table
		String[] lstRoles = user.getLstRoles();
		for (int i = 0; i < lstRoles.length; i++) {
			AcRoleUser acRoleUser = new AcRoleUser();
			acRoleUser.setUser(user);
			AcRole acRole = acRoleDAO.findById(Integer.parseInt(lstRoles[i]));
			acRoleUser.setAcRole(acRole);
			acRoleUser.setDateCreated(new Timestamp(new Date().getTime()));
			acRoleUserDAO.save(acRoleUser);
		}
	}

	/***
	 * Check user email is unique in database 1. Return false mean that email
	 * existed in database 2. Return true mean that email is valid (unique)
	 * 
	 * @param email
	 * @return
	 */
	public boolean validateUniqueEmail(String email) {
		User user = userDAO.findByEmail(email);
		if (user != null) {
			return false;
		}
		return true;
	}


	/***
	 * Active user when it has value of "ACTIVE" column is 0
	 * 
	 * @param userId
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void activeUser(int userId) {
		try {
			User user = userDAO.findById(userId);
			user.setUserActive(true);
			userDAO.update(user);
		} catch (Exception ex) {
			throw new RuntimeException("Failed to find user by id = " + userId
					+ ex);
		}
	}

	/***
	 * Deactive user when it has value of "ACTIVE" column is 1
	 * 
	 * @param userId
	 */
	public void deactiveUser(int userId) {
		try {
			User user = userDAO.findById(userId);
			user.setUserActive(false);
			userDAO.update(user);
		} catch (Exception ex) {
			throw new RuntimeException("Failed to find user by id = " + userId
					+ ex);
		}
	}

	/***
	 * Unlock user account when account is locked
	 * 
	 * @param userId
	 */
	public void unlockAccount(int userId) {
		try {
			User user = userDAO.findById(userId);
			user.setAccountLocked(false);
			userDAO.update(user);
		} catch (Exception ex) {
			throw new RuntimeException("Failed to find user by id = " + userId
					+ ex);
		}
	}

	/**
	 * Update account of user 1. UPDATE USER INFORMATION (USER TABLE) 2. UPDATE
	 * VENDORUSER (VENDOR_USER TABLE) 3. UPDATE ACROLESUSER (ACROLES_USER TABLE)
	 * 
	 * @param user
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(User user) {
		// 1. Update User Infor
		userDAO.update(user);

		// 3. Update AcRolesUser
		List<AcRoleUser> lstRoleUserInDB = acRoleDAO
				.findAcRoleUserByUserId(user.getUserId());
		for (AcRoleUser acRoleUser : lstRoleUserInDB) {
			acRoleUserDAO.remove(acRoleUser.getAcRoleUserId());
		}

		String[] lstCurrentRole = user.getLstRoles();

		for (int i = 0; i < lstCurrentRole.length; i++) {
			AcRoleUser acRoleUserInsert = new AcRoleUser();
			String roleId = lstCurrentRole[i];
			AcRole acRole = acRoleDAO.findById(Integer.parseInt(roleId));
			acRoleUserInsert.setAcRole(acRole);
			acRoleUserInsert.setUser(user);
			acRoleUserInsert
					.setDateCreated(new Timestamp(new Date().getTime()));
			acRoleUserDAO.save(acRoleUserInsert);
		}
	}
	
	public boolean sendForgotPasswordEmail(String userEmail,
			HttpServletRequest request) {
		User user = userDAO.findByEmail(userEmail);
		if (user == null) {
			return false;
		}
		
		try {
			String passwordHash = PasswordGeneratorUtil.createPasswordHash();
			//Update password hash
			user.setPasswordHash(passwordHash);
			user.setPasswordHashDate(DateUtil.currentTime());
			userDAO.update(user);
			
			//Send mail
			String passwordResetUrl = Lib.getSiteUrl(request) +"/resetPassword.sp?code=" + URLEncoder.encode(passwordHash, "UTF-8");			
			String userName = StringUtils.hasText(user.getUserName()) ? user.getUserName() : user.getUserEmail();
			Map<String, Object> templateVars = Lib.buildParamsMap(new String[] {
					"userName", "passwordResetUrl" }, new String[] { userName,
					passwordResetUrl });
			mailSender.sendUsingFreeMarkerTemplate(userEmail, "Reset Password",
					MailTemplateConstants.EMAIL_FORGOT_PASSWORD, templateVars);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Failed to send forgot password email", e);
		}
	}
	
	
	public int validateUserPasswordHash(String passwordHash) {
		User user = userDAO.findByPasswordHash(passwordHash);
		if (user == null) {
			return WebConstants.FixValue.PASSWORD_HASH_NOT_EXIST;
		}

		try {
			Date passwordHashDate = user.getPasswordHashDate();
			Calendar pwdHashCalendar = Calendar.getInstance();
			pwdHashCalendar.setTime(passwordHashDate);
			pwdHashCalendar.add(Calendar.DAY_OF_MONTH, WebConstants.FixValue.PASSWORD_HASH_DAYS_TO_EXPIRE);

			Date currentDate = DateUtil.currentTime();
			Calendar currentCalendar = Calendar.getInstance();
			currentCalendar.setTime(currentDate);

			if (pwdHashCalendar.before(currentCalendar)) {
				return WebConstants.FixValue.PASSWORD_HASH_EXPIRED;
			}

			return WebConstants.FixValue.PASSWORD_HASH_VALID;
		} catch (Exception e) {
			throw new RuntimeException("Error when validate user's password hash with passwordHash[" + passwordHash + "]", e);
		}
	}
	
	
	public int updateResetPassword(String passwordHash, String newPassword) {
		User user = userDAO.findByPasswordHash(passwordHash);
		if (user == null) {
			return WebConstants.FixValue.PASSWORD_HASH_NOT_EXIST;
		}
		try {
			Date passwordHashDate = user.getPasswordHashDate();
			Calendar pwdHashCalendar = Calendar.getInstance();
			pwdHashCalendar.setTime(passwordHashDate);
			pwdHashCalendar.add(Calendar.DAY_OF_MONTH, WebConstants.FixValue.PASSWORD_HASH_DAYS_TO_EXPIRE);

			Date currentDate = DateUtil.currentTime();
			Calendar currentCalendar = Calendar.getInstance();
			currentCalendar.setTime(currentDate);

			if (pwdHashCalendar.before(currentCalendar)) {
				return WebConstants.FixValue.PASSWORD_HASH_EXPIRED;
			}
			
			String newEncodePassword = passwordEncoder.encodePassword(newPassword,user.getUserEmail());
			int defaultPasswordHistory = ConfigManager.getInstance().getIntProperty(ConfigConstants.DEFAULT_PASSWORD_HISTORY);
			List<UserPassword> userPasswords = userPasswordDAO.findByUserId(user.getUserId(), defaultPasswordHistory);
			for (UserPassword userPassword : userPasswords) {
				if (newEncodePassword.equals(userPassword.getUserPassword())) {
					return WebConstants.FixValue.PASSWORD_USED_ALREADY;
				}
			}

			user.setUserPassword(newEncodePassword);
			user.setPasswordLastChangedDate(DateUtil.currentTime());
			user.setPasswordExpired(false);

			// clear password hash and password reset date
			user.setPasswordHash(null);
			user.setPasswordHashDate(null);
			
			this.userDAO.update(user);
			
			trackUserPassword(user, newEncodePassword);

			return WebConstants.FixValue.PASSWORD_HASH_VALID;
		} catch (Exception e) {
			throw new RuntimeException("Error when update user's password hash with passwordHash[" + passwordHash + "]", e);
		}
	}
}
