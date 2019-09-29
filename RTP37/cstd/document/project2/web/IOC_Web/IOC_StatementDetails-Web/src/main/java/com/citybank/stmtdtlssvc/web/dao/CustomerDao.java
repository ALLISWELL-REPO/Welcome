package com.citybank.stmtdtlssvc.web.dao;

import com.citybank.stmtdtlssvc.web.beans.CustomerDetails;

public interface CustomerDao {
	CustomerDetails getCustomerDetails(String custId);
}
