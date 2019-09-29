package com.st.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.st.bank.model.UserHomePageModel;

@Controller
public class SessionAttributesTestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SessionAttributesTestController.class);
	
	@RequestMapping(value = "/diff/getFromSession", method = RequestMethod.GET)
	public String getFromSession(@SessionAttribute("userHomePageModel") UserHomePageModel userHomePageModel, Model model) {	
		LOG.debug("********* User home page details user: {} email: {}", userHomePageModel.getUserName(), userHomePageModel.getEmail());
		model.addAttribute("userName", userHomePageModel.getUserName());
		model.addAttribute("email", userHomePageModel.getEmail());
		return "homePage";
	}
	
	
	
	

}
