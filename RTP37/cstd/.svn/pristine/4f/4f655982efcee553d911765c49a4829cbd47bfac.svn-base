/*package org.o2.registersvc.process.impl;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.o2.registersvc.creditcheck.CreditCheckSvcClient;
import org.o2.registersvc.creditcheck.beans.CreditCheckRequest;
import org.o2.registersvc.creditcheck.beans.CreditCheckResponse;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({RegisterSvcProcessImpl.class,CreditCheckSvcClient.class})
public class RegisterSvcProcessImplTest {

	RegisterSvcProcessImpl process=null;
	CreditCheckSvcClient mockCCSC=null;
	
	@Before
	public void setUp() throws Exception {
		process=new RegisterSvcProcessImpl();
		mockCCSC=PowerMockito.mock(CreditCheckSvcClient.class);
		PowerMockito.whenNew(CreditCheckSvcClient.class).withNoArguments().thenReturn(mockCCSC);
	}

	@Test
	public void testEnrollment() throws BussinessException, SystemException, UnknownException, SQLException, IOException {

     
     PowerMockito.when(mockCCSC.getCreditScore(Mockito.any(CreditCheckRequest.class))).thenReturn(buildccResp());
     RegisterSvcProcessVBRes VbResp = process.enrollment(buildVBReq());
     Assert.assertNotNull(VbResp);
     
	}
	
	
	public RegisterSvcProcessVBReq buildVBReq(){
		RegisterSvcProcessVBReq vbReq=new RegisterSvcProcessVBReq();
		vbReq.setAccountNum("123");
		vbReq.setCardNum("12345");
		vbReq.setChannelId("101");
		vbReq.setClientId("web");
		vbReq.setCvv("123");
		vbReq.setExpDate("10/35");
		vbReq.setMobileNum(889267);
		return vbReq;
	}
	
	
	public CreditCheckResponse buildccResp(){
		CreditCheckResponse vbRes=new CreditCheckResponse();
	
		vbRes.setRespCode("0000");
		vbRes.setRespMsg("sucess");
		vbRes.setScore(60.0f);
		vbRes.setStatus("good");
		return vbRes;
	}
	

}
*/