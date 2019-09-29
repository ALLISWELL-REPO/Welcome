package com.citybank.statementdtls.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.citybank.statementdtls.dao.config.DaoJavaConfig;


@Configuration
@ComponentScan(basePackages={"com.citybank.statementdtls.service.builder","com.citybank.statementdtls.process.builder",
		"com.citybank.statementdtls.service.validator","com.citybank.statementdtls.process.impl",
})

@Import(DaoJavaConfig.class)
public class ServiceJavaConfig {

	
}
