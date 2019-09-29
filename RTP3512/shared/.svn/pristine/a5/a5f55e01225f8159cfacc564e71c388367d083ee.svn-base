package com.st.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages="com.st.spring.core.beans")
public class SpringConfig {
	
	@Bean
	@Profile("dev")
	public PropertySourcesPlaceholderConfigurer devEnvProperties() {
		PropertySourcesPlaceholderConfigurer placeHolder = new PropertySourcesPlaceholderConfigurer();
		placeHolder.setLocation(new ClassPathResource("sample-dev.properties"));
		return placeHolder;
	}
	
	@Bean
	@Profile("qa")
	public PropertySourcesPlaceholderConfigurer qaEnvProperties() {
		PropertySourcesPlaceholderConfigurer placeHolder = new PropertySourcesPlaceholderConfigurer();
		placeHolder.setLocation(new ClassPathResource("sample-qa.properties"));
		return placeHolder;
	}
	
	@Bean
	@Profile("prod")
	public PropertySourcesPlaceholderConfigurer prodEnvProperties() {
		PropertySourcesPlaceholderConfigurer placeHolder = new PropertySourcesPlaceholderConfigurer();
		placeHolder.setLocation(new ClassPathResource("sample-prod.properties"));
		return placeHolder;
	}

}
