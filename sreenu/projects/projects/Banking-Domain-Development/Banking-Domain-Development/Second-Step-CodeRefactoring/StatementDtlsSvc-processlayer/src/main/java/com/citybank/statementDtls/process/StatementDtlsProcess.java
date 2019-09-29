package com.citybank.statementDtls.process;

import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbRes;

public interface StatementDtlsProcess {

	
	public StatementDtlsProcessVbRes getTransactions(StatementDtlsProcessVbReq vbReq);
	
	
	
}
