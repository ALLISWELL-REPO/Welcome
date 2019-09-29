package com.citybank.statementdtls.dao.impl;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.citybank.statementdtls.dao.StatementDtlsDAO;

@Configuration
@ComponentScan(basePackages="com.citybank.statementdtls.dao")
public class StatementInfoConfig {
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/RTP_3710");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
		
	}
	@Bean
	public JdbcTemplate jdbcTemplate(){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
		}
	
	@Bean
	public StatementDtlsDAO statementDao(){
		StatementDtlsSpringImpl stmtdaoImpl=new StatementDtlsSpringImpl(jdbcTemplate());
		stmtdaoImpl.setJdbcTemplate(jdbcTemplate());
		return stmtdaoImpl;
	}

}
