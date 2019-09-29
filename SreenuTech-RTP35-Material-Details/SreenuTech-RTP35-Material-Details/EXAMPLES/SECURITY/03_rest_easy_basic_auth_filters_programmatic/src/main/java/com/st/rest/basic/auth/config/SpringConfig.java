package com.st.rest.basic.auth.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages="com.st.rest.basic.auth")
@PropertySource("classpath:jdbc.properties")
@ImportResource("classpath:spring-config.xml")
public class SpringConfig {
	
	@Autowired
	private Environment env;

	@Bean
    public DataSource datasource() throws PropertyVetoException {
		
		String databaseDriverClassName = env.getProperty("spring.datasource.driverClassName");
		String datasourceUrl = env.getProperty("spring.datasource.url");
		String databaseUsername = env.getProperty("spring.datasource.username");
		String databasePassword = env.getProperty("spring.datasource.password");
		int maxConnections = Integer.parseInt(env.getProperty("spring.datasource.connection"));

    	ComboPooledDataSource dataSrc = new ComboPooledDataSource();
    	dataSrc.setDriverClass(databaseDriverClassName);
    	dataSrc.setJdbcUrl(datasourceUrl);
    	dataSrc.setUser(databaseUsername);
    	dataSrc.setPassword(databasePassword);
    	dataSrc.setMaxPoolSize(maxConnections);
    	
    	System.out.println("DataSource initialisation completed successfully");
    	return dataSrc;
    }
    
    @Bean 
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
    	System.out.println("JDBC Initialisation called");
    	return new NamedParameterJdbcTemplate(dataSource);
    }
  
}
