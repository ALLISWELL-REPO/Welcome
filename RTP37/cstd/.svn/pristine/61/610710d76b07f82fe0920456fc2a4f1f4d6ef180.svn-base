package org.o2.register.process.springconfig;


import org.o2.registersvc.config.IntegSpringConfig.IntegSpringConfig;
import org.o2registersvc.creditcheck.springconfig.CreditCheckSpringConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "org.o2.registersvc.process.impl",
		"org.o2.registersvc.process.builder","org.o2.registersvc.process.beans"})
@Import(value = {CreditCheckSpringConfig.class,IntegSpringConfig.class})
public class ProcessSpringConfig {

}
