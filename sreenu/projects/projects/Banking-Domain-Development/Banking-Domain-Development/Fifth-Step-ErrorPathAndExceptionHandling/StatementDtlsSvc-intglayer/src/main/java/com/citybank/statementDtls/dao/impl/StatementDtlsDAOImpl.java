package com.citybank.statementDtls.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.citybank.statementDtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementDtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementDtls.dao.beans.TransactionDAO;
import com.citybank.statementDtls.dao.util.BusinessException;
import com.citybank.statementDtls.dao.util.SystemException;

public class StatementDtlsDAOImpl implements StatementDtlsDAO {

	public StatementDtlsDAORes getTransactions(StatementDtlsDAOReq daoReq)
			throws BusinessException, SystemException {

		System.out.println("Entered into DAO layer");
		// get the integration request from process layer

		// preapre db request with help of intg request

		// i.e convert integartion request to db request

		// call db by passing db request and get resultset (db resp)

		String daoRespCode = "0";
		String daoRespMsg = "Success";

		StatementDtlsDAORes daoResp = null;

		List<TransactionDAO> transDAOList = new ArrayList<TransactionDAO>();

		if ("0".equals(daoRespCode)) {

			daoResp = new StatementDtlsDAORes();

			daoResp.setExpncode("0000");
			daoResp.setExpmsg("Success");

			for (int i = 0; i < 5; i++) {

				TransactionDAO tarnsDAO = new TransactionDAO();

				tarnsDAO.setTransid("1000");
				tarnsDAO.setName("Mobile");
				tarnsDAO.setAmount("10000");
				tarnsDAO.setDesc("Good");
				tarnsDAO.setMerchantname("Amazon");
				tarnsDAO.setStatus("Success");
				tarnsDAO.setRemarks("NA");

				transDAOList.add(tarnsDAO);

			}
			daoResp.setTransDAO(transDAOList);
		}

		else if ("100".equals(daoRespCode) || "101".equals(daoRespCode)) {

			System.out.println("in business exception");

			throw new BusinessException(daoRespCode, daoRespMsg);
		}

		else {

			System.out.println("in system exception");
			throw new SystemException(daoRespCode, daoRespMsg);
		}

		System.out.println("Exit from DAO Layer");

		return daoResp;
	}

}
