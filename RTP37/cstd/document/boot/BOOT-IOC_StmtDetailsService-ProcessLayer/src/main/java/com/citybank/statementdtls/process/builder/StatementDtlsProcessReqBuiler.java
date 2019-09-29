package com.citybank.statementdtls.process.builder;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;

@Component
public class StatementDtlsProcessReqBuiler {
	//private Logger logger = Logger.getLogger(StatementDtlsProcessReqBuiler.class);

	public StatementDtlsDAOReq buildDAORequest(StatementDtlsProcessVbReq vbReq) {
		//logger.debug("enter into the process req builder");
		StatementDtlsDAOReq daoReq = new StatementDtlsDAOReq();

		daoReq.setClientId(vbReq.getClientId());
		daoReq.setChannelId(vbReq.getChannelId());
		daoReq.setCardNum(vbReq.getCardNum());
		daoReq.setCvvNum(vbReq.getCvvNum());
		daoReq.setNameOnCard(vbReq.getNameOnCard());
		daoReq.setExpDate(vbReq.getExpDate());
		daoReq.setStartDate(vbReq.getStartDate());
		daoReq.setEnsDate(vbReq.getEndDate());
		daoReq.setTypeOfCate(vbReq.getTypeOfCate());
		
		//logger.debug("exit from the process req builder");
		return daoReq;
	}

}
