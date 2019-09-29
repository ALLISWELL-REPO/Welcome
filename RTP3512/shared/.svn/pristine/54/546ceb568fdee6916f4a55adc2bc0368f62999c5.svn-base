package com.st.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = "/helloWorldDynamic/", 
			method = RequestMethod.GET)
	public ModelAndView helloWorld(Model model) {
		/*model.addAttribute("name", "Sreenu Technologies");
		return "helloWorldDynamic";*/
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("helloWorldDynamic");
		mav.addObject("name", "Sreenu Technologies");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	

}
