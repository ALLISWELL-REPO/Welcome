package com.citybank.statementdtls.service.validator;

import org.apache.log4j.Logger;

import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.statementdtls.service.impl.StatementDtlsSvcImpl;
import com.citybank.statementdtls.service.util.StatementReqInvalidException;

public class StatementDtlsSvcReqValidator {
	private Logger logger = Logger.getLogger(StatementDtlsSvcReqValidator.class);


	public void validate(StatementDtlsReqType wsReq) throws StatementReqInvalidException {
		logger.debug("validating Webservice request");
		// TODO Auto-generated method stub

		if (wsReq == null || wsReq.getClientDetails() == null || wsReq.getCustomerDetails() == null) {
			throw new StatementReqInvalidException("stmt001", "Request object is null");
		}

		
		ClientDetailsType clientDetails = wsReq.getClientDetails();
		if (clientDetails.getClientid() == null || "".equals(clientDetails.getClientid())) {
			throw new StatementReqInvalidException("stmt002", "ClientId is invalid");
		}
		
		/*if (clientDetails == null || clientDetails.getClientid() == null ){
			throw new StatementReqInvalidException("stmt002", "ClientId is invalid");
		}*/
		
		
		if (clientDetails.getChannelid() == null || "".equals(clientDetails.getChannelid().trim())) {
			throw new StatementReqInvalidException("stmt003", "ChannelId is invalid");
		}
		CustomerDetailsType custDetails = wsReq.getCustomerDetails();
		if (custDetails.getCardnum() == null || "".equals(custDetails.getCardnum().trim())) {
			throw new StatementReqInvalidException("stmt004", "CardNum is invalid");
		}
		if (custDetails.getCvvnum() == null) {
			throw new StatementReqInvalidException("stmt005", "CvvNum is invalid");
		}
		if (custDetails.getNameoncard() == null || "".equals(custDetails.getNameoncard().trim())) {
			throw new StatementReqInvalidException("stmt006", "Name on Card is Invalid");
		}
		if (custDetails.getExpdate() == null || "".equals(custDetails.getExpdate().trim())) {
			throw new StatementReqInvalidException("stmt007", "Expiry Date is invalid");
		}

		/*
		 * TransCategoryType tranCat=wsReq.getTransCategory();
		 * if(tranCat.getDataRange().getStartdate()==null ||
		 * "".equals(tranCat.getDataRange().getStartdate())){ throw new
		 * StatementReqInvalidException("stmt008", "Start Date is invalid"); }
		 * 
		 * if(tranCat.getDataRange().getStartdate()==null ||
		 * "".equals(tranCat.getDataRange().getEnddate())){ throw new
		 * StatementReqInvalidException("stmt008", "End Date is invalid");
		 * 
		 * }
		 */
		logger.debug("validating Webservice request done......");
	}

}
