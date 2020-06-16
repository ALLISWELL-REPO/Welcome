

package org.o2.registersvc.resource.springconfig;

import org.o2.register.process.springconfig.ProcessSpringConfig;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.CreditCheckType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.schema.res.StatusBlockType;
import org.o2.registersvc.service.builder.RegisterSvcReqBuilder;
import org.o2.registersvc.service.builder.RegisterSvcResBuilder;
import org.o2.registersvc.validator.RegisterSvcValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = { "org.o2.registersvc.schema.req" ,"org.o2.registersvc.validator"})
@Import(value={ProcessSpringConfig.class})
public class ResourceSpringConfig {

	@Bean
	public AccountDetailsType getAccountDetailsType() {
		return new AccountDetailsType();
	}

	@Bean
	public CardDetailsType getCardDetailsType() {
		return new CardDetailsType();
	}

	@Bean
	public ClientDetailsType getClientDetailsType() {
		return new ClientDetailsType();
	}

	@Bean
	public RegisterServiceReqType getRegisterServiceReqType() {
		return new RegisterServiceReqType();
	}

	@Bean
	public CreditCheckType getCreditCheckType() {
		return new CreditCheckType();
	}

	@Bean
	public StatusBlockType getStatusBlockType() {
		return new StatusBlockType();
	}

	@Bean
	public RegisterServiceResType getRegisterServiceResType() {
		return new RegisterServiceResType();
	}

	@Bean
	public RegisterSvcValidator getRegisterSvcValidator() {
		return new RegisterSvcValidator();
	}

	@Bean
	public RegisterSvcReqBuilder getRegisterSvcReqBuilder(){
		return new RegisterSvcReqBuilder();
	}
	
	@Bean
	public RegisterSvcResBuilder getRegisterSvcResBuilder(){
		return new RegisterSvcResBuilder();
	}
	
}
