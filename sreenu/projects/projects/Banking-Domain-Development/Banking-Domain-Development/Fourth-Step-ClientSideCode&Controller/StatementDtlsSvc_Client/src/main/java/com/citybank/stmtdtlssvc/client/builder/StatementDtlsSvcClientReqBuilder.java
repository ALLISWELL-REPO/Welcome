package com.citybank.stmtdtlssvc.client.builder;

import java.util.UUID;

import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.util.StatementDtlsConstant;

public class StatementDtlsSvcClientReqBuilder {

	public StatementDtlsReqType buildWsRequest(StatementDtlsWebReq webReq) {

		StatementDtlsReqType wsReqType = new StatementDtlsReqType();
		ClientDetailsType clientDetailsType = new ClientDetailsType();

		clientDetailsType.setClientid(StatementDtlsConstant.CLIENT_ID);
		clientDetailsType.setChannelid(StatementDtlsConstant.CHANNEL_ID);
		clientDetailsType.setReqid(UUID.randomUUID().toString());

		CustomerDetailsType customerDetailsType = new CustomerDetailsType();
		customerDetailsType.setCardnum(webReq.getCardnum());
		customerDetailsType.setCvvnum(webReq.getCvvnum());
		customerDetailsType.setNameoncard(webReq.getNameoncard());
		customerDetailsType.setExpdate(webReq.getExpdate());

		TransCategoryType transCategoryType = new TransCategoryType();
		transCategoryType.setTypeOfCategory(webReq.getTypeOfCategory());

		wsReqType.setClientDetails(clientDetailsType);
		wsReqType.setCustomerDetails(customerDetailsType);
		wsReqType.setTransCategory(transCategoryType);

		return wsReqType;
	}

}
