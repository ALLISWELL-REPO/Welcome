package com.st.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.spring.mvc.service.one.ExampleServiceOne;
import com.st.spring.mvc.service.two.ExampleServiceTwo;

@Controller
public class HelloWorldController {
	
	@Autowired
	private ExampleServiceOne exampleServiceOne;
	
	@Autowired
	private ExampleServiceTwo exampleServiceTwo;
		
	@RequestMapping(value = "/helloWorldDynamic/{name}", method = RequestMethod.GET)
	public String helloWorld(@PathVariable("name") String name, Model model) {
		String modelReturnedByServiceOne = exampleServiceOne.serviceMethodOne();
		String modelReturnedByServiceTwo = exampleServiceTwo.serviceMethodTwo();
		model.addAttribute("serviceOneReturn", modelReturnedByServiceOne);
		model.addAttribute("serviceTwoReturn", modelReturnedByServiceTwo);
		model.addAttribute("name", name);
		return "helloWorldDynamic";
	}

}
