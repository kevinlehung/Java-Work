package vn.jv.web.security;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import vn.jv.config.ConfigManager;
import vn.jv.constant.ConfigConstants;
import vn.jv.db.dao.IUserDAO;
import vn.jv.db.dao.IUserLoginDAO;
import vn.jv.db.entity.UserLogin;

/**
 * Customization to handle webservices failure login
 * 
 *
 */
public class JvFailureLoginHandler extends SimpleUrlAuthenticationFailureHandler {
	@Autowired@Qualifier("userDAO")
	private IUserDAO userDAO;
	@Autowired@Qualifier("userLoginDAO")
	private IUserLoginDAO userLoginDAO;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		vn.jv.db.entity.User user = auditFailedLogin(request, exception);
    	super.onAuthenticationFailure(request, response, exception);
	}

	private vn.jv.db.entity.User auditFailedLogin(HttpServletRequest request, AuthenticationException exception){
		if(!(exception instanceof BadCredentialsException)) {
			return null;
		}
		Authentication authentication = exception.getAuthentication();
		String userEmail = (String) authentication.getPrincipal();
		vn.jv.db.entity.User user = userDAO.findByEmail(userEmail);
		if(user==null) {
			return null;
		}
		Timestamp now = new Timestamp(System.currentTimeMillis());
		updateLoginAttemptsAndLockAccountIfNeeded(user);
		String timeZone = SecurityHelper.getTimezone(request);
		userLoginDAO.auditNewLogin(request.getRemoteAddr(), user, now, UserLogin.LOGIN_FAILED, timeZone);
		return user;
	}
	
	private void updateLoginAttemptsAndLockAccountIfNeeded(vn.jv.db.entity.User user) {
		int maxAttempts = ConfigManager.getInstance().getIntProperty(ConfigConstants.MAX_FAILED_LOGIN_ATTEMPTS);
		int failedAttempts = user.getFailedLoginAttempts() + 1;
		int minInterval = ConfigManager.getInstance().getIntProperty(ConfigConstants.MIN_FAILED_LOGIN_ATTEMPT_INTERVAL);
		Timestamp lastFailedDate = user.getLastFailedLoginDate();
		long lastLogin = 0;
		if (lastFailedDate != null) {
			lastLogin = lastFailedDate.getTime();
		}
		long now = System.currentTimeMillis();
		boolean loginNotAllowed = now < (lastLogin + minInterval * 1000);
		if (loginNotAllowed && failedAttempts >= maxAttempts) {
			/**
			 * Exceed maximum attempts, we lock this account
			 */
			user.setAccountLocked(Boolean.TRUE);
			user.setFailedLoginAttempts(0);
			user.setLastFailedLoginDate(new Timestamp(System.currentTimeMillis()));
		} else {
			if (loginNotAllowed) {
				/**
				 * If time between two failed successive login attempts < MIN_FAILED_LOGIN_ATTEMPT_INTERVAL 
				 * we increase the failed attempts
				 */
				user.setFailedLoginAttempts(failedAttempts);
			} else {
				user.setFailedLoginAttempts(0);
			}
			user.setLastFailedLoginDate(new Timestamp(System.currentTimeMillis()));
		}
		userDAO.update(user);
	}

}
