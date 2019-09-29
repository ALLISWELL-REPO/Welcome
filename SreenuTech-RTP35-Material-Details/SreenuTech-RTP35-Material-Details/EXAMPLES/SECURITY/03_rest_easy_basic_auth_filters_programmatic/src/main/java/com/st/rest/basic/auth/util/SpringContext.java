package com.st.rest.basic.auth.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContext implements ApplicationContextAware {

	@Autowired
	private static ApplicationContext context;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
		System.out.println("COntext is "+context);
	}
	
	public static <T> T getBean(Class<T> beanClass) {
		return context.getBean(beanClass);
	}

}
