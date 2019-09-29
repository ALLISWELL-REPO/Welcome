package com.citybank.statementDtls.dao.impl;

import com.citybank.statementDtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementDtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementDtls.dao.util.BusinessException;
import com.citybank.statementDtls.dao.util.SystemException;

public interface StatementDtlsDAO {

	public StatementDtlsDAORes getTransactions(StatementDtlsDAOReq daoReq) throws BusinessException, SystemException;
	
	
}
