package com.st.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	// return root application context configuration
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	// return dispatcher servlet configuration
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{MvcConfig.class};
	}

	@Override
	// map url pattern to dispatcher servlet
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
