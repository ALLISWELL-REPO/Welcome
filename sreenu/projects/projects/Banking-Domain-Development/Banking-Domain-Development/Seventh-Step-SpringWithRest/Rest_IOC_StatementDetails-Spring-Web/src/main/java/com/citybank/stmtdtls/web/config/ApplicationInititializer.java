package com.citybank.stmtdtls.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInititializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class<?>[]{MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[]{"*.mvc"};
	}

}
