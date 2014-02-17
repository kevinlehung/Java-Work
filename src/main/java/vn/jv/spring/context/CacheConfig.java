package vn.jv.spring.context;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Configuration
@EnableCaching
public class CacheConfig {
	 @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }
    @Bean
    public CacheManager cacheManager() {
        EhCacheCacheManager cacheManager = new EhCacheCacheManager();
        cacheManager.setCacheManager(ehCacheManagerFactoryBean().getObject());
        return cacheManager;
    }
	
	/*
	@Bean(name = "cacheManagerx")
	public CacheManager cacheManager() {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		
		
		ehCacheManagerFactoryBean.setAcceptExisting(true);
		ehCacheManagerFactoryBean.setCacheManagerName("javaword");
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		ehCacheManagerFactoryBean.setShared(true);
		
		net.sf.ehcache.CacheManager cacheManager = ehCacheManagerFactoryBean.getObject();
		EhCacheCacheManager ehCacheCacheManager =  new EhCacheCacheManager();
		ehCacheCacheManager.setCacheManager(cacheManager);
		return ehCacheCacheManager;
	}*/
}
