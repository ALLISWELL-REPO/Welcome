package com.st.spring.core.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.st.spring.core.beans.Writer;

public class PNamespaceRunner {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("p-namespace.xml");
		//Writer writer = context.getBean(Writer.class);
		Writer writer = (Writer) context.getBean("writer");
		writer.write();
	}

}
