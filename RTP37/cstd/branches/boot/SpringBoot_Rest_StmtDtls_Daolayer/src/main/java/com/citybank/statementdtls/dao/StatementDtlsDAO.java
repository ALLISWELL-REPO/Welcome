package com.citybank.statementdtls.dao;

import java.sql.SQLException;

import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;

public interface StatementDtlsDAO {
	
	StatementDtlsDAORes getTransactions (StatementDtlsDAOReq daoReq) throws BusinessException, SystemException, ClassNotFoundException, SQLException;
	

}
