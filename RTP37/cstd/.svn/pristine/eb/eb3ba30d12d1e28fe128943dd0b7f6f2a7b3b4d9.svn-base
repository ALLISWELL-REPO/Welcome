package com.citybank.statementdtls.process.builder;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;

@Component
public class StatementDtlsProcessReqBuilder {

	public StatementDtlsDAOReq daoReqBuilder(StatementDtlsProcessVbReq vbreq) {
		// TODO Auto-generated method stub

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
		return daoReq;
	}

}
