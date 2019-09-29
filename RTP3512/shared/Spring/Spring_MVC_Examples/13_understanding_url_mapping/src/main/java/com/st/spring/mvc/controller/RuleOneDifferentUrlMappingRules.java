package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RuleOneDifferentUrlMappingRules {

	// http://localhost:8080/13_understanding_url_mapping/helloWorld/ruleone/st/
	@RequestMapping(value = "/helloWorld/ruleone/{name}/*", method = RequestMethod.GET)
	public String getMethodOne(Model model) {
		model.addAttribute("name", "{name} and * chosen");
		return "helloWorldDynamic";
	}
	
	/**
	 * http://localhost:8080/13_understanding_url_mapping/helloWorld/ruleone/st/srn/hyd
	 * http://localhost:8080/13_understanding_url_mapping/helloWorld/ruleone/st
	 * 
	 * When there is no / at the end of the URL then it is not going to match to specific pattern
	 */
	@RequestMapping(value = "/helloWorld/ruleone/{name}/**", method = RequestMethod.GET)
	public String getMethodTwo(Model model) {
		model.addAttribute("name", "{name} and ** chosen");
		return "helloWorldDynamic";
	}
}
