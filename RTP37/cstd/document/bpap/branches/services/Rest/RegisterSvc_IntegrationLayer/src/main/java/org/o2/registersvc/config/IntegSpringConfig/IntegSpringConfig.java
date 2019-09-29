package org.o2.registersvc.config.IntegSpringConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value={"org.o2.registersvc.intg.beans","org.o2.registersvc.intg.impl"})
@PropertySource(value="classpath:db_dev.properties")
public class IntegSpringConfig {

}
