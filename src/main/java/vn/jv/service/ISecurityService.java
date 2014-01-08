package vn.jv.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import vn.jv.db.entity.AcRole;
import vn.jv.db.entity.MenuItem;
import vn.jv.db.entity.User;


/**
 * 
 * 
 *
 */
public interface ISecurityService {
	/**
	 * Check ac_xxx tables to see if userEmail has permission to access this resourceIdentifier
	 * @param userEmail
	 * @param resourceIdentifier
	 * @return
	 */
	boolean hasPermission(String userEmail, String resourceIdentifier);

	boolean hasPermission(int userId, String resourceIdentifier);

	/**
	 * Check if given roles have permission to resourceIdentifier
	 * @param roles
	 * @param resourceIdentifier
	 * @return
	 */
	boolean hasPermission(List<AcRole> roles, String resourceIdentifier);
	/**
	 * Find menu items by users. This method includes checking role hierarchy of
	 * the user.
	 * 
	 * @param userId user id to find
	 * @return
	 */
	List<MenuItem> findMenuItemsByUserId(int userId);
	
	List<MenuItem> findMenuItemsByRoles(List<AcRole> roles);
	
	/**
	 * Reset password:
	 * 	1. Generate a password meeting complexity rules
	 *  2. Email the password to the user
	 *  3. Set flag requiring user to change password at next login
	 * @param userEmail
	 * @return
	 */
	String resetPassword(String userEmail);
	/**
	 * Reset password:
	 * 	1. Generate a password meeting complexity rules
	 *  2. Email the password to the user if initEmailPassword is true
	 *  3. Set flag requiring user to change password at next login
	 * @param userEmail
	 * @param initEmail Password
	 * @param newPassword
	 * @return
	 */
	public String resetPassword(String userEmail,boolean initEmailPassword,String newPassword);
	/**
	 * Send the forgot password email
	 * @param userEmail
	 * @param passwordResetUrl
	 * @return
	 */
	public boolean sendForgotPasswordEmail(String userEmail, HttpServletRequest request);
	/**
	 * Change password of a user:
	 * 	1. Validate the current password - if correct, validate the complexity of the new password 
	 * 	2. If current password is invalid return error message "Authentication Failure"
	 * 	3. If the complexity of the new password is incorrect, return error message "New password does not meet complexity requirements"
	 * 	4. If password is successfully changed return the standard authentication message to the client (roles & session)
	 * @param user
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public User changePassword(User user, String oldPassword, String newPassword);
	
	/**
	 * Change password of a user:
	 * 	1. Validate the current password - if correct, validate the complexity of the new password 
	 * 	2. If current password is invalid return error message "Authentication Failure"
	 * 	3. If the complexity of the new password is incorrect, return error message "New password does not meet complexity requirements"
	 * 	4. If password is successfully changed return the standard authentication message to the client (roles & session)
	 * @param userEmail
	 * @param oldPassword
	 * @param newPassword
	 * @return User who has changed his password successfully
	 */
	public User changePassword(String userEmail, String oldPassword, String newPassword);
	/**
	 * Create a new User into database:
	 *     If isEmailInitPassowrd is checked then system will be auto generate password and send email to user
	 *     
	 * @param User user object
	 * @param isEmailInitpassword
	 */
	public void createUser(User user, boolean isEmailInitPassword);
	/***
	 * Check user email is unique in database
	 *    
	 * @param email
	 * @return  true mean valid email
	 * 			false that email is existed  in database 
	 */
	public boolean validateUniqueEmail(String email);

	/***
	 * Active user when it has value of "ACTIVE" column is 0
	 * @param userId
	 */
	public void activeUser(int userId);
	/***
	 * Deactive user when it has value of  "ACTIVE" column is 1
	 * @param userId
	 */
	public void deactiveUser(int userId);
	/***
	 * Unlock user account when account is locked 
	 * @param userId
	 */
	public void unlockAccount(int userId);
	public void updateUser(User user);
	
	public int validateUserPasswordHash(String passwordHash);
	public int updateResetPassword(String passwordHash, String newPassword);
}
