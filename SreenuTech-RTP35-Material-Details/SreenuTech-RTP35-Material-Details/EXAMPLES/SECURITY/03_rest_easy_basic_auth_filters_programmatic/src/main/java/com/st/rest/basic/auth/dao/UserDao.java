package com.st.rest.basic.auth.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.rest.basic.auth.bean.CurrentUser;

@Repository
public class UserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final String USER_DETAILS_QUERY = "SELECT u.password from st_user u where u.principal=:USER_NAME";

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public CurrentUser getUserDetails(final String userName) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("USER_NAME", userName);
		
		List<CurrentUser> currentUser = jdbcTemplate.query(USER_DETAILS_QUERY, params, new RowMapper<CurrentUser>() {

			public CurrentUser mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				CurrentUser currentUser = new CurrentUser(userName, rs
						.getString("password"));
				return currentUser;
			}
		});

		CurrentUser user = (currentUser != null && !currentUser.isEmpty()) ? currentUser
				.get(0) : null;

		if (user != null) {
			System.out.println("User Details is " + user.getUserName() + ":" + user.getPassword());
		}

		return user;
	}

}
