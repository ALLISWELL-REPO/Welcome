package com.citybank.statementdtls.process.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.impl.StatementDtlsSpringImpl;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;
import com.citybank.statementdtls.process.StatementDtlsProcess;
import com.citybank.statementdtls.process.builder.StatementDtlsProcessReqBuilder;
import com.citybank.statementdtls.process.builder.StatementDtlsProcessResBuilder;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
@Component
public class StatementDtlsProcessImpl implements StatementDtlsProcess {
	@Autowired
	StatementDtlsDAO daoImpl=null;
	@Autowired
	StatementDtlsProcessReqBuilder reqProcessBuilder=null;
	@Autowired
	StatementDtlsProcessResBuilder resProcess=null;
	public StatementDtlsProcessVbRes getTransactions(StatementDtlsProcessVbReq vbreq)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {
		System.out.println("Enter into process layer");
		// TODO Auto-generated method stub
		// 1.call the req from service layer

		// 2.prepare the req from the integration layer
		reqProcessBuilder = new StatementDtlsProcessReqBuilder();
		StatementDtlsDAOReq daoReq = reqProcessBuilder.daoReqBuilder(vbreq);

		// dao contains list of transaction
		
		// daoRes contains List of TransDAO
	     StatementDtlsDAORes daoRes = daoImpl.getTransactions(daoReq);
		// 4.prepare the vbresp.i.e convert daoRes to vbresp
		resProcess = new StatementDtlsProcessResBuilder();
		StatementDtlsProcessVbRes vbResp = resProcess.resProcessBuilder(daoRes, vbreq);
		return vbResp;
	}

	public static void main(String[] args)
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		StatementDtlsProcessImpl processImpl = new StatementDtlsProcessImpl();
		StatementDtlsProcessVbReq processReq = new StatementDtlsProcessVbReq();
		processReq.setClientId("web");
		processReq.setChannelId("online");
		processReq.setCardNum("576111000888978");
		processReq.setCvvNum("345");
		processReq.setExpDate("02-10-2014");

		StatementDtlsProcessVbRes processResp = processImpl.getTransactions(processReq);
		System.out.println("ResponseCode " + processResp.getRespCode());
		System.out.println("ResponseMsg " + processResp.getRespMsg());
		System.out.println("TRansactionProcess " + processResp.getTransProcess().size());

	}

}
