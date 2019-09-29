package org.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.register.beans.O2LoginResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import o2.register.formdata.O2LoginFormData;
import o2.register.service.O2LoginService;

@Controller
public class O2LoginController {
	
	@Autowired
	private O2LoginService loginService;
	
	
	@RequestMapping(value="/o2login" , method=RequestMethod.GET)
	public String o2Loginshow()  {
     return "O2Login";
	}
	
	@RequestMapping(value="/o2login" , method=RequestMethod.POST)
	public String o2Login(@Valid @ModelAttribute O2LoginFormData loginFormData 
			, BindingResult validresult ,Model model,HttpServletRequest req)  {
		
	/*	HttpSession session=req.getSession();
		session.setAttribute("accId", loginFormData.getAccNo());
		*/
    O2LoginResp loginResp = loginService.process(loginFormData);
    
    if (validresult.hasErrors()) {
		System.out.println("**** Validation errors in the form data ****" + validresult.getFieldErrors());
		model.addAttribute("status", "false");
		return "Home";
	}
    
     if(("0000").equals(loginResp.getRespCode())){
    	 HttpSession session=req.getSession();
 		session.setAttribute("accId", loginFormData.getAccNo());
    	 return "Home";
     }
     else{
    	 return "error";
     }
		
	}
}
