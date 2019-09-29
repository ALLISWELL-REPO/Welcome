package com.st.spring.boot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.st.spring.boot.model.LoginUser;

@Repository
public class UserDao extends AbstractBaseRepository {
	
	private static final String USER_DETAILS_QUERY = "SELECT u.password from st_user u where u.principal=:USER_NAME";
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public LoginUser getUserDetails(final String userName) {
		
		MapSqlParameterSource params = new MapSqlParameterSource(Collections.singletonMap("USER_NAME", userName));
		
		List<LoginUser> currentUser = jdbcTemplate.query(USER_DETAILS_QUERY, params, new RowMapper<LoginUser>() {
			@Override
			public LoginUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				LoginUser currentUser = new LoginUser(userName, rs.getString("password"));
				return currentUser;
			}
		});
		
		LoginUser user = (currentUser != null && !currentUser.isEmpty()) ? currentUser.get(0) : null;
		
		return user;
	}
	
}
