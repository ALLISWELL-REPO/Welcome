package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value = "/login.html",method = RequestMethod.GET)
	public String getForm() {

		return "login";
	}

	@RequestMapping(value = "/citybank.html", method = RequestMethod.POST)
	public String authentication(HttpServletRequest request) {
		String CustomerId = request.getParameter("user");
		String Password = request.getParameter("pwd");
		if ("noor".equals(CustomerId) && "alam".equals(Password)) {
			System.out.println("..................");
			return "form";
		}
		return "failure";
	}
}
