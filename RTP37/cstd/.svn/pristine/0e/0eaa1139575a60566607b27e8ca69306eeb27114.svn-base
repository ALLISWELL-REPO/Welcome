package com.citybank.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citybank.custdao.CustomerDAO;
import com.citybank.custdao.CustomerInfo;
import com.citybank.logindao.LoginDAO;

@Controller
public class LoginController {
	@Autowired
	LoginDAO dao;
	@Autowired
	CustomerDAO custdao;
	@RequestMapping(value="/login.html",method=RequestMethod.GET)
	public String LoginForm(){
		return "login";
		
	}
	@RequestMapping(value="/citybank.html",method=RequestMethod.POST)
	public String HandleReqest(HttpServletRequest req,HttpServletResponse resp){
		//String user=null;
		//String pwd=null;
		String	user= req.getParameter("username");
		String	pwd= req.getParameter("pwd");
		System.out.println("user "+user);
		boolean count=dao.userAuthentication(user, pwd);
		CustomerInfo  info;
		HttpSession session=req.getSession();
		
		if(count){
			info=custdao.getCustomerDetails(user);
			session.setAttribute("custDetails",info);
		System.out.println(	session.getAttribute("custDetails"));
			
			return "home";
		}
		else
		{
			return "error";
		}
		
	}

	

}
