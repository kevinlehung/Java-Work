package vn.jv.web.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired@Qualifier("jvUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Autowired@Qualifier("jvAuthenticationSuccessHandler")
	private AuthenticationSuccessHandler jvAuthenticationSuccessHandler;
	
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

	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        	.antMatchers("/assets/**", "/signup", "/about").permitAll()  
            .antMatchers("/**").hasAuthority("USER")
            .and()
        .formLogin()
            .loginPage("/sign_in.jv")
            .usernameParameter("email")
            .passwordParameter("password")
            .failureUrl("/sign_in.jv?error")
            .loginProcessingUrl("/security_check.jv")
            .successHandler(jvAuthenticationSuccessHandler)
            //.defaultSuccessUrl("/jobs_list.jv")
            .permitAll();
		
		http.logout().logoutUrl("/logout");
	}

}
