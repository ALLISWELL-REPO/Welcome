package com.citybank.statementdtls.process.builder;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;

@Component
public class StatementDtlsProcessReqBuilder {

	public StatementDtlsDAOReq buildDAORequest(StatementDtlsProcessVbReq vbReq) {

		StatementDtlsDAOReq daoReq = new StatementDtlsDAOReq();

		daoReq.setClientid(vbReq.getClientid());
		daoReq.setChannelid(vbReq.getChannelid());
		daoReq.setCardnum(vbReq.getCardnum());
		daoReq.setCvvnum(vbReq.getCvvnum());
		daoReq.setExpdate(vbReq.getExpdate());
		daoReq.setNameoncard(vbReq.getNameoncard());
		daoReq.setStartdate(vbReq.getStartdate());
		daoReq.setEnddate(vbReq.getEnddate());
		// .set
		daoReq.setTypeOfCate(vbReq.getTypeOfCate());

		return daoReq;

	}

}
