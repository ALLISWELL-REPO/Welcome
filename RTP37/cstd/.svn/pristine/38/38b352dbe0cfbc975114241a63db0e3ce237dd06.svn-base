package com.citybank.stmtdtlssvc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.citybank.spring.rest.javaConfig.ClientJavaConfig;
import com.citybank.stmtdtlssvc.web.dao.CustomerDao;
import com.citybank.stmtdtlssvc.web.dao.CustomerDaoImpl;
import com.citybank.stmtdtlssvc.web.dao.LoginDao;
import com.citybank.stmtdtlssvc.web.dao.LoginDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.citybank.stmtdtlssvc.web.controller", "com.citybank.stmtdtlssvc.web.dao","com.citybank.stmtdtlssvc.web.views"})
@ImportResource("classpath:/mvc-config.xml")
@Import(value={ClientJavaConfig.class})
public class JavaConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}



	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("trasactionform.mvc").setViewName("trasactionform");
		registry.addViewController("cards.mvc").setViewName("cards");
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/RTP3735");
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

}
