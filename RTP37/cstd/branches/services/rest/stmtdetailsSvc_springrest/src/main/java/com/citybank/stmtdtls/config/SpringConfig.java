package com.citybank.stmtdtls.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("com.citybank.stmtdtls.controller")
public class SpringConfig extends WebMvcConfigurerAdapter {
	static{
		System.out.println("spring configuration loaded");
	}
	public MappingJackson2HttpMessageConverter jacksonConverter(){
		return new MappingJackson2HttpMessageConverter();
		
	}

}
