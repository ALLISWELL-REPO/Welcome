package com.st.spring.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.st.spring.core.beans.Writer;

public class SpringContext implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("Application context aware injecting");
		this.applicationContext = applicationContext;
		Writer writer = this.applicationContext.getBean(Writer.class);
		writer.write();
	}
	
	public <T> T getBean(Class<T> beanClass) {
		return this.applicationContext.getBean(beanClass);
	}

}
