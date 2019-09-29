package com.citybank.statementdtls.service.validator;

import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.service.util.StatementDetailsRequestInvalidException;

@Component
public class StatementDtlsSvcReqValidator {

	public void validate(StatementDtlsReqType wsReq)
			throws StatementDetailsRequestInvalidException {

		if (wsReq == null || wsReq.getClientDetails() == null
				|| wsReq.getCustomerDetails() == null) {

			throw new StatementDetailsRequestInvalidException("stmt001",
					"All details required");
		}
		ClientDetailsType cientDtls = wsReq.getClientDetails();

		if (cientDtls.getClientid() == null
				|| "".equals(cientDtls.getClientid().trim())) {

			throw new StatementDetailsRequestInvalidException("client001",
					"Client id required");

		}
		if (cientDtls.getChannelid() == null
				|| "".equals(cientDtls.getChannelid().trim())) {

			throw new StatementDetailsRequestInvalidException("client002",
					"Channel id cn not be empty id required");

		}

		if (cientDtls.getReqid() == null
				|| "".equals(cientDtls.getReqid().trim())) {

			throw new StatementDetailsRequestInvalidException("client003",
					"Request id cn not be empty id required");

		}

		CustomerDetailsType customerDtls = wsReq.getCustomerDetails();

		if (customerDtls.getCardnum() == null
				|| "".equals(customerDtls.getCardnum().trim())) {

			throw new StatementDetailsRequestInvalidException("cust001",
					"Please enter card number");

		}

		if (customerDtls.getCvvnum() == null
				|| "".equals(customerDtls.getCvvnum().trim())) {

			throw new StatementDetailsRequestInvalidException("cust002",
					"CVV Number required");

		}

		if (customerDtls.getNameoncard() == null
				|| "".equals(customerDtls.getNameoncard().trim())) {

			throw new StatementDetailsRequestInvalidException("cust003",
					"name requires");

		}

		if (customerDtls.getExpdate() == null
				|| "".equals(customerDtls.getExpdate().trim())) {

			throw new StatementDetailsRequestInvalidException("cust004",
					"Enter the date");

		}

	}

}
