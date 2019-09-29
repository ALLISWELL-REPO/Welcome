package com.citybank.stmtdtls.controller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.DataRangeType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;

public class JAXBMarshelling {
	public static void main(String[] args) throws JAXBException {
		JAXBContext context=JAXBContext.newInstance(StatementDtlsReqType.class);
		Marshaller marshalObj=context.createMarshaller();
		
		StatementDtlsReqType wsReq=new StatementDtlsReqType();
		ClientDetailsType clientType=new ClientDetailsType();
		clientType.setClientid("1245");
		clientType.setChannelid("web");
		clientType.setReqid("7800");
		
		CustomerDetailsType custType=new CustomerDetailsType();
		custType.setCvvnum("123");
		custType.setCardnum("174785785757");
		custType.setNameoncard("Adil");
		custType.setExpdate("16-09-2018");
		
		TransCategoryType tranType=new TransCategoryType();
		
		DataRangeType dateRange=new DataRangeType();
		//dateRange.setStartdate("09-06-2019");
		//dateRange.setEnddate("09-06-2019");
		tranType.setDataRange(dateRange);
		tranType.setTypeofcategory("All");
		wsReq.setClientDetails(clientType);
		wsReq.setCustomerDetails(custType);
		wsReq.setTransCategory(tranType);
		
		marshalObj.marshal(wsReq, System.out);
		
		}

}
