package vn.jv.web.security;

import org.springframework.security.core.AuthenticationException;

/**
 * 
 * 
 *
 */
public class UserNotFoundException extends AuthenticationException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
    
    public UserNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
