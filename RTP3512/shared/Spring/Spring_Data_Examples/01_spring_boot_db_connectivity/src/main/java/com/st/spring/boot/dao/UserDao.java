package com.st.spring.boot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public String getUserName(Long userId) {
		final String query = "SELECT principal FROM st_user WHERE id=:ID";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ID", userId);
		return this.jdbcTemplate.queryForObject(query, params, String.class);
	}

	
	
	
	
	
	
	
	
	
}
