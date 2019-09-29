package com.citybank.statementdtls.service.validator;

import com.citybank.statementdtls.service.util.StmtSvcReqInvalidException;
import com.citybank.statementdtls_schema.req.ClientDetailsType;
import com.citybank.statementdtls_schema.req.CustomerDetailsType;
import com.citybank.statementdtls_schema.req.StatementDtlsReqType;

public class StatementDtlsSvcValidator {

	public void validateWsRequest(StatementDtlsReqType wsReq) throws StmtSvcReqInvalidException {
		System.out.println("validating the request");
		if (wsReq == null || wsReq.getClientDetails() == null || wsReq.getCustomerDetails() == null) {
			throw new StmtSvcReqInvalidException("Req001", "Req object is null");
		}
		// validating client details
		ClientDetailsType clientDtlsType = wsReq.getClientDetails();
		if (clientDtlsType.getChannelId() == null || "".equals(clientDtlsType.getChannelId().trim())) {
			System.out.println("Validating client details");
			throw new StmtSvcReqInvalidException("Req002", "Channel Id is invalid");
		}
		if (clientDtlsType.getClientId() == null || "".equals(clientDtlsType.getClientId().trim())) {
			System.out.println("Validating client details");
			throw new StmtSvcReqInvalidException("Req003", "Client Id is invalid");
		}
		if (clientDtlsType.getReqId() == null || "".equals(clientDtlsType.getReqId().trim())) {
			System.out.println("Validating client details");
			throw new StmtSvcReqInvalidException("Req004", "Request Id is invalid");
		} 
		// validating customer details
		CustomerDetailsType customerDtls = wsReq.getCustomerDetails();

		if (customerDtls.getCardnum() == null || "".equals(customerDtls.getCardnum().trim())) {
			System.out.println("Validating customer details");
			throw new StmtSvcReqInvalidException("Req005", "Card number is invalid");
		}
		if (customerDtls.getCvvnum() == null || "".equals(customerDtls.getCvvnum().trim())) {
			System.out.println("Validating customer details");
			throw new StmtSvcReqInvalidException("Req006", "Cvv number is invalid");
		}
		if (customerDtls.getExpdate() == null || "".equals(customerDtls.getExpdate().trim())) {
			System.out.println("Validating customer details");
			throw new StmtSvcReqInvalidException("Req007", "Exp date  is invalid");
		}
		if (customerDtls.getNameoncard() == null || "".equals(customerDtls.getNameoncard().trim())) {
			System.out.println("Validating customer details");
			throw new StmtSvcReqInvalidException("Req008", "Name on card  is invalid");
		}

	}

}
