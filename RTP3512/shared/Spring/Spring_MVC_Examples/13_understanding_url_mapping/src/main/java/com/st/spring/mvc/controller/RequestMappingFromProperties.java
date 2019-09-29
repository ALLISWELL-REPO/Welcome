package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingFromProperties {

	@RequestMapping(value = "${controller.request.mapping}", 
			method = RequestMethod.GET)
	public String getMethod(Model model) {
		model.addAttribute("name", "RequestMappingFromPropertiesController");
		return "helloWorldDynamic";
	}
	
	@RequestMapping(value = "/helloWorld/${partial.controller.request.mapping}", method = RequestMethod.GET)
	public String getMethodOne(Model model) {
		model.addAttribute("name", "Partial RequestMappingFromPropertiesController");
		return "helloWorldDynamic";
	}
	
	@RequestMapping("/helloWorldEnv/${environment}")
	public String envBased() {
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
