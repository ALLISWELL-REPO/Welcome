package com.citybank.statementdtls.service.util;

import com.citybank.statementdtls_schema.req.ClientDetailsType;
import com.citybank.statementdtls_schema.req.CustomerDetailsType;
import com.citybank.statementdtls_schema.req.DateRangeType;
import com.citybank.statementdtls_schema.req.StatementDtlsReqType;
import com.citybank.statementdtls_schema.req.TransCategoryType;

public class StatementDtlsReqUtil {
	public static StatementDtlsReqType buildWsReq(){
		
		StatementDtlsReqType reqType=new StatementDtlsReqType();
		ClientDetailsType clientDetailsType = new ClientDetailsType();
		clientDetailsType.setClientId("web");
		clientDetailsType.setChannelId("online");
		clientDetailsType.setReqId("514324");
		CustomerDetailsType customerDetailsType = new CustomerDetailsType();
		customerDetailsType.setCardnum("45900500000321478");
		customerDetailsType.setCvvnum("514");
		customerDetailsType.setExpdate("2018-04-03");
		customerDetailsType.setNameoncard("sunny");
		TransCategoryType transCategoryType = new TransCategoryType();
		DateRangeType dateRangeType=new DateRangeType();
		dateRangeType.setStartDate(XmlGregorianStringToGrego.getGregorianCalendar("2018-06-03"));
		dateRangeType.setEndDate(XmlGregorianStringToGrego.getGregorianCalendar("2018-07-03"));
		transCategoryType.setDateRange(dateRangeType);
		transCategoryType.setTypeOfCategory("full");
		reqType.setClientDetails(clientDetailsType);
		reqType.setCustomerDetails(customerDetailsType);
		reqType.setTransCategory(transCategoryType);


		return reqType;
	}
}
