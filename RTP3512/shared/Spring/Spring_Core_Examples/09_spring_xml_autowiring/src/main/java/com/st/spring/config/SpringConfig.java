package com.st.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:spring-config.xml")
@ComponentScan(basePackages="com.st.spring.core.beans")
public class SpringConfig {
	
}
