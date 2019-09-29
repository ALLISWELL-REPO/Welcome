package com.citybank.statementDtls.process.builder;

import java.util.ArrayList;
import java.util.List;

import com.citybank.statementDtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementDtls.dao.beans.TransactionDAO;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementDtls.process.valuebeans.TransactionProcess;

public class StatementDtlsProcessResBuilder {

	public StatementDtlsProcessVbRes resProcessBuilder(
			StatementDtlsDAORes daoResp) {

		StatementDtlsProcessVbRes vbResp = new StatementDtlsProcessVbRes();

		vbResp.setExpncode(daoResp.getExpncode());
		vbResp.setExpmsg(daoResp.getExpmsg());

		List<TransactionDAO> daoTransList = daoResp.getTransDAO();

		// iterate transactions from dao and set to process

		List<TransactionProcess> transProcessList = new ArrayList<TransactionProcess>();

		for (TransactionDAO daoTrans : daoTransList) {
			TransactionProcess transProcess = new TransactionProcess();

			transProcess.setTransid(daoTrans.getTransid());

			transProcess.setName(daoTrans.getName());

			transProcess.setAmount(daoTrans.getAmount());

			transProcess.setDesc(daoTrans.getDesc());

			transProcess.setMerchantname(daoTrans.getMerchantname());

			transProcess.setStatus(daoTrans.getStatus());

			transProcess.setRemarks(daoTrans.getRemarks());

		}

		vbResp.setTransProcess(transProcessList);

		System.out.println("Exit from process layer");
		
		return vbResp;

	}

}
