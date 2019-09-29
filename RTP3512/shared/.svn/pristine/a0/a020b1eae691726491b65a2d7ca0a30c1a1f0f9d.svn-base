package com.st.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.spring.boot.dao.HelloWorldDAO;

@Service
public class HelloWorldService {
	
	@Autowired
	private HelloWorldDAO helloWorldDAO;

	public String helloWorld() {
		return helloWorldDAO.helloWorld();
	}
}
