package com.citybank.statementdtls.service.validator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.DataRangeType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.statementdtls.service.impl.StatementDtlsSvcImpl;
import com.citybank.statementdtls.service.util.StatementReqInvalidException;
import com.citybank.statementdtls.service.validator.StatementDtlsSvcReqValidator;

public class StatementDtlsSvcReqValidatorTest {
	StatementDtlsSvcReqValidator validator = null;
	StatementDtlsReqType wsReq = null;

	@Before
	public void setUp() throws Exception {
		// create validator object
		validator = new StatementDtlsSvcReqValidator();
		// create wsReq Object
		wsReq = buildWsReq();
	}

	@Test
	public void testValidate_WSREQ_NULL_Scenario() {
		try {
			validator.validate(null);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt001", e.getErrorCode());
			// Assert.assertEquals("Request object is null", e.getErrorMsg());
		}

	}

	// ClientDetails_NULL_Scenario
	@Test
	public void testValidate_ClientDetails_NULL_Scenario() {
		wsReq.setClientDetails(null);
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt001", e.getErrorCode());
		}
	}

	// CustomerDetails_NULL_Scenario
	@Test
	public void testValidate_CustomerDetails_NULL_Scenario() throws Exception {
		wsReq.setCustomerDetails(null);
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt001", e.getErrorCode());
		}

	}

	// ClientId_NULL_Scenario
	@Test
	public void testValidate_ClientId_NULL_Scenario() {
		wsReq.getClientDetails().setClientid(null);
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt002", e.getErrorCode());
			Assert.assertEquals("ClientId is invalid", e.getErrorMsg());
		}
	}

	// ClientId_Empty_Scenario
	@Test
	public void testValidate_ClientId_Empty_Scenario() {
		wsReq.getClientDetails().setClientid(" ");
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt002", e.getErrorCode());
		}
	}

	// ChannelId_NULL_Scenario
	@Test
	public void testValidate_ChannelId_NULL_Scenario() {
		wsReq.getClientDetails().setChannelid(null);
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt003", e.getErrorCode());
			// Assert.assertEquals("ClientId is invalid", e.getErrorMsg());
		}
	}

	// ChannelId_Empty_Scenario
	@Test
	public void testValidate_ChannelId_Empty_Scenario() {
		wsReq.getClientDetails().setChannelid(" ");
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt003", e.getErrorCode());
		}
	}

	// CardNum_NULL_Scenario
	@Test
	public void testValidate_Card_Num_NULL_Scenario() {
		wsReq.getCustomerDetails().setCardnum(null);
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt004", e.getErrorCode());
		}
	}

	// CardNum_Empty_Scenario
	@Test
	public void testValidate_Card_Num_Empty_Scenario() {
		wsReq.getCustomerDetails().setCardnum(" ");
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt004", e.getErrorCode());
		}
	}

	// Cvv_int 0(zero)_Scenario
	@Test
	public void testValidate_Cvv_int_0_Scenario() {
		wsReq.getCustomerDetails().setCvvnum(0);
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt005", e.getErrorCode());
		}
	}

	// NameOnCard_Null_Scenario
	@Test
	public void testValidate_NameOnCard_Null_Scenario() {
		wsReq.getCustomerDetails().setNameoncard(null);
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt006", e.getErrorCode());
		}
	}

	// NameOnCard_Empty_Scenario
	@Test
	public void testValidate_NameOnCard_Empty_Scenario() {
		wsReq.getCustomerDetails().setNameoncard("");
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt006", e.getErrorCode());
		}
	}

	// Exp_Date_Null_Scenario
	@Test
	public void testValidate_Exp_Date_Null_Scenario() {
		wsReq.getCustomerDetails().setExpdate(null);
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt007", e.getErrorCode());
		}
	}

	// Exp_Date_Empty_Scenario
	@Test
	public void testValidate_Exp_Date_Empty_Scenario() {
		wsReq.getCustomerDetails().setExpdate("");
		try {
			validator.validate(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertEquals("stmt007", e.getErrorCode());
		}
	}

	@After
	public void tearDown() throws Exception {
		validator = null;
		wsReq = null;
	}

	private StatementDtlsReqType buildWsReq() {
		
		StatementDtlsSvcImpl svImpl = new StatementDtlsSvcImpl();
		// prepare wsReq object
		StatementDtlsReqType wsReq = new StatementDtlsReqType();

		// prepare ClientDetails Object
		ClientDetailsType clientDtlType = new ClientDetailsType();
		clientDtlType.setClientid(" ");
		clientDtlType.setChannelid("online");
		clientDtlType.setReqid("Req1D11");

		// prepare CustomerDetails Object
		CustomerDetailsType customerDetailsType = new CustomerDetailsType();
		customerDetailsType.setCardnum("576111000888978");
		customerDetailsType.setCvvnum(345);
		customerDetailsType.setExpdate("02-10-2014");
		customerDetailsType.setNameoncard("ashish");

		// prepare Transaction category object
		TransCategoryType transCategoryType = new TransCategoryType();
		// transCategoryType.setTypeofcategory("ALL");
		// prepare DateRange Object
		DataRangeType dateType = new DataRangeType();
		// dateType.setStartdate("01-05-2018");
		// dateType.setEnddate("01-07-2018");

		// both are same
		// transCategoryType.getDataRange().setStartdate("01-05-2018");
		// transCategoryType.getDataRange().setEndDate("01-07-2018");
		wsReq.setClientDetails(clientDtlType);
		wsReq.setCustomerDetails(customerDetailsType);
		// reqType.setTransCategory(transCategoryType);
		// reqType.getClientDetails().setClientid("111");
		// call the service method

		return wsReq;
	}

}
