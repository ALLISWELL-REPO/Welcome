package com.st.spring.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
	
	@Value("${custom.prop}")
	private String var;
	
	@GetMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("name", "Spring Boot");
		return "helloWorldDynamic";
	}
	
	@GetMapping("/helloWorld/prop")
	public String helloWorldProp(Model model) {
		model.addAttribute("name", var);
		return "helloWorldDynamic";
	}
	
	
	
	
	
	
	
	
	
	
	

}
