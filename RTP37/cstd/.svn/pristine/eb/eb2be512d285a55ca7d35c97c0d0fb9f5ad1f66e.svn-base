package org.o2.registersvc.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "org.o2.registersvc.intg.impl")
@ImportResource()
public class IntgSpringConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		System.out.println("enter into data source");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/RTP3602");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	@Bean(name = "jt")
	public JdbcTemplate getTemplate() {
		System.out.println("enter into jdbc template");
		JdbcTemplate template = new JdbcTemplate(dataSource());
		System.out.println("In bean getTemplate::" + template);
		return template;
	}

}
