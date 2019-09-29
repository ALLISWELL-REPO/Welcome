package com.citybank.stmtdtlssvc.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDaoImpl implements LoginDao {
	private final String check_user_password = "select count(*) from login_details where cust_id=? and password=?;";
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int authentication(String username, String password) {
		return jdbcTemplate.queryForObject(check_user_password, Integer.class, new Object[] { username, password });
	}

}
