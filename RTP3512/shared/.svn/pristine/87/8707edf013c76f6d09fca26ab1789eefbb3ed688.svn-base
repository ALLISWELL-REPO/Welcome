package com.st.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
	
	@GetMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("name", "Spring Boot");
		return "helloWorldDynamic";
	}

}
