package com.citybank.logindao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private JdbcTemplate jt;

	public boolean userAuthentication(String user, String pwd) {
		int COUNT = (Integer)jt.queryForObject("SELECT COUNT(*) FROM login_details WHERE CUSTID=? && PASSWORD=?", Integer.class, user,pwd);

		if (COUNT == 1)
			return true;
		else
			return false;
	}

}
