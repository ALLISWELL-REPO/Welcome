package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingUsingHeader {

	@RequestMapping(value = "/helloWorld/headers/", 
			headers = "Accept=application/xml", 
					method = RequestMethod.GET)
	public String getXMLMethod(Model model) {
		model.addAttribute("name", "RequestMappingUsingHeaderController");
		return "helloWorldDynamic";
	}
	
	@RequestMapping(value = "/helloWorld/headers/", 
			headers = "Accept=application/json", 
					method = RequestMethod.GET)
	public String getJSONMethod(Model model) {
		model.addAttribute("name", "RequestMappingUsingHeaderController");
		return "helloWorldDynamic";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
