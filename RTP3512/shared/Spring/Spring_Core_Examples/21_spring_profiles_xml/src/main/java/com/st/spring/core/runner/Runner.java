package com.st.spring.core.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.st.spring.core.beans.Writer;

public class Runner {

	public static void main(String[] args) {
	
		System.setProperty("spring.profiles.active", "dev");
		//System.setProperty("spring.profiles.active", "qa");
		//System.setProperty("spring.profiles.active", "prod");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("root-spring-config.xml");
		//Writer writer = context.getBean(Writer.class);
		Writer writer = (Writer) context.getBean("writer");
		writer.write();
	}

}
