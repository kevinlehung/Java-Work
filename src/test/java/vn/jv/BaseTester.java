package vn.jv;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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
@ContextConfiguration(classes = {WebConfig.class, SpringConfig.class, CacheConfig.class, RepoConfig.class, ServiceConfig.class})
public class BaseTester {
	@Resource
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMVC;

    @Before
    public void setUp() {
        mockMVC = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
