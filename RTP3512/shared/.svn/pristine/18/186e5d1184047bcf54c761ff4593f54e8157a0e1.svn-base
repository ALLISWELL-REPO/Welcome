package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RuleThreeDifferentUrlMappingRules {

	@RequestMapping(value = "/helloWorld/rulethree/{name}", method = RequestMethod.GET)
	public String getMethodOne(Model model) {
		model.addAttribute("name", "lesser wild card count chosen");
		return "helloWorldDynamic";
	}
	
	@RequestMapping(value = "/helloWorld/rulethree/*", method = RequestMethod.GET)
	public String getMethodTwo(Model model) {
		model.addAttribute("name", "higher wild card count chosen");
		return "helloWorldDynamic";
	}
}
