package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloWorldController {
	
	@GetMapping(value = "/helloWorldDynamic/{name}")
	public String helloWorld(@PathVariable("name") String name, Model model) {
		model.addAttribute("name", name);
		return "helloWorldDynamic";
	}
	
	@PostMapping(value = "/helloWorldDynamic/{name}")
	public String helloWorldPost(@PathVariable("name") String name, Model model) {
		model.addAttribute("name", name);
		return "helloWorldDynamic";
	}

}








