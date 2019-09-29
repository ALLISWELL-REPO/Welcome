package org.o2registersvc.creditcheck.springconfig;

import org.o2.registersvc.creditcheck.CreditCheckSvcClient;
import org.o2.registersvc.creditcheck.impl.CreditCheckSvcClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages={"org.o2.registersvc.creditcheck.impl"})
public class CreditCheckSpringConfig {
    
	
}
