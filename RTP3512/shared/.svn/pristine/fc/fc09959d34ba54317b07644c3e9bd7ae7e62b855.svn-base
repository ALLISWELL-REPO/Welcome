package com.st.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Profile(value="qa")
@ComponentScan(basePackages="com.st.spring.core.beans")
@PropertySource("classpath:sample-qa.properties")
public class QASpringConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySource() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
