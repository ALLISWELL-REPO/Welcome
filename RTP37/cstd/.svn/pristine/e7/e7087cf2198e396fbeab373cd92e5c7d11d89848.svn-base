package com.citybank.spring.rest.javaConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(basePackages = { "com.citybank.spring.rest.client", "com.citybank.stmtdtlssvc.client.builder" })
public class ClientJavaConfig {
	/*
	 * @Bean public ObjectMapper getObjectMapper(){ ObjectMapper mapper = new
	 * ObjectMapper(); return mapper; }
	 */

/*//	@Bean //by default it support
	public MappingJackson2HttpMessageConverter restTemplate() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
		converter.setObjectMapper(mapper);
		System.out.println("bean");
		return converter;
	}*/
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
		converter.setObjectMapper(mapper);
		return restTemplate;
	}

}

/*@Bean
public RestTemplate restTemplate() {
	RestTemplate restTemplate = new RestTemplate();
	List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
	converter.setObjectMapper(mapper);
	return restTemplate;
}*/
