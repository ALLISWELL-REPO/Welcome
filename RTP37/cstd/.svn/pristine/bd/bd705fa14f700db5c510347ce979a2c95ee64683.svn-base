package com.pack1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pack1.customer.CustomerDaoImpl;
import com.pack1.customer.Customer_details;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private JdbcTemplate jt;
	@Autowired
	CustomerDaoImpl daoimpl;

	public boolean check(String s1, String s2) {
		int i = (Integer) jt.queryForObject("select count(*) from login where username=?  and password=?",
				Integer.class, s1, s2);
		Customer_details cust=null;
		if(i==1){
			 cust=daoimpl.getUserDetail();
			 
			return true;
		}
		else

		return false;
	}

}
