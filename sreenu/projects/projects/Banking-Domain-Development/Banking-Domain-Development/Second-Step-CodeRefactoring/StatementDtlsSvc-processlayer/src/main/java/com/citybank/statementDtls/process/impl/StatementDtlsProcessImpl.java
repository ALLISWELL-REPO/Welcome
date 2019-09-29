package com.citybank.statementDtls.process.impl;

import java.util.ArrayList;
import java.util.List;

import com.citybank.statementDtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementDtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementDtls.dao.beans.TransactionDAO;
import com.citybank.statementDtls.dao.impl.StatementDtlsDAO;
import com.citybank.statementDtls.dao.impl.StatementDtlsDAOImpl;
import com.citybank.statementDtls.process.StatementDtlsProcess;
import com.citybank.statementDtls.process.builder.StatementDtlsProcessReqBuilder;
import com.citybank.statementDtls.process.builder.StatementDtlsProcessResBuilder;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementDtls.process.valuebeans.TransactionProcess;

public class StatementDtlsProcessImpl implements StatementDtlsProcess {

	public StatementDtlsProcessVbRes getTransactions(
			StatementDtlsProcessVbReq vbReq) {

		System.out.println("Entered into Process layer");

		// get the process request from service layer

		// preapre the integration request with the help of process request i.e
		// convert process-request to intg-request

		StatementDtlsProcessReqBuilder reqProcessBuilder = new StatementDtlsProcessReqBuilder();

		StatementDtlsDAOReq daoReq = reqProcessBuilder.daoReqBuilder(vbReq);

		// call integration layer by passing intg-request and get the
		// integration response

		StatementDtlsDAO dao = new StatementDtlsDAOImpl();

		StatementDtlsDAORes daoResp = dao.getTransactions(daoReq);

		// now preapre the process response with the help of integration
		// response i.e convert integ. response into process response

		StatementDtlsProcessResBuilder resProcess = new StatementDtlsProcessResBuilder();
		StatementDtlsProcessVbRes vbResp = resProcess
				.resProcessBuilder(daoResp);

		System.out.println("Exit from process layer");
		return vbResp;
	}

}
