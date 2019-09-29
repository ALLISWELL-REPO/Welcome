package com.st.spring.boot.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldDAO {

	public String helloWorld() {
		return "Hello World Spring Boot";
	}
}
