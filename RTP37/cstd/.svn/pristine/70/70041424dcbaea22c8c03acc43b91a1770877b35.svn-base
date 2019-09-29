package com.citybank.card.stmtsvc.client.builder;

import java.util.UUID;

import com.citybank.card.stmtsvc.client.beans.StatementDtlsWebReq;
import com.citybank.card.stmtsvc.client.util.StatementDtlsConstant;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.DataRangeType;
import com.citybank.statementdtls.schema.req.ServiceDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.service.impl.StatementDetailsSvc;
import com.citybank.statementdtls.service.impl.StatementDtlsSvcImplService;

public class StatementSvcClientReqBuilder {

	public StatementDtlsReqType buildWsRequest(StatementDtlsWebReq webReq) {
		// TODO Auto-generated method stub

		
		StatementDtlsReqType wsReq = new StatementDtlsReqType();
		ClientDetailsType clientDetailsType = new ClientDetailsType();
		clientDetailsType.setClientid(StatementDtlsConstant.CLIENT_ID);
		clientDetailsType.setChannelid(StatementDtlsConstant.CHANNEL_ID);

		clientDetailsType.setReqid(UUID.randomUUID().toString());
		

		CustomerDetailsType customerDetailsType = new CustomerDetailsType();
		customerDetailsType.setCardnum(webReq.getCardNum());
		customerDetailsType.setCvvnum(Integer.valueOf(webReq.getCvvNum()));
	    customerDetailsType.setNameoncard(webReq.getNameOnCard());
		customerDetailsType.setExpdate(webReq.getExpDate());

		TransCategoryType transCategoryType = new TransCategoryType();
		DataRangeType dateRange=new DataRangeType();
		//dateRange.setStartdate(webReq.getStartDate());
		//dateRange.setEnddate(webReq.getEndDate());
		transCategoryType.setTypeofcategory(webReq.getTypeOfCate());

		wsReq.setClientDetails(clientDetailsType);
		wsReq.setCustomerDetails(customerDetailsType);
		wsReq.setTransCategory(transCategoryType);
	

		/*StatementDtlsResType wsRes = stmtSvc.getTransactions(wsReq);
		System.out.println(wsRes.getStatusBlock().getReapcode());
		System.out.println(wsRes.getStatusBlock().getRespmsg());
		System.out.println(wsRes.getTransDetails().getTransaction().size());
*/
		return wsReq;
	}

}
