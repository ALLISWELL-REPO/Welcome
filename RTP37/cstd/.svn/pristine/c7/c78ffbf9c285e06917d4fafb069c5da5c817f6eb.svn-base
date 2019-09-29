package org.o2.registersvc.service.springconfig;

import org.o2.registersvc.service.builder.RegisterSvcReqBuilder;
import org.o2.registersvc.service.builder.RegisterSvcResBuilder;
import org.o2.registersvc.service.validator.RegisterSvcValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={org.o2.registersvc.process.springconfig.SpringConfig.class})

public class SpringConfig {

	@Bean
	public RegisterSvcValidator getValidator(){
		RegisterSvcValidator validator=new RegisterSvcValidator();
		return validator;
	}
	
	@Bean
	public RegisterSvcReqBuilder getRegSvcReqBilder(){
		return new RegisterSvcReqBuilder();
		
	}
	
	@Bean
	public RegisterSvcResBuilder getRegSvcResBuilder(){
		return new RegisterSvcResBuilder();
		//return regSvcResBuilder;
	}
	
}
