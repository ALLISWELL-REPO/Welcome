package com.citybank.stmtdtlssvc.client.builder;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls_schema.req.ClientDetailsType;
import com.citybank.statementdtls_schema.req.CustomerDetailsType;
import com.citybank.statementdtls_schema.req.DateRangeType;
import com.citybank.statementdtls_schema.req.StatementDtlsReqType;
import com.citybank.statementdtls_schema.req.TransCategoryType;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.util.StatementDtlsConstant;

@Component
public class StatementDtlsSvcClientReqBuilder {

	public StatementDtlsReqType buildWsRequest(StatementDtlsWebReq webReq) {
		StatementDtlsReqType wsReqType=new StatementDtlsReqType();
		ClientDetailsType clientDetailsType=new ClientDetailsType();
		clientDetailsType.setClientId(StatementDtlsConstant.CLIENT_ID);
		clientDetailsType.setChannelId(StatementDtlsConstant.CHANNEL_ID);
		clientDetailsType.setReqId(UUID.randomUUID().toString());
		
		CustomerDetailsType customerDetailsType=new CustomerDetailsType();
		customerDetailsType.setCardnum(webReq.getCardNum());
		customerDetailsType.setCvvnum(String.valueOf(webReq.getCvvNum()));
		customerDetailsType.setExpdate(webReq.getExpDate());
		customerDetailsType.setNameoncard(webReq.getNameOnCard());
		
		TransCategoryType transCategoryType=new TransCategoryType();
		//DateRangeType dateRangeType=new DateRangeType();
		//dateRangeType.setStartDate(webReq.getStartDate());
		//dateRangeType.setEndDate(webReq.getEndDate());
		//transCategoryType.setDateRange(dateRangeType);
		transCategoryType.setTypeOfCategory(webReq.getTypeOfCate());
		
		wsReqType.setClientDetails(clientDetailsType);
		wsReqType.setCustomerDetails(customerDetailsType);
		wsReqType.setTransCategory(transCategoryType);
		
		return wsReqType;
	}

	
	

}
