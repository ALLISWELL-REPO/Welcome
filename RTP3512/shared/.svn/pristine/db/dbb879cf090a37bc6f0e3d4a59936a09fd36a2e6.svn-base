package com.st.spring.boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.spring.boot.util.Constants;

@Controller
public class UserHomePageController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "loginPage";
	}
	
	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String getHomePage(HttpServletRequest request, Model model) {
		
		HttpSession httpSession = request.getSession(false);
		String userName = (String) httpSession.getAttribute(Constants.USER_NAME);
		
		model.addAttribute("userName", userName);
		
		return "homePage";
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
	
	
	
	
	
	
	
	
	
	
}
