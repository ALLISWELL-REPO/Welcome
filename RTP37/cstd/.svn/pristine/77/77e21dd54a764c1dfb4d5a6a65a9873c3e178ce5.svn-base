package com.citybank.cards.statement.bootservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.citybank.statementdtls.dao.config.DaoJavaConfig;
import com.citybank.statementdtls.process.StatementDtlsProcess;
import com.citybank.statementdtls.process.config.ProcessJavaConfig;
import com.citybank.statementdtls.process.impl.StatementDtlsProcessImpl;

@Configuration
@ComponentScan(basePackages={"com.citybank.statementdtls.process.builder","com.citybank.statementdtls.process.impl"})
@Import(value={DaoJavaConfig.class})
public class ServiceJavaConfig {
	

}
