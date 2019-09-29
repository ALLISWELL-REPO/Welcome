package com.st.spring.security.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationTestService {
	
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	@PreAuthorize("hasRole('USER')")
	public String userMethod() {
		return "User Service Method Called";
	}
	
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminMethod() {
		return "Admin Service Method Called";
	}
	
	
	
	
	
	
	
	

}
