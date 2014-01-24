package vn.jv.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.IUserRepo;
import vn.jv.security.bean.JvUserDetails;

@Component
public class JvUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserRepo userRepo;
	
	public UserDetails loadUserByUsername(String userEmail)
			throws UsernameNotFoundException {
		User user = null;
		try {
			user = userRepo.findByUserEmail(userEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String password = user.getUserPassword();
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		UserDetails userDetails = new JvUserDetails(userEmail, password, enabled,
				accountNonExpired, credentialsNonExpired,
				accountNonLocked,
				authorities);
		return userDetails;
	}

}
