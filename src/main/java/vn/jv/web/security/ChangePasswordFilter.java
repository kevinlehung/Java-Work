package vn.jv.web.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import vn.jv.db.entity.User;

public class ChangePasswordFilter extends OncePerRequestFilter {
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		if(requestURI.endsWith("/")) {
			requestURI = requestURI.substring(0, requestURI.length()-1);
		}
		String pagePath = requestURI.substring(contextPath.length());
		if (!SecurityHelper.isFreeAccessPageOfExpiredUser(pagePath)) {
			User user = SecurityHelper.getLoginedUser(request);
			if (user.getPasswordExpired()) {
				response.sendRedirect("changePassword.sp");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

}
