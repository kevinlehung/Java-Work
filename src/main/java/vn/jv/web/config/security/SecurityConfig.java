package vn.jv.web.config.security;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String REMEMBER_ME_KEY = UUID.randomUUID().toString();
	private static final String REMEMBER_ME_PARAMETER = "rememberMe";
	
	@Autowired@Qualifier("jvUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Autowired@Qualifier("jvAuthenticationSuccessHandler")
	private AuthenticationSuccessHandler jvAuthenticationSuccessHandler;
	
	@Autowired@Qualifier("rememberMeServices")
	private RememberMeServices rememberMeServices;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/assets/**"); // #3
	}

	@Bean 
	public AuthenticationManager jvAuthenticationManager() throws Exception {
		return authenticationManager();
	}
	
	/**
	 * Customize REMEMBER_ME_PARAMETER. 
	 * Issue: Default value is "remember-me". We cannot bind this parameter to form
	 * Resolve: Change remember me parameter to "rememberMe"
	 * @return
	 */
	@Bean RememberMeServices rememberMeServices() {
		TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices(REMEMBER_ME_KEY, userDetailsService);
		rememberMeServices.setParameter(REMEMBER_ME_PARAMETER);
		return rememberMeServices;
	}
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        	.antMatchers("/assets/**", "/sec/sign_up.jv", "/about").permitAll()  
            .antMatchers("/**").hasAuthority("USER")
            .and()
        .formLogin()
            .loginPage("/sec/sign_in.jv")
            .usernameParameter("email")
            .passwordParameter("password")
            .loginProcessingUrl("/sec/security_check.jv")
            .failureHandler(new JvAuthenticationFailureHandler())
            .successHandler(jvAuthenticationSuccessHandler)
            .defaultSuccessUrl("/u/jobs_list.jv")
            .permitAll();
		
		http.logout().logoutUrl("/sec/sign_out.jv").logoutSuccessUrl("/sec/sign_in.jv");
		
		http.rememberMe().key(REMEMBER_ME_KEY).rememberMeServices(rememberMeServices);
	}

	public static void main (String[] args) {
		System.out.println("4e604e36-3247-41ef-bfcc-789dd9fcf8c2".hashCode());
	}
}
