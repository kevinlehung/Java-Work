package vn.jv;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import vn.jv.persist.repositories.RepoConfig;
import vn.jv.spring.context.CacheConfig;
import vn.jv.spring.context.SpringConfig;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(loader= AnnotationConfigContextLoader.class, classes = {/*WebConfig.class, */SpringConfig.class, CacheConfig.class, RepoConfig.class})
public class BaseTester {

}
