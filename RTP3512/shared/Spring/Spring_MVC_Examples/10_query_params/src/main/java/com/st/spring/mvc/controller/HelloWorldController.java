package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	// when using request param better 
	// not to give closing "/" at the end
	@RequestMapping(value = "/helloWorldDynamic", 
			method = RequestMethod.GET)
	public String helloWorld(@RequestParam(required = false, name = "name", defaultValue = "Your Name") String name, 
							 @RequestParam(required = true, value = "area") String areaName,
							 @RequestParam("pincode") int pincode,
							 Model model) {
		model.addAttribute("nameArea", 
				"name:" + name + " area: " + areaName + 
				" pincode: " + pincode);
		return "helloWorldDynamic";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
