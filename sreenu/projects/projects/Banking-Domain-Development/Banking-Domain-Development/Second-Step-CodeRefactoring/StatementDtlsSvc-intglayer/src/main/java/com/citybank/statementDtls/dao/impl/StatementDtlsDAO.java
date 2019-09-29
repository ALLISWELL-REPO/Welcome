package com.citybank.statementDtls.dao.impl;

import com.citybank.statementDtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementDtls.dao.beans.StatementDtlsDAORes;

public interface StatementDtlsDAO {

	public StatementDtlsDAORes getTransactions(StatementDtlsDAOReq daoReq);
	
	
}
