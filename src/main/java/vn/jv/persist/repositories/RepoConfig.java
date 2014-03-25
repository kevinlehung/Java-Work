package vn.jv.persist.repositories;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySources({
    @PropertySource("classpath:/vn/jv/config/db_config.properties")
})
@EnableJpaRepositories(
	basePackages = "vn.jv.persist.repositories")
@ComponentScan({
    "vn.jv.persist.repositories"
})
public class RepoConfig {
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";  
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";  
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";  
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";  
    
    private static final String PERSISTENCE_UNIT_NAME = "javawork";
    
    @Resource  
    private Environment env;
      
    /*@Bean  
    public DataSource dataSource() {  
        DriverManagerDataSource dataSource = new DriverManagerDataSource();  

        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));  
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));  
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));  
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));  

        return dataSource;  
    }*/
    
    @Bean()
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {  
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean(); 
        entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
        //entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("vn.jv.persist.domain");
        return entityManagerFactoryBean;  
    }  
      
    @Bean  
    public JpaTransactionManager transactionManager() {  
        JpaTransactionManager transactionManager = new JpaTransactionManager();  
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());  
        //transactionManager.setNestedTransactionAllowed(true);
        return transactionManager;  
    }
}
