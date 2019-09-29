package com.citybank.statementdtls.process.builder;

import org.apache.log4j.Logger;

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.impl.StatementDtlsDAOImpl;
import com.citybank.statementdtls.process.impl.StatementDtlsProcessImpl;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;

public class StatementDtlsProcessReqBuilder {
	private Logger logger = Logger.getLogger(StatementDtlsProcessReqBuilder.class);

	public StatementDtlsDAOReq daoReqBuilder(StatementDtlsProcessVbReq vbreq) {
		// TODO Auto-generated method stub
		logger.debug("Enter into process Request Layer");
		StatementDtlsDAOReq daoReq = new StatementDtlsDAOReq();

		daoReq.setClientId(vbreq.getClientId());
		daoReq.setChannelId(vbreq.getChannelId());
		daoReq.setCardNum(vbreq.getCardNum());
		daoReq.setCvvNum(vbreq.getCvvNum());
		daoReq.setNameOnCard(vbreq.getNameOnCard());
		daoReq.setExpDate(vbreq.getExpDate());
		daoReq.setStartDate(vbreq.getStartDate());
		daoReq.setEndDate(vbreq.getEndDate());
		daoReq.setTypeOfCate(vbreq.getTypeOfCate());
		// dao contains list of transaction
		logger.debug("Exit from process request layer");
		return daoReq;
	}

}
