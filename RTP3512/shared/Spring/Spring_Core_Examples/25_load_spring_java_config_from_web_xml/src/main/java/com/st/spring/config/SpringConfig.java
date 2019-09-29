package com.st.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.st.spring.core.beans.Writer;

@Configuration
@ComponentScan(basePackages="com.st.spring.core.beans")
public class SpringConfig {
	
	@Autowired
	private Writer writer;

	@Bean
	public String checkIfSpringConfigLoads() {
		writer.write();
		return "Nothing";
	}
}
