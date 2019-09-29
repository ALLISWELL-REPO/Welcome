package com.citybank.stmtdtls.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citybank.stmtdtls.web.beans.CustomerDetails;
import com.citybank.stmtdtls.web.dao.CustomerDao;
import com.citybank.stmtdtls.web.dao.LoginDao;

@Controller
@RequestMapping("login.mvc")
public class LoginController {

	@Autowired
	private LoginDao loginDao = null;
	@Autowired
	private CustomerDao customerDao = null;
	private CustomerDetails custDetails = null;

	@RequestMapping(method = RequestMethod.GET)
	public String getSampleForm() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String authentication(HttpServletRequest request, Model custModel) {

		HttpSession session = request.getSession();

		String customerId = request.getParameter("CustomerId");
		String password = request.getParameter("password");

		int result = loginDao.authentication(customerId, password);
		System.out.println(result);

		if (result == 1) {

			custDetails = customerDao.getCustomerDetails(customerId);
			System.out.println(custDetails);
			// from model we can access valus wrt $
			//
			custModel.addAttribute("custDetails", custDetails);
			session.setAttribute("custDetailssession", custDetails);
			return "custhome";
		}
		return "error";
	}

}
