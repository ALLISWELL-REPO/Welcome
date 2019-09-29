package com.st.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.st.spring.boot.service.UserService;

@RestController
public class HelloWorldController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{userId}")
	public String hello(@PathVariable Long userId) {
		return userService.getUserName(userId);
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
