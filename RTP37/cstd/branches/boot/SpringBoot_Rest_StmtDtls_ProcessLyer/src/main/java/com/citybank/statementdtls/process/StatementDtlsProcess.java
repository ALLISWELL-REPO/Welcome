package com.citybank.statementdtls.process;

import java.sql.SQLException;

import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;

public interface StatementDtlsProcess {
	
	StatementDtlsProcessVbRes getTransactions(StatementDtlsProcessVbReq vbreq) throws BusinessException, SystemException, ClassNotFoundException, SQLException;
}
