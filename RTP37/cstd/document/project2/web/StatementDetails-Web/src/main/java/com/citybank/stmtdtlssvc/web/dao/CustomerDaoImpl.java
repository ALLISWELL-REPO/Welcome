package com.citybank.stmtdtlssvc.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.citybank.stmtdtlssvc.web.beans.CustomerDetails;

public class CustomerDaoImpl implements CustomerDao, RowMapper<CustomerDetails> {
	private final String get_cust_dtls_query = "select * from customer_info where cust_id=?;";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public CustomerDetails getCustomerDetails(String custId) {
		return jdbcTemplate.queryForObject(get_cust_dtls_query, this, new Object[] { custId });
	}

	@Override
	public CustomerDetails mapRow(ResultSet rs, int arg1) throws SQLException {
		CustomerDetails details = new CustomerDetails();
		details.setCustId(rs.getString(1));
		details.setCustName(rs.getString(2));
		details.setAddress(rs.getString(3));
		details.setCity(rs.getString(4));
		details.setState(rs.getString(5));
		details.setPincode(rs.getString(6));
		details.setEnrollmentDate(rs.getString(7));
		details.setAccountNumber(rs.getString(8));
		details.setBalance(rs.getString(9));
		details.setCardNumber(rs.getString(10));
		details.setCvv(rs.getString(11));
		details.setExpDate(rs.getString(12));
		details.setNameOnCard(rs.getString(13));
		details.setStatus(rs.getString(14));
		details.setDob(rs.getString(15));
		details.setMobile(rs.getString(16));
		details.setEmailId(rs.getString(17));
		return details;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
