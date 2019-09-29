package org.nhs.patientinfo.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.nhs.patientinfo.resourcecontroller")
public class MvcConfig extends WebMvcConfigurerAdapter {

	static {
		System.out.println("SpringConfig loaded..");
	}

	@Bean
	public MappingJackson2HttpMessageConverter jacksonConverter() {
		return new MappingJackson2HttpMessageConverter();
	}

}
