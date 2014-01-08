package vn.jv.web.security;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.web.FilterInvocation;

import vn.jv.db.entity.AcRole;
import vn.jv.service.ISecurityService;

/**
 * Custom AccessDecisionManager used to query ac_xxx tables to grant authorization
 * 
 * 
 * 
 */
public class JvAccessDecisionManager implements AccessDecisionManager {
	protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
	@Autowired@Qualifier("securityService")
	private ISecurityService securityService;

	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws org.springframework.security.access.AccessDeniedException,
			InsufficientAuthenticationException {
		boolean hasPermission = false;
		Object principal = authentication.getPrincipal();
		String requestURI = "";
		if (principal instanceof org.springframework.security.core.userdetails.User
				&& object instanceof FilterInvocation) {
			FilterInvocation filterInvocation = (FilterInvocation) object;
			HttpServletRequest request = filterInvocation.getHttpRequest();
			requestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			if(requestURI.endsWith("/")) {
				requestURI = requestURI.substring(0, requestURI.length()-1);
			}
			String pagePath = requestURI.substring(contextPath.length());
			if(requestURI.equals(contextPath) || SecurityHelper.isFreeAccessPageOfLoginedUser(pagePath)) {
				/**
				 * Access to root /Jv or /Jv/home.jv
				 */
				return;
			}
			String resourceIdentifier = requestURI.substring(request.getContextPath().length());
			List<AcRole> loginedUserRoles = SecurityHelper.getLoginedUserRoles(request);
			hasPermission = securityService.hasPermission(loginedUserRoles, resourceIdentifier);
		}
		if(!hasPermission) {
			throw new AccessDeniedException("You do not have permission to access this resource '" + requestURI + "'");
		}
	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
