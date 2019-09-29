package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = "/helloWorldDynamic/{name}/{area}", method = RequestMethod.GET)
	public String helloWorld(@PathVariable("name") String name, 
							 @PathVariable("area") String areaName,
							 Model model) {
		model.addAttribute("name", name + " " + areaName);
		return "helloWorldDynamic";
	}

	
	
	
	
	
	
}
