package com.st.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Profile("dev")
@ComponentScan(basePackages="com.st.spring.core.beans")
@PropertySource("classpath:sample-dev.properties")
public class DevelopmentSpringConfig {
	
	/**
	 * Add 'spring.profiles.active=dev' 
	 * in catalina.properties file which is in location 
	 * <Workspace_path>/Servers/Tomcat v8.0/Catalina.properties
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySource() {
		System.out.println("Loading dev spring configuration");
		return new PropertySourcesPlaceholderConfigurer();
	}

}
