package com.citybank.stmtdtlssvc.client.impl;

import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.res.StatementDtlsRespType;
import com.citybank.statementdtls.service.impl.StatementDetailsService;
import com.citybank.statementdtls.service.impl.StatementDtlsSvcImplService;
import com.citybank.stmtdtlssvc.client.StatementDtlsSvcClient;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.builder.StatementDtlsSvcClientReqBuilder;
import com.citybank.stmtdtlssvc.client.builder.StatementDtlsSvcClientResBuilder;

public class StatementDtlsSvcClientImpl implements StatementDtlsSvcClient {

	public StatementDtlsWebRes getTransactions(StatementDtlsWebReq webReq) {

		// get the request from controller
		// convert webReq to WsReq

		StatementDtlsSvcClientReqBuilder clientReqBuilder = new StatementDtlsSvcClientReqBuilder();

		StatementDtlsReqType wsReq = clientReqBuilder.buildWsRequest(webReq);
		// on service object call port it gives interface

		StatementDtlsSvcImplService service = new StatementDtlsSvcImplService();

		StatementDetailsService port = service.getStatementDtlsSvcImplPort();

		// call the api

		StatementDtlsRespType wsRes = port.getTransactions(wsReq);

		StatementDtlsSvcClientResBuilder resBuilder = new StatementDtlsSvcClientResBuilder();

		StatementDtlsWebRes webRes = resBuilder.buildWebResponse(wsRes);

		return webRes;
	}

	public static void main(String[] args) {

		StatementDtlsSvcClientImpl clientImpl = new StatementDtlsSvcClientImpl();

		StatementDtlsWebReq req = new StatementDtlsWebReq();
		req.setCardnum("1234565787");
		req.setCvvnum("123");
		req.setNameoncard("rOHIT");
		req.setExpdate("11-22");
		req.setTypeOfCategory("all");
		System.out.println("Calling service provider");
		StatementDtlsWebRes res = clientImpl.getTransactions(req);
		System.out.println(res.getExpncode());
		System.out.println(res.getExpmsg());

		System.out.println(res.getWebTransList());
	}

}
