package vn.jv;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import vn.jv.persist.repositories.RepoConfig;
import vn.jv.spring.context.CacheConfig;
import vn.jv.spring.context.ServiceConfig;
import vn.jv.spring.context.SpringConfig;
import vn.jv.web.config.WebConfig;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(loader= AnnotationConfigContextLoader.class, classes = {WebConfig.class, SpringConfig.class, CacheConfig.class, RepoConfig.class, ServiceConfig.class})
public class BaseTester {

}
