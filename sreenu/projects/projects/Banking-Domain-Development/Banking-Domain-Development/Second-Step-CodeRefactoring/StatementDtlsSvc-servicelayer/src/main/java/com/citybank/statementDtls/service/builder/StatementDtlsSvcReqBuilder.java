package com.citybank.statementDtls.service.builder;

import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;

public class StatementDtlsSvcReqBuilder {

	public StatementDtlsProcessVbReq processReqBuilder(StatementDtlsReqType wsReq) {

		StatementDtlsProcessVbReq vbReq = new StatementDtlsProcessVbReq();

		vbReq.setClientid(wsReq.getClientDetails().getClientid());
		vbReq.setChannelid(wsReq.getClientDetails().getChannelid());

		vbReq.setCardnum(wsReq.getCustomerDetails().getCardnum());

		vbReq.setCvvnum(wsReq.getCustomerDetails().getCardnum());

		vbReq.setNameoncard(wsReq.getCustomerDetails().getNameoncard());

		vbReq.setExpdate(wsReq.getCustomerDetails().getExpdate());

		return vbReq;

	}

}
