/* @CityBank 2018.All Rights are reserved.It is confidential
 * We should disclose this information outside.
 * Otherwise terms and conditions will apply.
 *  
 */
package com.citybank.statementdtls.service.validator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.service.util.StatementDtlsServiceUtilityTest;
import com.citybank.statementdtls.service.util.StatementReqInvalidException;

import junit.framework.Assert;

/**
 * @author Abhinav Jul 13, 2018
 * @Version 1.0
 */
public class StatementDtlsSvcReqValidatorTest {

	StatementDtlsSvcReqValidator validator = null;
	StatementDtlsReqType wsReq = null;

	@Before
	public void setUp() throws Exception {
		validator = new StatementDtlsSvcReqValidator();
		wsReq =StatementDtlsServiceUtilityTest.buildWSReq();
	}

	
	
	/**
	 * Test method for
	 * {@link com.citybank.statementdtls.service.validator.StatementDtlsSvcReqValidator#validate(com.citybank.statementdtls.schema.req.StatementDtlsReqType)}.
	 */
	@Test
	public void testValidateWSReqObj_Null() {
		wsReq=null;
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			assertEquals("stmt001", e.getErrorCode());
		}
	}

	@Test
	public void testValidateClientReqObj_Null() {
		wsReq.setClientDetails(null);
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			assertEquals("stmt001", e.getErrorCode());
		}
	}

	@Test
	public void testValidateCustomerReqObj_Null() {
		wsReq.setCustomerDetails(null);
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			assertEquals("stmt001", e.getErrorCode());
		}
	}

	@Test
	public void testValidateClientID_Null_senario() {
		wsReq.getClientDetails().setClientid(null);
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			assertEquals("stmt002", e.getErrorCode());
		}
	}

	@Test
	public void testValidateClientID_Empty_senario() {
		wsReq.getClientDetails().setClientid(" ");
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt002", e.getErrorCode());
		}
	}

	@Test
	public void testValidateChannelID_Null_senario() {
		wsReq.getClientDetails().setChannelid(null);
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt003", e.getErrorCode());
		}
	}

	@Test
	public void testValidateChannelID_Empty_senario() {
		wsReq.getClientDetails().setChannelid("");
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt003", e.getErrorCode());
		}
	}

	@Test
	public void testValidateReqid_Null_senario() {
		wsReq.getClientDetails().setReqid(null);
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt004", e.getErrorCode());
		}
	}
	
	@Test
	public void testValidateReqid_Empty_senario() {
		wsReq.getClientDetails().setReqid("");
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt004", e.getErrorCode());
		}
	}
	
	@Test
	public void testValidateCardNum_Null_senario() {
		wsReq.getCustomerDetails().setCardnum(null);
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt005", e.getErrorCode());
		}
	}
	@Test
	public void testValidateCardNum_Empty_senario() {
		wsReq.getCustomerDetails().setCardnum("");
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt004", e.getErrorCode());
		}
	}
	
	@Test
	public void testValidateCvvNum_Null_senario() {
		wsReq.getCustomerDetails().setCvvnum(null);
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt006", e.getErrorCode());
		}
	}
	@Test
	public void testValidateCvvNum_Empty_senario() {
		wsReq.getCustomerDetails().setCvvnum("");
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt006", e.getErrorCode());
		}
	}
	@Test
	public void testValidateExpDate_Null_senario() {
		wsReq.getCustomerDetails().setExpdate(null);
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt007", e.getErrorCode());
		}
	}
	@Test
	public void testValidateExpDate_Empty_senario() {
		wsReq.getCustomerDetails().setExpdate(null);
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt007", e.getErrorCode());
		}
	}
	@Test
	public void testValidateNameOnCard_Null_senario() {
		wsReq.getCustomerDetails().setNameoncard(null);
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt008", e.getErrorCode());
		}
	}
	@Test
	public void testValidateNameOnCard_Empty_senario() {
		wsReq.getCustomerDetails().setNameoncard("");
		try {
			validator.validateWSReq(wsReq);
		} catch (StatementReqInvalidException e) {
			Assert.assertNotNull(wsReq);
			assertEquals("stmt008", e.getErrorCode());
		}
	}
	@After
	public void tearDown() throws Exception {
		validator = null;
		wsReq = null;
	}
}
