package vn.jv.web.common.util;

import org.springframework.security.core.context.SecurityContextHolder;

import vn.jv.persist.domain.User;
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
	
	public static User getCurrentUser() {
		JvUserDetails userDetail = (JvUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User jvUser = userDetail.getJvUser();
		return jvUser;
	}
	
}
