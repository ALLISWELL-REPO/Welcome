package com.citybank.cutomerdao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDAOImpl  implements CustomerDAO,RowMapper<CustomerInfo> {
	@Autowired
	private JdbcTemplate jt;
	public CustomerInfo getCustomerDetails(String user) {

		return jt.queryForObject("SELECT * FROM CUSTOMER_INFO WHERE CUST_ID=?", this, new Object[] {user});
	}
   
	public CustomerInfo mapRow(ResultSet res, int index) throws SQLException {
		 
			CustomerInfo cinfo=new CustomerInfo();
			cinfo.setCust_id(res.getString(1));
			cinfo.setCust_name(res.getString(2));
			cinfo.setAddress(res.getString(3));
			cinfo.setCity(res.getString(4));
			cinfo.setState(res.getString(5));
			cinfo.setPin(res.getString(6));
			cinfo.setEnrollment(res.getDate(7));
			cinfo.setAccount_number(res.getString(8));
			cinfo.setBalance(res.getString(9));
			cinfo.setCardnumber(res.getString(10));
			cinfo.setCvv(res.getString(11));
			cinfo.setExpdate(res.getString(12));
			cinfo.setNameoncard(res.getString(13));
			cinfo.setStatus(res.getString(14));
			cinfo.setDob(res.getDate(15));
			cinfo.setMobilenumber(res.getString(16));
			cinfo.setEmailid(res.getString(17));
			return cinfo;
			
			
		}
	

	        
}
