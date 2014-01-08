package vn.jv.web.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

import vn.jv.config.ConfigManager;
import vn.jv.constant.ConfigConstants;
import vn.jv.constant.WebConstants;
import vn.jv.db.dao.IUserDAO;
import vn.jv.db.entity.AcRole;
import vn.jv.db.entity.User;

/**
 * Contains static common methods for security module
 * 
 *
 */
public class SecurityHelper {
	private static final List<String> FREE_ACCESS_PAGES_OF_LOGINED_USER = new ArrayList<String>();
	static {
		FREE_ACCESS_PAGES_OF_LOGINED_USER.add("/main.sp");
		FREE_ACCESS_PAGES_OF_LOGINED_USER.add("/changePassword.sp");
		FREE_ACCESS_PAGES_OF_LOGINED_USER.add("/updatePassword.sp");
		FREE_ACCESS_PAGES_OF_LOGINED_USER.add("/pageNotFound.sp");
		FREE_ACCESS_PAGES_OF_LOGINED_USER.add("/siteCache");
		FREE_ACCESS_PAGES_OF_LOGINED_USER.add("/webservices/securityws/keepAlive");
	}
	
	private static final List<String> FREE_ACCESS_PAGES_OF_EXPIRED_USER = new ArrayList<String>();
	static {
		FREE_ACCESS_PAGES_OF_EXPIRED_USER.add("/changePassword.sp");
		FREE_ACCESS_PAGES_OF_EXPIRED_USER.add("/updatePassword.sp");
	}
	
	public static boolean isFreeAccessPageOfExpiredUser(String pagePath) {
		return FREE_ACCESS_PAGES_OF_EXPIRED_USER.contains(pagePath);
	}
	
	public static boolean isFreeAccessPageOfLoginedUser(String pagePath) {
		return FREE_ACCESS_PAGES_OF_LOGINED_USER.contains(pagePath);
	}
	
	public static void saveLoginedUserToSession(HttpServletRequest request, User user){
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.setAttribute(WebConstants.SessionParams.LOGINED_USER, user);
		} else {
			throw new RuntimeException("No session found in the request " + request);
		}
	}
	
	public static void saveLoginedAuthenticationToSession(HttpServletRequest request, Authentication authentication){
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.setAttribute(WebConstants.SessionParams.LOGINED_AUTHENTICATION, authentication);
		} else {
			throw new RuntimeException("No session found in the request " + request);
		}
	}
	
	public static void saveLoginedUserRolesToSession(HttpServletRequest request, List<AcRole> roles) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.setAttribute(WebConstants.SessionParams.LOGINED_USER_ROLES, roles);
		} else {
			throw new RuntimeException("No session found in the request " + request);
		}
	}
	

	/**
	 * Return non-null/unmodifiable list of roles
	 * @param request
	 * @return
	 */
	public static List<AcRole> getLoginedUserRoles(HttpServletRequest request) {
		List<AcRole> loginedUserRoles = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			loginedUserRoles = Collections.unmodifiableList((List<AcRole>) session.getAttribute(WebConstants.SessionParams.LOGINED_USER_ROLES));
		}
		if(loginedUserRoles == null){
			loginedUserRoles = Collections.EMPTY_LIST;
		}
		return loginedUserRoles;
	}
	
	public static Authentication getLoginedAuthentication(HttpServletRequest request) {
		Authentication authentication = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			authentication = (Authentication) session.getAttribute(WebConstants.SessionParams.LOGINED_AUTHENTICATION);
		}
		if(authentication == null) {
			throw new RuntimeException("No authentication found in session of the request " + request);
		}
		return authentication;
	}
	
	public static User getLoginedUser(HttpServletRequest request) {
		User user = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			user = (User) session.getAttribute(WebConstants.SessionParams.LOGINED_USER);
		}
		if(user == null) {
			throw new RuntimeException("No logined user found in session of the request " + request);
		}
		return user;
	}
	
	/**
	 * Check if password exceeds the maximum age, we update PASSWORD_EXPIRED to true
	 * @param userDAO
	 * @param user
	 * @return
	 */
	public static boolean handlePasswordExpired(IUserDAO userDAO, User user) {
		if(user==null) {
			return false;
		}
		
		boolean isExpired = user.getPasswordExpired();
		if(isExpired == false) {
			Date lastDate = user.getPasswordLastChangedDate();
			if(lastDate != null) {
				Calendar calendar = Calendar.getInstance();
				int maxAge = ConfigManager.getInstance().getIntProperty(ConfigConstants.MAX_PASSWORD_AGE);
				calendar.add(Calendar.DAY_OF_MONTH, -maxAge);
				isExpired = lastDate.before(calendar.getTime()); 
			}
			if(isExpired && userDAO!=null) {
				user.setPasswordExpired(true);
				userDAO.update(user);
			}
		}
		return isExpired;
	}
	
	/**
	 * Send data to browser and commit the response
	 * @param response
	 * @param data
	 * @throws IOException
	 */
	public static void sendData(HttpServletResponse response, String data) throws IOException {
		response.getWriter().write(data);
		response.flushBuffer();
	}
	
	public static String getRequestUrl(HttpServletRequest request) {
		String requestUri = request.getRequestURI();
		String scheme = request.getScheme();
		String host = request.getServerName();
		int port = request.getServerPort();
		String portStr = ":" + port;
		if (port == 80 || (scheme.equals("https") && port == 443)) {
			portStr = "";
		}
		String requestUrl = scheme + "://" + host + portStr + requestUri;
		String queryStr = request.getQueryString();
		if (queryStr != null && !queryStr.isEmpty()) {
			requestUrl = requestUrl + "?" + queryStr;
		}
		return requestUrl;
	}
	
	public static List<String> getRequestHistories(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null){
			return Collections.EMPTY_LIST;
		}
		return (List<String>)session.getAttribute(WebConstants.SessionParams.REQUEST_HISTORIES);
	}
	
	public static String getPreviousRequestUrl(HttpServletRequest request) {
		List<String> requestHistories = getRequestHistories(request);
		if(requestHistories.size() > 1) {
			return requestHistories.get(requestHistories.size() - 2);
		}
		return "";
	}
	
	public static String getTimezone(HttpServletRequest request) {
		String timeZone = request.getParameter(WebConstants.Params.TIME_ZONE);
		if (timeZone != null && WebConstants.TIME_ZONES.containsKey(timeZone)) {
			timeZone = WebConstants.TIME_ZONES.get(timeZone);
		} else {
			timeZone = "";
		}
		return timeZone;
	}
}
