package vn.jv.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {
	@Bean 
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
}
