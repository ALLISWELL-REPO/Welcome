package com.st.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.spring.boot.service.HelloWorldService;

@RestController
public class HelloWorldController {
	
	@Autowired
	private HelloWorldService helloWorldService;
	
	@GetMapping("/helloWorld")
	public String helloWorldProp() {
		return helloWorldService.helloWorld();
	}

	
	
	
	
	
	
	
	
	
	
}
