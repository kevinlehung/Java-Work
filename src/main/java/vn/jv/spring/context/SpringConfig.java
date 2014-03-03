package vn.jv.spring.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Configuration
@ComponentScan(basePackages = {"vn.jv.persist.repositories", "vn.jv.service"})
@EnableAspectJAutoProxy
public class SpringConfig {

}
