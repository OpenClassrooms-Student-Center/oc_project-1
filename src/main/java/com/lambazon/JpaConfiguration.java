package com.lambazon;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "com.lambazon.domain")
@EnableJpaRepositories(basePackages = "com.lambazon.repository")
@PropertySource("application.properties")
@EnableTransactionManagement
public class JpaConfiguration {
 
    @Autowired
    private Environment env;
     
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    @Bean
    public DataSource dataSource() {
    	log.info("OC-Creating datasource");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("h2.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("h2.datasource.url"));
        dataSource.setUsername(env.getProperty("h2.datasource.username"));
        dataSource.setPassword(env.getProperty("h2.datasource.password"));
        return dataSource;
    }
     
    // configure entityManagerFactory
     
    // configure transactionManager
 
    // configure additional Hibernate Properties
  

}