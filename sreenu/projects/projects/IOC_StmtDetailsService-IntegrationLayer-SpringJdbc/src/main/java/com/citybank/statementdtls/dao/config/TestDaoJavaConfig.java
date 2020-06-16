package com.citybank.statementdtls.dao.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.citybank.statementdtls.dao.impl.StatementDtlsDAO;
import com.citybank.statementdtls.dao.impl.StatementDtlsDAOImpl;

@Configuration
@ComponentScan(basePackages = {})
@Profile(value = "test")
@PropertySource("classpath:properties/getTransaction-prod.properties")
public class TestDaoJavaConfig {

	@Autowired
	Environment environment = null;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment
				.getProperty("db_driver_className"));
		dataSource.setUrl(environment.getProperty("db_url"));
		dataSource.setUsername(environment.getProperty("db_user"));
		dataSource.setPassword(environment.getProperty("db_password"));

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		return jdbcTemplate;
	}

	@Bean
	public StatementDtlsDAO daoImpl(JdbcTemplate jdbcTemplate) {
		System.out.println(environment.getProperty("enve"));
		StatementDtlsDAO daoImpl = new StatementDtlsDAOImpl(jdbcTemplate);
		return daoImpl;

	}

}