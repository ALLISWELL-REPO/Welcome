package com.citybank.cards.statement.bootservice.validator;

import org.springframework.stereotype.Component;

import com.citybank.cards.statement.bootservice.util.StmtSvcReqInvalidException;
import com.citybank.cards.statement.req.ClientDetailsType;
import com.citybank.cards.statement.req.CustomerDetailsType;
import com.citybank.cards.statement.req.StatementDtlsReqType;

@Component
public class StatementDtlsSvcValidator {

	public void validateWsRequest(StatementDtlsReqType wsReq) throws StmtSvcReqInvalidException {
		System.out.println("enter into validation");
		if (wsReq == null || wsReq.getClientDetails() == null || wsReq.getCustomerDetails() == null) {
			throw new StmtSvcReqInvalidException("Req001", "Req object is null");
		}
		// validating client details
		ClientDetailsType clientDtlsType = wsReq.getClientDetails();
		if (clientDtlsType.getChannelId() == null || "".equals(clientDtlsType.getChannelId().trim())) {
			throw new StmtSvcReqInvalidException("Req002", "Channel Id is invalid");
		}
		if (clientDtlsType.getClientId() == null || "".equals(clientDtlsType.getClientId().trim())) {
			throw new StmtSvcReqInvalidException("Req003", "Client Id is invalid");
		}
		if (clientDtlsType.getReqId() == null || "".equals(clientDtlsType.getReqId().trim())) {
			throw new StmtSvcReqInvalidException("Req004", "Request Id is invalid");
		}
		// validating customer details
		CustomerDetailsType customerDtls = wsReq.getCustomerDetails();

		if (customerDtls.getCardnum() == null || "".equals(customerDtls.getCardnum().trim())) {
			throw new StmtSvcReqInvalidException("Req005", "Card number is invalid");
		}
		if (customerDtls.getCvvnum() == null || "".equals(customerDtls.getCvvnum().trim())) {
			throw new StmtSvcReqInvalidException("Req006", "Cvv number is invalid");
		}
		if (customerDtls.getExpdate() == null || "".equals(customerDtls.getExpdate().trim())) {
			throw new StmtSvcReqInvalidException("Req007", "Exp date  is invalid");
		}
		if (customerDtls.getNameoncard() == null || "".equals(customerDtls.getNameoncard().trim())) {
			throw new StmtSvcReqInvalidException("Req008", "Name on card  is invalid");
		}
		
		System.out.println("exit from validator ");

	}

}
