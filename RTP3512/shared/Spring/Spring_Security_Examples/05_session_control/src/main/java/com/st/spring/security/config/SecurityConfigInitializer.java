package com.st.spring.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityConfigInitializer extends AbstractSecurityWebApplicationInitializer {

	// for session management
	@Override
	protected boolean enableHttpSessionEventPublisher() {
		return true;
	}
}
