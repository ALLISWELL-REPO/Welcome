package com.citybank.card.stmtsvc.client.builder;

import java.util.UUID;

import com.citybank.card.stmtsvc.client.beans.StatementWebReq;
import com.citybank.card.stmtsvc.client.beans.StatementWebResp;
import com.citybank.card.stmtsvc.client.util.StatementDtlConstant;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;

public class StmtDtlsSvcClientReqBuilder {
	
	public StatementDtlsReqType buildWsRequest(StatementWebReq webReq) {
		StatementDtlsReqType wsReqType=new StatementDtlsReqType();
		ClientDetailsType clientDetailsType=new ClientDetailsType();
		clientDetailsType.setClientid(StatementDtlConstant.CLIENT_ID);
		clientDetailsType.setChannelid(StatementDtlConstant.CHANNEL_ID);
		clientDetailsType.setReqid(UUID.randomUUID().toString());
		
		CustomerDetailsType customerDetailsType=new CustomerDetailsType();
		customerDetailsType.setCardnum(webReq.getCardNumber());
		customerDetailsType.setCvvnum(String.valueOf(webReq.getCvvNumber()));
		customerDetailsType.setExpdate(webReq.getExpDate());
		customerDetailsType.setNameoncard(webReq.getNameOnCard());
		
		TransCategoryType transCategoryType=new TransCategoryType();
		//DateRangeType dateRangeType=new DateRangeType();
		//dateRangeType.setStartDate(webReq.getStartDate());
		//dateRangeType.setEndDate(webReq.getEndDate());
		//transCategoryType.setDateRange(dateRangeType);
		transCategoryType.setTypeofcategory(webReq.getTypeOfCat());
		
		wsReqType.setClientDetails(clientDetailsType);
		wsReqType.setCustomerDetails(customerDetailsType);
		wsReqType.setTransCategory(transCategoryType);
		
		return wsReqType;
	}


	

	
	

}