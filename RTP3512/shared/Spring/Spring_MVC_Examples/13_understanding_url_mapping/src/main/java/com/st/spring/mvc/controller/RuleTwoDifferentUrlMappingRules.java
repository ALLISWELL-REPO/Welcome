package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RuleTwoDifferentUrlMappingRules {

	// http://localhost:8080/13_understanding_url_mapping/helloWorld/ruletwo/spring/
	@RequestMapping(value = "/helloWorld/ruletwo/spring/*", method = RequestMethod.GET)
	public String getMethodOne(Model model) {
		model.addAttribute("name", "lengthier one chosen");
		return "helloWorldDynamic";
	}
	
	/** 
	 * http://localhost:8080/13_understanding_url_mapping/helloWorld/ruletwo/spring
	 * 
	 * The main difference is that the URL is not ending with / that means its not specific
	 */
	@RequestMapping(value = "/helloWorld/ruletwo/*", method = RequestMethod.GET)
	public String getMethodTwo(Model model) {
		model.addAttribute("name", "shorter one chosen");
		return "helloWorldDynamic";
	}
}
