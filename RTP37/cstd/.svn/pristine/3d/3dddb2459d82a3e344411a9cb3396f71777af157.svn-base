package com.pack1.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class CustomerDaoImpl implements CustomerDao{
	private static final String GET_CUSTOMER_DETAILS = "SELECT COUNT(*) FROM CUSTOMER_DETAILS WHERE ID=?,this";
	private JdbcTemplate jt;

	public Customer_details getUserDetail() {
		List<Customer_details> custlist;
		custlist = jt.query(GET_CUSTOMER_DETAILS, new CustomerDetails());
		return null;

		

	}

	public class CustomerDetails implements ResultSetExtractor<List<Customer_details>> {

		public List<Customer_details> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Customer_details> list = new ArrayList<Customer_details>();
			while (rs.next()) {
				Customer_details custmer = new Customer_details();
				custmer.setId(rs.getString(1));
				custmer.setCardnum(rs.getString(2));
				custmer.setCvv(rs.getString(3));
				custmer.setNameoncard(rs.getString(4));
				list.add(custmer);

			}

			return list;
		}

	}

}
