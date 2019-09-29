package com.citybank.stmtdtls.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.citybank.stmtdtls.web.dao.CustomerDao;
import com.citybank.stmtdtls.web.dao.CustomerDaoImpl;
import com.citybank.stmtdtls.web.dao.LoginDao;
import com.citybank.stmtdtls.web.dao.LoginDaoImpl;

//import com.citybank.stmtdtlssvc.client.StatementDtlsSvcClient;
//import com.citybank.stmtdtlssvc.client.impl.StatementDtlsSvcClientImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.citybank.stmtdtls.web.controller",
		"com.citybank.stmtdtls.web.dao" })
public class MvcConfig extends WebMvcConfigurerAdapter {
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsps/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	/*@Bean
	public StatementDtlsSvcClient statementDtlsSvcClient() {
		StatementDtlsSvcClientImpl clientImpl = new StatementDtlsSvcClientImpl();
		return clientImpl;
	}*/

	@Bean
	public JdbcTemplate jdbcTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/stech");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	@Bean
	public LoginDao loginDao1() {
		LoginDao loginDao = new LoginDaoImpl();
		return loginDao;
	}

	@Bean
	public CustomerDao customerDao1() {
		CustomerDao customerDao = new CustomerDaoImpl();
		return customerDao;
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("transactionform.mvc").setViewName(
				"transactionform");
		registry.addViewController("cards.mvc").setViewName("cards");

	}

}
