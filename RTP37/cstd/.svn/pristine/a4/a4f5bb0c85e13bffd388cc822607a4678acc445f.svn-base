package org.o2.registersvc.service.builder;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;

public class RegisterSvcReqBuilderTest {

	RegisterSvcReqBuilder svcReqBuilder = null;
	RegisterServiceReqType wsReq = null;
	RegisterSvcProcessVBReq vbReq = null;
	
	@Before
	public void setUp() throws Exception {
		svcReqBuilder=new RegisterSvcReqBuilder();
		wsReq=new RegisterServiceReqType();
		vbReq=new RegisterSvcProcessVBReq();
	}

	
	@Test
	public void testBuildProcessRequest_vbReq_not_null() {
		
		
		Assert.assertNotNull(vbReq);
		wsReq=buildWSReq();
		
		vbReq=svcReqBuilder.buildProcessRequest(wsReq);
		Assert.assertEquals(vbReq.getAccountNum(), wsReq.getAccountDetails().getAccNumber());
		Assert.assertEquals(vbReq.getMobileNum(), wsReq.getAccountDetails().getMobNumber());
		
		Assert.assertEquals(vbReq.getChannelId(), wsReq.getClientDetails().getChannelId());
		Assert.assertEquals(vbReq.getClientId(), wsReq.getClientDetails().getClientId());
		
		Assert.assertEquals(vbReq.getCardNum(),wsReq.getCardDetails().getCardNum());
		Assert.assertEquals(vbReq.getCvv(),wsReq.getCardDetails().getCvv());
		Assert.assertEquals(vbReq.getExpDate(),wsReq.getCardDetails().getExpDate());
		Assert.assertEquals(vbReq.getNameOnCard(),wsReq.getCardDetails().getNameOnCard());
		
		
		
	}
	
	/*@Test
	public void testBuildProcessRequest_testAccNumber() {
	
		
	}
	
	@Test
	public void testBuildProcessRequest_testMobileNo() {
		wsReq=buildWSReq();
		vbReq=svcReqBuilder.buildProcessRequest(wsReq);
		Assert.assertEquals(vbReq.getMobileNum(), wsReq.getAccountDetails().getMobNumber());
	}*/

	
	
	
	
	
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
