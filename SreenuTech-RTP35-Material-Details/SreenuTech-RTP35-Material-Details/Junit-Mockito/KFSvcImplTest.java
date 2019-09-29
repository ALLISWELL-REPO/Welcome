/*
 * @CopyRights (C) 2014-2015 All Rights Reserved.
 * 
 * SREENU TECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sreenutech.test1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sreenutech.partner.kf.enroll.req.ClientInfoType;
import com.sreenutech.partner.kf.enroll.req.EnrollInfoType;
import com.sreenutech.partner.kf.enroll.req.KFSvcEnrollRequestType;
import com.sreenutech.partner.kf.enroll.res.KFSvcEnrollResponseType;
import com.st.process.kf.partner.KFSvcProcessorImpl;
import com.st.process.kf.partner.valuebeans.KFSvcProcessEnrollReqVB;
import com.st.process.kf.partner.valuebeans.KFSvcProcessEnrollResVB;
import com.st.service.kf.partner.exception1.KFSVCBusinessException;
import com.st.service.kf.partner.exception1.KFSVCServiceException;
import com.st.service.kf.partner.exception1.KFSvcSystemException;
import com.st.service.kf.partner.imp.KFSvcImpl;
import com.st.service.kf.partner.util.KFSvcInvalidDataException;
import com.st.service.kf.partner.validate.KFSvcValidate;

/**
 * @author sreenutech
 *
 */
public class KFSvcImplTest {
	
	private ClassPathXmlApplicationContext context;
	@Mock
	private KFSvcProcessorImpl processor;
	@Mock
	private KFSvcValidate validator;
	
	KFSvcImpl service = null;

	/**
	 * Description :
	 */
	@Before
	public void setUp() throws Exception {
		 service = new KFSvcImpl();
		
		
	}

	

	@Test
	public void testEnroll() throws KFSvcInvalidDataException, KFSVCBusinessException, KFSvcSystemException, KFSVCServiceException {
		Mockito.doNothing().when(validator).enrollReqValidate
		(Mockito.any(KFSvcEnrollRequestType.class));
		
		Mockito.when(
				processor.enroll(Mockito.any(KFSvcProcessEnrollReqVB.class)))
						.thenReturn(getVBResponse());	
		
		KFSvcEnrollResponseType wsresponse = service.enroll(getWSRequest());
		Assert.assertEquals("0000",wsresponse.getStatus().getResCode() );
	}



	/**
	 * Description :
	 */
	private KFSvcEnrollRequestType getWSRequest() {
		
		KFSvcEnrollRequestType wsrequest = new KFSvcEnrollRequestType();
		ClientInfoType ctype = new ClientInfoType();
		ctype.setChannelId("ONLINE");
		ctype.setClientId("SREENUTECH");
		ctype.setRequestId("12345");
		
		EnrollInfoType etype = new EnrollInfoType();
		etype.setFName("SREENU");
		etype.setLName("Tech");
		
		wsrequest.setClientInfo(ctype);
		wsrequest.setEnrollInfo(etype);
		return wsrequest;
	}



	/**
	 * Description :
	 */
	private KFSvcProcessEnrollResVB getVBResponse() {
		
		KFSvcProcessEnrollResVB vbresponse = new KFSvcProcessEnrollResVB();
		vbresponse.setPartnerNumber("123456");
		vbresponse.setResCode("0000");
		vbresponse.setResMessage("SUCCESS");
		
		return vbresponse;
	}

}
