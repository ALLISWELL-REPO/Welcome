package com.citybank.statementdtls.process.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.impl.StatementDtlsDAO;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;
import com.citybank.statementdtls.process.builder.StatementDtlsProcessReqBuilder;
import com.citybank.statementdtls.process.builder.StatementDtlsProcessResBuilder;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;

@Component
public class StatementDtlsProcessImpl implements StatementDtlsProcess {

	@Autowired
	StatementDtlsDAO dao = null;

	@Autowired
	StatementDtlsProcessReqBuilder daoReqBuilder = null;

	@Autowired
	StatementDtlsProcessResBuilder processVbResponse = null;

	public StatementDtlsProcessVbRes getTransactions(
			StatementDtlsProcessVbReq vbReq) throws BusinessException,
			SystemException, ClassNotFoundException, SQLException {

		System.out.println("Entered into process layer");
		// 1 . get the request from service layer
		// 2. build the request for integration layer

		daoReqBuilder = new StatementDtlsProcessReqBuilder();
		StatementDtlsDAOReq daoReq = daoReqBuilder.buildDAORequest(vbReq);
		// call dao class

		System.out.println("process dao " + dao);
		StatementDtlsDAORes daoRes = dao.getTransactions(daoReq);

		processVbResponse = new StatementDtlsProcessResBuilder();

		StatementDtlsProcessVbRes processVbRes = processVbResponse
				.buildProcessVbResponse(daoRes, vbReq);
		System.out.println("exit from process layer");

		return processVbRes;
	}

}
