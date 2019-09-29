package com.st.spring.boot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.st.spring.boot.dao.UserDao;
import com.st.spring.boot.model.LoginUser;

@Component
public class LoginUserDetailsService 
		implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		LoginUser user = userDao.getUserDetails(userName);
		return user;
	}
	
	
	
	
	
	
	
	
	
}
