package org.o2.registersvc.service.impl;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.process.impl.RegisterSvcProcessImpl;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.mockito.internal.invocation.MockitoMethodInvocationControl;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.exceptions.FieldNotFoundException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({RegisterServiceImpl.class,RegisterSvcProcessImpl.class})
public class RegisterServiceImplTest {

	RegisterServiceImpl svcImpl=null;
	RegisterSvcProcessImpl mockProcessImpl;
	RegisterServiceReqType wsReq;
	
	
	@Before
	public void setUp() throws Exception {
		svcImpl=new RegisterServiceImpl();
		wsReq=buildWSReq();
		//mock the processImpl
		mockProcessImpl=PowerMockito.mock(RegisterSvcProcessImpl.class);
		PowerMockito.whenNew(RegisterSvcProcessImpl.class).
		withNoArguments().thenReturn(mockProcessImpl);
		
	}

	@Test
	public void testEnrollment() throws FieldNotFoundException, BussinessException,SystemException,UnknownException {
		/*PowerMockito.when(mockProcessImpl.
		enrollment(PowerMockito.any(RegisterSvcProcessVBReq.class))).
		thenThrow(new BussinessException("1000", "invalide card"));*/

	}


	//prepare asResp
	public RegisterSvcProcessVBRes buildWSRes(){
		RegisterSvcProcessVBRes vbResp=new RegisterSvcProcessVBRes();
		vbResp.setRespCode("000");
		vbResp.setRespMsg("sucess");
		vbResp.setScore(60.0f);
		vbResp.setStatus("good");
		return null;
		
	}
	
	//prapare wsReq
	public RegisterServiceReqType buildWSReq() {

		RegisterServiceReqType wsReq = new         RegisterServiceReqType();

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
