package com.st.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);
	
	@GetMapping("/helloWorld/logging")
	public String helloWorldProp() {
		LOG.info("******* Info log is enabled *****");		
		return "Hello World Spring Boot";
	}

	
	
	
	
	
	
	
	
	
	
}
