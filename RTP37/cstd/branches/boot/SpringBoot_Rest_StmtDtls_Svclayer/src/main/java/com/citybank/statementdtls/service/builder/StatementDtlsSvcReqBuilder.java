package com.citybank.statementdtls.service.builder;

import org.apache.log4j.Logger;

import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.service.util.XmlGregorianDataToString;
import com.citybank.statementdtls.service.validator.StatementDtlsSvcReqValidator;

public class StatementDtlsSvcReqBuilder {
	private Logger logger = Logger.getLogger(StatementDtlsSvcReqBuilder.class);

	public StatementDtlsProcessVbReq processReqBuilder(StatementDtlsReqType wsReq) {
		// TODO Auto-generated method stub
		logger.debug("Enter into webService RequestBuilder layer");
		StatementDtlsProcessVbReq vbreq = new StatementDtlsProcessVbReq();
		logger.debug("ProcessVb request object is created");
		vbreq.setClientId(wsReq.getClientDetails().getClientid());
		vbreq.setChannelId(wsReq.getClientDetails().getChannelid());
		vbreq.setCardNum(wsReq.getCustomerDetails().getCardnum());
		// vbreq.setCvvNum(String.valueOf(wsReq.getCustomerDetails().getCvvnum()));
		vbreq.setCvvNum(wsReq.getCustomerDetails().getCvvnum());
		vbreq.setNameOnCard(wsReq.getCustomerDetails().getNameoncard());
		vbreq.setExpDate(wsReq.getCustomerDetails().getExpdate());
		/*
		 * if (wsReq.getTransCategory() != null ||
		 * wsReq.getTransCategory().getDataRange() != null ||
		 * wsReq.getTransCategory().getDataRange().getStartdate() != null) {
		 * 
		 * vbreq.setStartDate(XmlGregorianDataToString
		 * .convertXmlGregorianToString(wsReq.getTransCategory().getDataRange().
		 * getStartdate())); } if (wsReq.getTransCategory() != null ||
		 * wsReq.getTransCategory().getDataRange() != null ||
		 * wsReq.getTransCategory().getDataRange().getEnddate() != null) {
		 * 
		 * vbreq.setEndDate(XmlGregorianDataToString
		 * .convertXmlGregorianToString(wsReq.getTransCategory().getDataRange().
		 * getEnddate()));
		 * 
		 * }
		 */
		if (wsReq.getTransCategory() != null) {
			vbreq.setTypeOfCate(wsReq.getTransCategory().getTypeofcategory());
		}
		logger.debug("Exit from webService Request builder layer");
		return vbreq;
	}

	
	

}
