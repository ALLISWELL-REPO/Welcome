package org.o2.registersvc.process.springconfig;

import org.o2.registersvc.integration.config.IntgSpringConfig;
import org.o2registersvc.creditcheck.springconfig.CreditCheckSpringConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {CreditCheckSpringConfig.class,IntgSpringConfig.class })
@ComponentScan(basePackages = { "org.o2.registersvc.process.impl",
		"org.o2.registersvc.process.builder"})
public class SpringConfig {

}
