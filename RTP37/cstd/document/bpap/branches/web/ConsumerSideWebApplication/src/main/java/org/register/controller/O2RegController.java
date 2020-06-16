package org.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.register.beans.O2LoginResp;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import o2.register.formdata.O2RegistrationFormData;

@Controller
public class O2RegController {
	
	
	@RequestMapping(value="/register" ,method=RequestMethod.GET)
		public String o2LoginShow()  {
		   
		     return "register";
				

	}
	
	@RequestMapping(value="/register" , method=RequestMethod.POST)
	public String o2LoginProcess(@ModelAttribute O2RegistrationFormData regFormData ,Model model,
			HttpServletRequest req)  {
      
		HttpSession session=req.getSession();
		session.setAttribute("regFormData", regFormData);
		
		
		model.addAttribute("regFormData",regFormData);
		
     System.out.println(" Register for post "+regFormData);
     return "registerverify";
		
	}
	
}