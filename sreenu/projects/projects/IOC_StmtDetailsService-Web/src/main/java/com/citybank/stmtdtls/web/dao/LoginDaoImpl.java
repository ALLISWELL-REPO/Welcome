package com.citybank.stmtdtls.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDaoImpl implements LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private final String check_user_password = "select count(*) from login_details where cust_id=? and password=?";

	public int authentication(String username, String password) {
		
		System.out.println(username);
		return jdbcTemplate.queryForObject(check_user_password, Integer.class, new Object[] { username.trim(), password.trim() });
	}

}
