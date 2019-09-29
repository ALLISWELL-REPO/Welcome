package com.citybank.statementDtls.process.builder;

import com.citybank.statementDtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbReq;

public class StatementDtlsProcessReqBuilder {

	
	public  StatementDtlsDAOReq daoReqBuilder(StatementDtlsProcessVbReq vbReq){
		
		
		StatementDtlsDAOReq daoReq = new StatementDtlsDAOReq();

		daoReq.setCardnum(vbReq.getCardnum());

		daoReq.setCvvnum(vbReq.getCvvnum());

		daoReq.setNameoncard(vbReq.getNameoncard());

		daoReq.setExpdate(vbReq.getExpdate());

		daoReq.setStartdate(vbReq.getStartdate());

		daoReq.setEnddate(vbReq.getEnddate());
		
		
		return daoReq;
		
	}
	
	
	
	
}
