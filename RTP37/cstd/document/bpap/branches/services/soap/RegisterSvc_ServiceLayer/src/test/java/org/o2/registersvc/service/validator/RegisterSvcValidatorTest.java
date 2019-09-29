package org.o2.registersvc.service.validator;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.service.util.RegisterSvcReqInvalid;

public class RegisterSvcValidatorTest {

	RegisterServiceReqType wsReq = null;
	RegisterSvcValidator validator = null;

	@Before
	public void setUp() throws Exception {
		validator = new RegisterSvcValidator();
		wsReq = buildWSReq();
	}

	@After
	public void tearDown() throws Exception {
		validator = null;
		wsReq = null;
	}

	// test RegisterRequestType object
	@Test
	public void testValidatewsReq_for_Object() {
		wsReq = null;

		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02001", e.getRespCode());
		}

	}

	// test ClientDetailsType object
	@Test
	public void testValidatewsReq_for_clientDetailsType() {
		wsReq.setClientDetails(null);

		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02001", e.getRespCode());
		}

	}

	// test clientId for empty
	@Test
	public void testValidatewsReq_for_clientId_Empty() {
		wsReq.getClientDetails().setClientId(" ");

		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02002", e.getRespCode());
		}

	}
	
	// test clientId for empty null
	@Test
	public void testValidatewsReq_for_clientId_Null() {
		wsReq.getClientDetails().setClientId(null);

		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02002", e.getRespCode());
		}

	}

	// test channelID for empty
	@Test
	public void testValidatewsReq_for_channelId_Empty() {
		wsReq.getClientDetails().setChannelId(" ");

		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02003", e.getRespCode());
		}

	}
	
	// test channelID for null
		@Test
		public void testValidatewsReq_for_channelId_Null() {
			wsReq.getClientDetails().setChannelId(null);

			try {
				validator.validatewsReq(wsReq);
			} catch (RegisterSvcReqInvalid e) {
				Assert.assertEquals("02003", e.getRespCode());
			}

		}

	// test method for object AccountDetailsType object
	@Test
	public void testValidatewsReq_for_accountDetailsType() {
		wsReq.setAccountDetails(null);
		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02001", e.getRespCode());
		}

	}

	// test account number for empty
	@Test
	public void testValidatewsReq_for_accountNumber_Empty() {
		wsReq.getAccountDetails().setAccNumber(" ");

		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02004", e.getRespCode());
		}

	}
	
	// test account number for null
		@Test
		public void testValidatewsReq_for_accountNumber_Null() {
			wsReq.getAccountDetails().setAccNumber(null);

			try {
				validator.validatewsReq(wsReq);
			} catch (RegisterSvcReqInvalid e) {
				Assert.assertEquals("02004", e.getRespCode());
			}

		}

	// test mobile no for empty or null

	@Test
	public void testValidatewsReq_for_mobileNumber_Empty() {
		wsReq.getAccountDetails().setMobNumber(0);

		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02005", e.getRespCode());
		}

	}

	
	
	// test  cardDetailsType object
	@Test
	public void testValidatewsReq_for_cardDetailsType() {
		wsReq.setCardDetails(null);

		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02001", e.getRespCode());
		}

	}

	
	//test card number for empty
	@Test
	public void testValidatewsReq_for_cardNumber_Empty() {
		wsReq.getCardDetails().setCardNum(" ");

		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02006", e.getRespCode());
		}

	}

	
	//test card number for null
		@Test
		public void testValidatewsReq_for_cardNumber_Null() {
			wsReq.getCardDetails().setCardNum(null);

			try {
				validator.validatewsReq(wsReq);
			} catch (RegisterSvcReqInvalid e) {
				Assert.assertEquals("02006", e.getRespCode());
			}

		}
	
	//test cvv number for empty  
	@Test
	public void testValidatewsReq_for_cvv_Empty() {
		wsReq.getCardDetails().setCvv(" ");

		try {
			validator.validatewsReq(wsReq);
		} catch (RegisterSvcReqInvalid e) {
			Assert.assertEquals("02007", e.getRespCode());
		}

	}
	
	//test cvv number for null  
		@Test
		public void testValidatewsReq_for_cvv_Null() {
			wsReq.getCardDetails().setCvv(null);

			try {
				validator.validatewsReq(wsReq);
			} catch (RegisterSvcReqInvalid e) {
				Assert.assertEquals("02007", e.getRespCode());
			}

		}
		
	
	//test expDate number for empty 
		@Test
		public void testValidatewsReq_for_expDate_Empty() {
			wsReq.getCardDetails().setExpDate(" ");

			try {
				validator.validatewsReq(wsReq);
			} catch (RegisterSvcReqInvalid e) {
				Assert.assertEquals("02008", e.getRespCode());
			}

		}
		
		//test for expDate  for null 
				@Test
				public void testValidatewsReq_for_expDate_Null() {
					wsReq.getCardDetails().setExpDate(null);

					try {
						validator.validatewsReq(wsReq);
					} catch (RegisterSvcReqInvalid e) {
						Assert.assertEquals("02008", e.getRespCode());
					}

				}
		
		//test for nameOnCard for empty
		@Test
		public void testValidatewsReq_for_nameOnCard_Empty() {
			wsReq.getCardDetails().setNameOnCard(" ");

			try {
				validator.validatewsReq(wsReq);
			} catch (RegisterSvcReqInvalid e) {
				Assert.assertEquals("02009", e.getRespCode());
			}

		}
	
		//test for nameOnCard for null
		@Test
		public void testValidatewsReq_for_nameOnCard_Null() {
			wsReq.getCardDetails().setNameOnCard(null);

			try {
				validator.validatewsReq(wsReq);
			} catch (RegisterSvcReqInvalid e) {
				Assert.assertEquals("02009", e.getRespCode());
			}

		}
	
	
	
	public RegisterServiceReqType buildWSReq() {

		RegisterServiceReqType wsReq = new RegisterServiceReqType();

		// create AccountDetailaType
		AccountDetailsType acc = new AccountDetailsType();
		acc.setAccNumber("255445");
		acc.setMobNumber(152455);

		CardDetailsType card = new CardDetailsType();
		card.setCardNum("2584874");
		card.setCvv("123");
		card.setExpDate("05/12");
		card.setNameOnCard("sonu");

		ClientDetailsType client = new ClientDetailsType();
		client.setChannelId("120");
		client.setClientId("256");

		wsReq.setAccountDetails(acc);
		wsReq.setCardDetails(card);
		wsReq.setClientDetails(client);
		return wsReq;
	}

}
