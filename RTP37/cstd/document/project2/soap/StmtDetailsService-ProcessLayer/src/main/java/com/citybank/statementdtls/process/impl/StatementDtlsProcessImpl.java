package com.citybank.statementdtls.process.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TrasactionDAO;
import com.citybank.statementdtls.dao.impl.StatementDtlsDAOImpl;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;
import com.citybank.statementdtls.process.StatementDtlsProcess;
import com.citybank.statementdtls.process.builder.StatementDtlsProcessReqBuiler;
import com.citybank.statementdtls.process.builder.StatementDtlsProcessResBuiler;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.process.valuebeans.TransactionProcess;
import com.citybank.statementdtls.process.valuebeans.TransactionProcess;

public class StatementDtlsProcessImpl implements StatementDtlsProcess {

	public StatementDtlsProcessVbRes getTrasactions(StatementDtlsProcessVbReq vbReq) throws BusinessException, SystemException, ClassNotFoundException, SQLException {
		System.out.println("Enter into process layer");
		// 1. get the request from the service layer
		// 2. build the request for Integration layer(dao)
		StatementDtlsProcessReqBuiler daoReqBuilder = new StatementDtlsProcessReqBuiler();
		StatementDtlsDAOReq daoReq = daoReqBuilder.buildDAORequest(vbReq);

		// call the dao class
		StatementDtlsDAO dao = new StatementDtlsDAOImpl();
		StatementDtlsDAORes daoRes = dao.getTrasactions(daoReq);

		// now convert dao response to valuebean response ie service layer
		// response
		StatementDtlsProcessResBuiler processVbResponse = new StatementDtlsProcessResBuiler();
		StatementDtlsProcessVbRes processVbRes = processVbResponse.buildProcessVbResponse(daoRes,vbReq);
		
		System.out.println("Exit from process layer");
		return processVbRes;
	}
	public static void main(String[] args) throws BusinessException, SystemException, ClassNotFoundException, SQLException {
		StatementDtlsProcessImpl dtlsProcessImpl=new StatementDtlsProcessImpl();
		StatementDtlsProcessVbReq req=new StatementDtlsProcessVbReq();
		req.setClientId("web");
		req.setChannelId("online");
		req.setCvvNum(514);
		req.setCardNum("45900500000321478");
		req.setExpDate("2018-04-03");
		//req.setTypeOfCate("failure");
		StatementDtlsProcessVbRes res = dtlsProcessImpl.getTrasactions(req);
		System.out.println("code "+res.getRespCode());
		System.out.println("msg "+res.getRespMsg());
		System.out.println(res.getTransProcess().size());
	}

}





