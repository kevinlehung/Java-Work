package vn.jv.web.common.util;

import org.springframework.security.core.context.SecurityContextHolder;

import vn.jv.security.bean.JvUserDetails;

/**
 * Contains utility methods for security
 * @author hunglevn@outlook.com
 *
 */
public class SecurityUtil {
	public static JvUserDetails getUserDetail() {
		return (JvUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
	}
	
}
