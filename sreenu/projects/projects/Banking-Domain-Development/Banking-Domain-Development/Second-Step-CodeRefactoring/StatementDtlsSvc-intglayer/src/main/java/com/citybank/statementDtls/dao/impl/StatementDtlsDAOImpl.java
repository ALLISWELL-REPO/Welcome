package com.citybank.statementDtls.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.citybank.statementDtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementDtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementDtls.dao.beans.TransactionDAO;

public class StatementDtlsDAOImpl implements StatementDtlsDAO {

	public StatementDtlsDAORes getTransactions(StatementDtlsDAOReq daoReq) {

		System.out.println("Entered into DAO layer");
		// get the integration request from process layer

		// preapre db request with help of intg request

		// i.e convert integartion request to db request

		// call db by passing db request and get resultset (db resp)

		StatementDtlsDAORes daoResp = new StatementDtlsDAORes();

		daoResp.setExpncode("0000");
		daoResp.setExpmsg("Success");

		List<TransactionDAO> transDAOList = new ArrayList<TransactionDAO>();

		TransactionDAO tarnsDAO = new TransactionDAO();

		tarnsDAO.setTransid("1000");
		tarnsDAO.setName("Mobile");
		tarnsDAO.setAmount("10000");
		tarnsDAO.setDesc("Good");
		tarnsDAO.setMerchantname("Amazon");
		tarnsDAO.setStatus("Success");
		tarnsDAO.setRemarks("NA");

		TransactionDAO tarnsDAO1 = new TransactionDAO();

		tarnsDAO1.setTransid("2000");
		tarnsDAO1.setName("Pen");
		tarnsDAO1.setAmount("20000");
		tarnsDAO1.setDesc("Good");
		tarnsDAO1.setMerchantname("Filpkart");
		tarnsDAO1.setStatus("Pending");
		tarnsDAO1.setRemarks("NA");

		TransactionDAO tarnsDAO2 = new TransactionDAO();

		tarnsDAO2.setTransid("3000");
		tarnsDAO2.setName("tv");
		tarnsDAO2.setAmount("25000");
		tarnsDAO2.setDesc("Average");
		tarnsDAO2.setMerchantname("myYantra");
		tarnsDAO2.setStatus("success");
		tarnsDAO2.setRemarks("NA");

		transDAOList.add(tarnsDAO);

		transDAOList.add(tarnsDAO1);

		transDAOList.add(tarnsDAO2);

		daoResp.setTransDAO(transDAOList);

		System.out.println("Exit from DAO Layer");

		return daoResp;
	}

}
