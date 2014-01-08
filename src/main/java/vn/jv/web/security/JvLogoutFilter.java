package vn.jv.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * Customized to handle webservices RESTFul logout request like 
 * https://localhost:8443/Jv/webservices/securityws/logout;jsessionid=XXXXX
 * 
 *
 */
public class JvLogoutFilter extends LogoutFilter {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	public JvLogoutFilter(LogoutSuccessHandler logoutSuccessHandler, LogoutHandler[] handlers) {
		super(logoutSuccessHandler, handlers);
	}

	public JvLogoutFilter(String logoutSuccessUrl, LogoutHandler[] handlers) {
		super(logoutSuccessUrl, handlers);
	}
	
}
