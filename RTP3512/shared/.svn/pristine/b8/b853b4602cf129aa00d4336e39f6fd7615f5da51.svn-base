package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * All the method level urls will be relative to the class level
 */
@Controller
@RequestMapping(value = "/helloWorld")
public class ClassAndMethodLevelRequestMapping {

	@RequestMapping(value = "/getMethod", 
			method = RequestMethod.GET)
	public String getMethod(Model model) {
		model.addAttribute("name", "ClassAndMethodLevelRequestMappingController");
		return "helloWorldDynamic";
	}
	
	
	
	
	
	
	
}
