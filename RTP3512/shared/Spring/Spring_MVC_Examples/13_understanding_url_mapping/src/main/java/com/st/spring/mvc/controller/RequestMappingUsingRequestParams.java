package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingUsingRequestParams {

	
	@RequestMapping(value = "/helloWorld/params", 
			params = "name=st", 
					method = RequestMethod.GET)
	public String getMethod(Model model) {
		model.addAttribute("name", "RequestMappingUsingRequestParams");
		return "helloWorldDynamic";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
