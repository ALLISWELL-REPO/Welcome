package com.st.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.spring.mvc.service.ExampleService;

@Controller
public class HelloWorldController {
	
	@Autowired
	private ExampleService exampleService;
		
	@RequestMapping(value = "/helloWorldDynamic/{name}", method = RequestMethod.GET)
	public String helloWorld(@PathVariable("name") String name, Model model) {
		String modelReturnedByService = exampleService.serviceMethod();
		model.addAttribute("serviceReturn", modelReturnedByService);
		model.addAttribute("name", name);
		return "helloWorldDynamic";
	}

}
