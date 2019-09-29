package com.citybank.stmtdtlssvc.client.impl;

import com.citybank.statementdtls.service.impl.StatementDetails;
import com.citybank.statementdtls.service.impl.StatementDetailsSvcImplService;
import com.citybank.statementdtls_schema.req.StatementDtlsReqType;
import com.citybank.statementdtls_schema.resp.StatementDtlsResType;
import com.citybank.stmtdtlssvc.client.StatementDtlsSvcClient;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.builder.StatementDtlsSvcClientReqBuilder;
import com.citybank.stmtdtlssvc.client.builder.StatementDtlsSvcClientResBuilder;

public class StatementDtlsSvcClientImpl implements StatementDtlsSvcClient {

	public StatementDtlsWebRes getTrasactions(StatementDtlsWebReq webReq) {
		// get the request from controller
		// convert webReq to wsRes
		StatementDtlsSvcClientReqBuilder clientReqBuilder = new StatementDtlsSvcClientReqBuilder();
		StatementDtlsReqType wsReq = clientReqBuilder.buildWsRequest(webReq);
		// create service class object
		StatementDetailsSvcImplService service = new StatementDetailsSvcImplService();
		// on that services object call port it give interface
		StatementDetails port = service.getStatementDetailsSvcImplPort();
		// call the api
		StatementDtlsResType wsRes = port.getTrasactions(wsReq);
		StatementDtlsSvcClientResBuilder resBuilder = new StatementDtlsSvcClientResBuilder();
		StatementDtlsWebRes webRes = resBuilder.buildWebResponse(wsRes);

		return webRes;
	}

	public static void main(String[] args) {
		StatementDtlsSvcClientImpl clientImpl = new StatementDtlsSvcClientImpl();
		StatementDtlsWebReq req = new StatementDtlsWebReq();
		req.setCardNum("45900500000321478");
		req.setCvvNum(514);
		//req.setEndDate("01-05-2018");
		req.setNameOnCard("sunny");
		//req.setStartDate("01-03-2018");
		//req.setTypeOfCate("ALL");
		req.setExpDate("2018-04-03");
		System.out.println("calling server");
		StatementDtlsWebRes res = clientImpl.getTrasactions(req);
		 System.out.println(res.getRespCode());
		 System.out.println("hi "+res.getWebTransList().size());
	}

}
