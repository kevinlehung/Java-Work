package vn.jv.web.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.jv.db.dao.IUserDAO;
import vn.jv.db.entity.User;

@Service
public class JvUserDetailsService implements UserDetailsService {
	@Autowired@Qualifier("userDAO")
	private IUserDAO userDAO;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, DataAccessException {
		User user = userDAO.findByEmail(email);
		UserDetails userDetails = null;
		if(user!=null) {
			boolean nonLock = !user.getAccountLocked();
			boolean credentialsNonExpired = true;//!user.getPasswordExpired();
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			userDetails = new org.springframework.security.core.userdetails.User(
					user.getUserEmail(), user.getUserPassword(), true, true, credentialsNonExpired, nonLock, authorities);
		} else {
			throw new UserNotFoundException("Could not find any user with email '" + email + "'");
		}
		return userDetails;
	}
}
