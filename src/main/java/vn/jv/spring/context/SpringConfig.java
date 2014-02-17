package vn.jv.spring.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Configuration
@ComponentScan(basePackages = {"vn.jv.persist.repositories", "vn.jv.service"})
public class SpringConfig {

}
