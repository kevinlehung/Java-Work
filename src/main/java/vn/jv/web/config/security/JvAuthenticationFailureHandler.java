package vn.jv.web.config.security;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * Handler processing for Authentication Failure
 * 
 * @author hunglevn@outlook.com
 *
 */
public class JvAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	private static final String FAILURE_URL = "/sec/sign_in.jv?error=1";
	public JvAuthenticationFailureHandler() {
		/**
		 * for keeping ModelAttribute in target model;
		 */
		this.setUseForward(true);
		this.setDefaultFailureUrl(FAILURE_URL);
	}
}
