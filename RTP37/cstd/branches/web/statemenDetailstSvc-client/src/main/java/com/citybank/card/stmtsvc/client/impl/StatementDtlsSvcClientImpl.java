package com.citybank.card.stmtsvc.client.impl;

import com.citybank.card.stmtsvc.client.StatementDtlsSvcClient;
import com.citybank.card.stmtsvc.client.beans.StatementDtlsWebReq;
import com.citybank.card.stmtsvc.client.beans.StatementDtlsWebResp;
import com.citybank.card.stmtsvc.client.builder.StatementSvcClientReqBuilder;
import com.citybank.card.stmtsvc.client.builder.StatementSvcClientResBuilder;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.ServiceDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.service.impl.StatementDetailsSvc;
import com.citybank.statementdtls.service.impl.StatementDtlsSvcImplService;

public class StatementDtlsSvcClientImpl implements StatementDtlsSvcClient {


	public StatementDtlsWebResp getTransactions(StatementDtlsWebReq webReq) {
		// TODO Auto-generated method stub
		StatementSvcClientReqBuilder clientReqBuilder = new StatementSvcClientReqBuilder();
		StatementDtlsReqType wsReq = clientReqBuilder.buildWsRequest(webReq);

		StatementDtlsSvcImplService service = new StatementDtlsSvcImplService();
		StatementDetailsSvc stmtSvc = service.getStatementDtlsSvcImplPort();

		StatementDtlsResType wsRes = stmtSvc.getTransactions(wsReq);

		StatementSvcClientResBuilder clientResBuilder = new StatementSvcClientResBuilder();
		StatementDtlsWebResp webResp = clientResBuilder.buildWsResponse(wsRes);

		return webResp;

	}

	public static void main(String[] args) {

		StatementDtlsSvcClientImpl clientImpl = new StatementDtlsSvcClientImpl();
		StatementDtlsWebReq req = new StatementDtlsWebReq();
		req.setCardNum("12334487");
		req.setCvvNum("129");
		req.setNameOnCard("Sudhansu");
		req.setTypeOfCate("All");
		req.setStartDate("10-07-2018");
		req.setEndDate("05-09-2019");
		
		StatementDtlsWebResp res=clientImpl.getTransactions(req);
		System.out.println(res.getRespCode());
		System.out.println(res.getRespMsg());
		
	}

}
