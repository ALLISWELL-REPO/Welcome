package com.st.spring.boot.application;

import org.springframework.boot.builder.SpringApplicationBuilder;

import com.st.spring.boot.config.ChildContextConfig;
import com.st.spring.boot.config.ParentContextConfig;

public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
		.sources(ParentContextConfig.class)
		.child(ChildContextConfig.class)
		.run(args);
	}
	
	
	
	
	
	
	
	
	
	
	
}
