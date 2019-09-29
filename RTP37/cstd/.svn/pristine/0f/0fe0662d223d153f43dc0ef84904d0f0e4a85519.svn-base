/* @CityBank 2018.All Rights are reserved.It is confidential
 * We should disclose this information outside.
 * Otherwise terms and conditions will apply.
 *  
 */
package com.citybank.statementdtls.service.validator;

import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.service.util.StatementReqInvalidException;

/**
 * @author Abhinav
 *
 *         Jun 22, 2018
 */
public class StatementDtlsSvcReqValidator {

	/**
	 * @param wsReq
	 *            throws StatementReqInvalidException
	 */
	public void validateWSReq(StatementDtlsReqType wsReq) throws StatementReqInvalidException {
		// Checking Request is Valid or not
		if (wsReq == null || wsReq.getClientDetails() == null || wsReq.getCustomerDetails() == null) {
			throw new StatementReqInvalidException("stmt001", "Request Object is null.");
		}
		// Check ClientDetails is valid or not
		ClientDetailsType clientDtls = wsReq.getClientDetails();
		if (clientDtls.getClientid() == null || " ".equals(clientDtls.getClientid())) {
			throw new StatementReqInvalidException("stmt002", "ClientId is invalid.");
		}
		if (clientDtls.getChannelid() == null || " ".equals(clientDtls.getChannelid())) {
			throw new StatementReqInvalidException("stmt003", "ChannelId is invalid.");
		}
		if (clientDtls.getReqid() == null || " ".equals(clientDtls.getReqid())) {
			throw new StatementReqInvalidException("stmt004", "RequestID is invalid.");
		}
		// Checking CustomerDetails is Valid or not
		CustomerDetailsType custDtls = wsReq.getCustomerDetails();
		if (custDtls.getCardnum() == null || " ".equals(custDtls.getCardnum())) {
			throw new StatementReqInvalidException("stmt005", "CardNumber is invalid.");
		}
		if (custDtls.getCvvnum() == null || " ".equals(custDtls.getCvvnum())) {
			throw new StatementReqInvalidException("stmt006", "cvv number is invalid.");
		}
		if (custDtls.getExpdate() == null || " ".equals(custDtls.getExpdate())) {
			throw new StatementReqInvalidException("stmt007", "ExpDate is invalid.");
		}
		if (custDtls.getNameoncard() == null || " ".equals(custDtls.getNameoncard())) {
			throw new StatementReqInvalidException("stmt008", "Name On Card is invalid.");
		}
	}

}
