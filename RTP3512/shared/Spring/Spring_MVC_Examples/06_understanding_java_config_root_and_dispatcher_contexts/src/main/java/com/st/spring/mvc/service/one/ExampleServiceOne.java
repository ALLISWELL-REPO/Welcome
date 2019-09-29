package com.st.spring.mvc.service.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.spring.mvc.service.two.ExampleServiceTwo;

@Service
public class ExampleServiceOne {
	
	@Autowired
	private ExampleServiceTwo exampleServiceTwo;
	
	//@Autowired
	//private DummyController dummyController;
	
	public String serviceMethodOne() {
		return "Hello World Example Service 1";
	}

}





