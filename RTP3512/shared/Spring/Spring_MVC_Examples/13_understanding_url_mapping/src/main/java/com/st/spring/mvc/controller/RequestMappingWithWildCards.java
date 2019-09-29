package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingWithWildCards {

	@RequestMapping(value = "/helloWorld/wildcard/*", 
			method = RequestMethod.GET)
	public String getMethod(Model model) {
		model.addAttribute("name", "* usage");
		return "helloWorldDynamic";
	}
	
	@RequestMapping(value = "/helloWorld/wildcard/?bc", method = RequestMethod.GET)
	public String getMethodOne(Model model) {
		model.addAttribute("name", "? usage");
		return "helloWorldDynamic";
	}
	
	@RequestMapping(value = "/helloWorld/wildcard/**", method = RequestMethod.GET)
	public String getMethodOneTwo(Model model) {
		model.addAttribute("name", "** usage");
		return "helloWorldDynamic";
	}
	
	
	
	
	
}
