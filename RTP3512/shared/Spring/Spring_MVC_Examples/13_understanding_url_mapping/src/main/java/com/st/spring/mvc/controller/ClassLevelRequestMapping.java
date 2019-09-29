package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * hit this controller with /helloWorld/ the last closing slash is required for the ../ to work in view
 */
@Controller
@RequestMapping(value = "/helloWorld")
public class ClassLevelRequestMapping {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMethod(Model model) {
		model.addAttribute("name", "Get Method");
		return "helloWorldDynamic";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postMethod(Model model) {
		model.addAttribute("name", "POST Method");
		return "helloWorldDynamic";
	}
	
	
	
	
	
	
	

}
