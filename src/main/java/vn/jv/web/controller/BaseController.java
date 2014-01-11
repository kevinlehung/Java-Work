package vn.jv.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;

import vn.jv.service.ISecurityService;
import vn.jv.web.security.SecurityHelper;

public abstract class BaseController {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired@Qualifier("sessionRegistry")
	protected SessionRegistry sessionRegistry;
	@Autowired@Qualifier("securityService")
	private ISecurityService securityService;
	
	/**
	 * This method returns true if this request has been logined
	 * and still valid
	 * @param request
	 * @return
	 */
	protected boolean isAlreadyLoginedAndStillValid(HttpServletRequest request) {
		try {
			Authentication authentication = SecurityHelper.getLoginedAuthentication(request);
			HttpSession session = request.getSession(false);
        	final List<SessionInformation> sessions = sessionRegistry.getAllSessions(authentication.getPrincipal(), false);
            for (SessionInformation si : sessions) {
                if (si.getSessionId().equals(session.getId())) {
                    return true;
                }
            }
		} catch (Exception e) {}
        return false;
	}
	
}
