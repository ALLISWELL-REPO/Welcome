package com.citybank.stmtdtls.web.dao;

import com.citybank.stmtdtls.web.beans.CustomerDetails;

public interface CustomerDao {
	CustomerDetails getCustomerDetails(String custId);
}
