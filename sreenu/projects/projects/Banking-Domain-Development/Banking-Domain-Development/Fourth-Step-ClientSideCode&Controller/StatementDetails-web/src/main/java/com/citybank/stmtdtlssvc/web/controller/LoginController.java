package com.citybank.stmtdtlssvc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login.mvc")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String getSampleForm() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String auth(HttpServletRequest request) {

		String CustId = request.getParameter("CustId");
		String password = request.getParameter("password");

		if ("rohit".equals(CustId) || "kandale".equals(password)) {
			return "home";
		}
		return "error";

	}
}
