package com.citybank.spring.rest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInititializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class<?>[]{RestJavaConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[]{"*.mvc"};
	}

}
