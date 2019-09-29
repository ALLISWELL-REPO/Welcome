package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodLevelRequestMapping {

	@RequestMapping(value = "/helloWorldMethodLevel", 
			method = RequestMethod.GET)
	public String getMethod(Model model) {
		model.addAttribute("name", "Get Method");
		return "helloWorldDynamic";
	}
	
	@RequestMapping(value = "/helloWorldMethodLevel", 
			method = RequestMethod.POST)
	public String postMethod(Model model) {
		model.addAttribute("name", "POST Method");
		return "helloWorldDynamic";
	}
	
	
	
	
	
	
	
}
