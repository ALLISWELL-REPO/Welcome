package com.st.spring.core.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.st.spring.config.SpringConfig;
import com.st.spring.core.beans.Writer;

public class Runner {

	public static void main(String[] args) {
		
		System.setProperty("spring.profiles.active", "dev");
		//System.setProperty("spring.profiles.active", "qa");
		//System.setProperty("spring.profiles.active", "prod");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		//Writer writer = context.getBean(Writer.class);
		Writer writer = (Writer) context.getBean("writer");
		writer.write();
	}

}
