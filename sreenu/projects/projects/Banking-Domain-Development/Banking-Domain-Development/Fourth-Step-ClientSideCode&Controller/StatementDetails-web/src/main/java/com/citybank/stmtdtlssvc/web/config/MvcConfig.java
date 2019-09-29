package com.citybank.stmtdtlssvc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.citybank.stmtdtlssvc.client.StatementDtlsSvcClient;
import com.citybank.stmtdtlssvc.client.impl.StatementDtlsSvcClientImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages =  "com.citybank.stmtdtlssvc.web.controller" )
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsps/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public StatementDtlsSvcClient statementDtlsSvcClient() {

		StatementDtlsSvcClientImpl clientImpl = new StatementDtlsSvcClientImpl();

		return clientImpl;
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("transactionform.mvc").setViewName(
				"transactionform");
	}

}
