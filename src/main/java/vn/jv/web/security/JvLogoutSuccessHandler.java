package vn.jv.web.security;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import vn.jv.db.dao.IUserDAO;
import vn.jv.db.dao.IUserLoginDAO;

/**
 * Customized to handle RESTFul logout request
 * 
 *
 */
public class JvLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	
	@Autowired@Qualifier("userDAO")
	private IUserDAO userDAO;
	@Autowired@Qualifier("userLoginDAO")
	private IUserLoginDAO userLoginDAO;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		this.auditLogout(request, authentication);
		super.onLogoutSuccess(request, response, authentication);
	}

	
	/**
	 * Update logout info so we can track later
	 * @param request 
	 * @param userEmail
	 * @return
	 */
	private void auditLogout(HttpServletRequest request, Authentication authentication){
		if(authentication==null){
			return;
		}
		vn.jv.db.entity.User user = userDAO.findByEmail(authentication.getName());
		if(user==null) {
			return ;
		}
		Timestamp now = new Timestamp(System.currentTimeMillis());
		userLoginDAO.auditLogout(request.getRemoteAddr(), user, now, "");
	}
}
