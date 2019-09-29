package com.citybank.stmtdtlssvc.client;

import com.citybank.statementdtls.service.impl.StatementDetails;
import com.citybank.statementdtls.service.impl.StatementDetailsSvcImplService;
import com.citybank.statementdtls_schema.req.ClientDetailsType;
import com.citybank.statementdtls_schema.req.CustomerDetailsType;
import com.citybank.statementdtls_schema.req.StatementDtlsReqType;
import com.citybank.statementdtls_schema.req.TransCategoryType;
import com.citybank.statementdtls_schema.resp.StatementDtlsResType;

public class StatemetDtlsClientTest {

	public static void main(String[] args) {
		StatementDetailsSvcImplService service = new StatementDetailsSvcImplService();
		StatementDetails port = service.getStatementDetailsSvcImplPort();
		StatementDtlsReqType reqType = new StatementDtlsReqType();

		ClientDetailsType clientDetailsType = new ClientDetailsType();
		clientDetailsType.setClientId("amazon");
		clientDetailsType.setChannelId("mobile app");
		clientDetailsType.setReqId("Req11");

		CustomerDetailsType customerDetailsType = new CustomerDetailsType();
		customerDetailsType.setCardnum("11223344");
		customerDetailsType.setCvvnum("426");
		customerDetailsType.setExpdate("0122");
		customerDetailsType.setNameoncard("arun sunny");

		TransCategoryType transCategoryType = new TransCategoryType();

		// transCategoryType.getDateRange().setStartDate("01-04-2018");
		// transCategoryType.getDateRange().setEndDate("01-06-2018");
		transCategoryType.setTypeOfCategory("full");
		reqType.setClientDetails(clientDetailsType);
		reqType.setCustomerDetails(customerDetailsType);
		reqType.setTransCategory(transCategoryType);

		StatementDtlsResType wsRes = port.getTrasactions(reqType);
		
		
		System.out.println(wsRes.getStatusBlock().getRespCode());
		System.out.println(wsRes.getTransDetails().getTrasaction().get(0).getAmout());
	}

}
