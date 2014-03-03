package vn.jv.security.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class JvUserDetails extends User {
	private static final long serialVersionUID = -3614724270308267823L;
	
	private vn.jv.persist.domain.User jvUser;
	
	public JvUserDetails(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, vn.jv.persist.domain.User jvUser) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.jvUser = jvUser;
	}

	public vn.jv.persist.domain.User getJvUser() {
		return jvUser;
	}

	public void setJvUser(vn.jv.persist.domain.User jvUser) {
		this.jvUser = jvUser;
	}
	
	

}
