package com.st.rest.basic.auth.util;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.st.rest.basic.auth.bean.CurrentUser;
import com.st.rest.basic.auth.dao.UserDao;

@Component
public class AuthenticateUser {
	
	@Autowired
	private UserDao userDao;
	
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public boolean authenticate(String authHeader) {
		if (authHeader == null || authHeader.length() == 0) {
			System.out.println("No Authorization header present in the request");
			return false;
		}
		String[] encodedCredentials = authHeader.split("\\s");
		String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials[1]));
		
		String[] credentials = decodedCredentials.split("\\:");
		String reqUserName = credentials[0];
		String reqPassword = credentials[1];
		
		System.out.println("---- User name in the request " + reqUserName);
		
		CurrentUser currentUser = userDao.getUserDetails(reqUserName);
		if (currentUser != null) {
			return passwordEncoder.matches(reqPassword, currentUser.getPassword());
		} else {
			return false;
		}
		
	}

}
