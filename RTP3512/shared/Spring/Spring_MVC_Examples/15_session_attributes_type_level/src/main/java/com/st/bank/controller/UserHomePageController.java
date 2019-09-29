package com.st.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.st.bank.model.UserHomePageModel;

@Controller
@SessionAttributes("userHomePageModel")
public class UserHomePageController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserHomePageController.class);

	@RequestMapping(value = {"/netbanking", "/login"}, method = RequestMethod.GET)
	public String getLoginPage() {
		LOG.debug("Login page requested");
		return "loginPage";
	}
	
	@RequestMapping(value = "/homePage", 
			method = RequestMethod.GET)
	public UserHomePageModel getHomePage(ModelAndView view) {
		LOG.debug("Home page requested");
		view.setViewName("homePage");
		
		UserHomePageModel userHomePageModel = 
				new UserHomePageModel("stuser-session", "stuser-session@gmail.com");
		return userHomePageModel;
	}
	
	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String getLoginFailedPage(Model model) {
		model.addAttribute("loginFailed", "true");
		return "loginPage";
	}
	
	@RequestMapping(value = "/logoutSuccess", method = RequestMethod.GET)
	public String getLogoutSuccessPage(Model model) {
		model.addAttribute("logoutSuccess", "true");
		return "loginPage";
	}
	
	/**
	 * @ModelAttribute can be used to get model data from session which was already added by @SessionAttributes
	 */
	@RequestMapping(value = "/same/getFromSession", method = RequestMethod.GET)
	public String getFromSession(@ModelAttribute("userHomePageModel") UserHomePageModel userHomePageModel, Model model) {
		LOG.debug("********* User home page details user: {} email: {}", userHomePageModel.getUserName(), userHomePageModel.getEmail());
		model.addAttribute("userName", userHomePageModel.getUserName());
		model.addAttribute("email", userHomePageModel.getEmail());
		return "homePage";
	}
	
	
	
	
	
	
	
	
	
}
