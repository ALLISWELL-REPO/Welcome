package com.pack1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pack1.customer.CustomerDaoImpl;
import com.pack1.customer.CustomerDaoImpl.CustomerDetails;
import com.pack1.customer.Customer_details;
import com.pack1.dao.LoginDao;

@Controller
public class LoginController {
	@Autowired
	LoginDao dao;
	@Autowired
	CustomerDaoImpl custD;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		return new ModelAndView("login");
		}
	
	@RequestMapping(value = "check", method = RequestMethod.POST)
	public ModelAndView checkLogin(@RequestParam("t1")String s1,@RequestParam("t2")String s2,HttpServletRequest request,HttpServletResponse response){
		boolean b=dao.check(s1, s2);
		HttpSession ses=request.getSession(); 
		Customer_details cstDetl;
		if(b){
			cstDetl=custD.getUserDetail();
			ses.setAttribute("custList", cstDetl);
			return new ModelAndView("success");
		}else{
			return new ModelAndView("failure");
			}
		}
	}
