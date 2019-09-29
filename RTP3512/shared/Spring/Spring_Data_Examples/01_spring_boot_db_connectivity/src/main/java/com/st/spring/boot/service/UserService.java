package com.st.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.spring.boot.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	public String getUserName(Long userId) {
		return dao.getUserName(userId);
	}

}
