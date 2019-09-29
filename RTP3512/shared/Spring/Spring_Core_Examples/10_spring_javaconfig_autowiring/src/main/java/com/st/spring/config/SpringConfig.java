package com.st.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.st.spring.core.beans.BlackInk;
import com.st.spring.core.beans.interfaces.Ink;

@Configuration
@ComponentScan(basePackages="com.st.spring.core.beans")
public class SpringConfig {

	@Bean
	public Ink blackInk() {
		return new BlackInk();
	}
}
