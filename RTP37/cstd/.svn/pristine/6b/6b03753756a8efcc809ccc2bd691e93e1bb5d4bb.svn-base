package org.o2.register.svc.client.springclientconfig;

import org.o2.register.svc.client.bean.RegisterSvcWebReq;
import org.o2.register.svc.client.bean.RegisterSvcWebRes;
import org.o2.register.svc.client.impl.RegisterSvcClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value={"org.o2.register.svc.client.impl","org.o2.register.svc.client.bean"})
@Import(value={})
public class SpringClientConfig {
 
	@Bean
	public RegisterSvcWebReq getRegSvcWebReq(){
		return new RegisterSvcWebReq();
	}
	
	@Bean
	public RegisterSvcWebRes getRegisterSvcWebRes(){
		return new RegisterSvcWebRes();
	}
	
	@Bean
	public RegisterSvcClientImpl getRegisterSvcClientImpl(){
		return new RegisterSvcClientImpl();
	}
	
	
}
