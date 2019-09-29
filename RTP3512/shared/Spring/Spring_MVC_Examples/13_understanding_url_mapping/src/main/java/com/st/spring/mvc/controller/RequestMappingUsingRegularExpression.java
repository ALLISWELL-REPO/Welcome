package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingUsingRegularExpression {

	@RequestMapping(value = "/helloWorld/regex/{name:[a-z]+}{extension:\\.[a-z]+}", 
			method = RequestMethod.GET)
	public String getMethod(@PathVariable("name") String name, 
							@PathVariable("extension") String extension, 
							Model model) {
		model.addAttribute("name", name + extension);
		return "helloWorldDynamic";
	}
	
	
	
	
	
	
	
	
	
}
