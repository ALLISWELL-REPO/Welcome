package com.citybank.statementdtls.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.citybank.statementdtls.resource.util.XmlGregorianStringToGrego;
import com.citybank.statementdtls_schema.req.ClientDetailsType;
import com.citybank.statementdtls_schema.req.CustomerDetailsType;
import com.citybank.statementdtls_schema.req.DateRangeType;
import com.citybank.statementdtls_schema.req.StatementDtlsReqType;
import com.citybank.statementdtls_schema.req.TransCategoryType;
import com.google.gson.Gson;

public class ObjectToXml {
	public static void main(String[] args) throws JAXBException {
		StatementDtlsReqType reqType = new StatementDtlsReqType();

		ClientDetailsType clientDetailsType = new ClientDetailsType();
		clientDetailsType.setClientId("web");
		clientDetailsType.setChannelId("online");
		clientDetailsType.setReqId("514324");

		CustomerDetailsType customerDetailsType = new CustomerDetailsType();
		customerDetailsType.setCardnum("4590050000032147");
		customerDetailsType.setCvvnum("514");
		customerDetailsType.setExpdate("2018-04-03");
		customerDetailsType.setNameoncard("sunny");

		TransCategoryType transCategoryType = new TransCategoryType();
		DateRangeType dateRangeType = new DateRangeType();
		dateRangeType.setStartDate(XmlGregorianStringToGrego.getGregorianCalendar("2018-06-12"));
		dateRangeType.setEndDate(XmlGregorianStringToGrego.getGregorianCalendar("2018-07-12"));
		transCategoryType.setDateRange(dateRangeType);
		transCategoryType.setTypeOfCategory("full");
		
		reqType.setClientDetails(clientDetailsType);
		reqType.setCustomerDetails(customerDetailsType);
		reqType.setTransCategory(transCategoryType);

		JAXBContext context = JAXBContext.newInstance(StatementDtlsReqType.class);
		Marshaller marshall = context.createMarshaller();
		//marshall.marshal(reqType, System.out);
		
		Gson gson=new Gson();
		String obj = gson.toJson(reqType);
		System.out.println(obj);
		
		
	}

}
