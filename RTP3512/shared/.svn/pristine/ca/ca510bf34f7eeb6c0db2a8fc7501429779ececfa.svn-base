package com.st.spring.boot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.st.spring.boot.model.Account;

@RestController
public class AccountController {
	
	@GetMapping("/account")
	public Account getAccount() {
		return buildAccount();
	}
	
	@PostMapping(value = "/account")
	public String saveAccount(@RequestBody Account account) {
		System.out.println("**** Account is " + account);
		return "Account Saved Successfully";
	}
	
	private Account buildAccount() {
		Account a = new Account();
		a.setId(12345);
		a.setName("Abc");
		a.setBalance(1000.00);
		a.setBranchName("SR Nagar");
		a.setCity("Hyd");
		return a;
	}
	
	
	
	
	
	

}
