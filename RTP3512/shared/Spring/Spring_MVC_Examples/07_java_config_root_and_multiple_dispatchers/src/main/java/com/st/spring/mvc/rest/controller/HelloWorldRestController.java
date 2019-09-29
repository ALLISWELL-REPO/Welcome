package com.st.spring.mvc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.spring.mvc.service.one.ExampleServiceOne;
import com.st.spring.mvc.service.two.ExampleServiceTwo;

@RestController
public class HelloWorldRestController {
	
	@Autowired
	private ExampleServiceOne exampleServiceOne;
	
	@Autowired
	private ExampleServiceTwo exampleServiceTwo;

	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	public String helloWorld() {
		return "Hello world from rest controller";
	}
	
	
	
	
	
	
	
}
