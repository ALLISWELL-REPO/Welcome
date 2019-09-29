package com.st.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//return null;
		//return new Class<?>[]{RootConfigOne.class};
		//return new Class<?>[]{RootConfigTwo.class};
		return new Class<?>[]{RootConfigOne.class, RootConfigTwo.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//return new Class<?>[]{MvcConfig.class, RootConfigTwo.class};
		//return new Class<?>[]{MvcConfig.class, RootConfigOne.class};
		return new Class<?>[]{MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	
	
	
	
	
}
