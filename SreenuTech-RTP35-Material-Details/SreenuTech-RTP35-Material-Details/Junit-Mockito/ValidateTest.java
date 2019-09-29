package com.sreenutech.test1;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;

import com.sreenutech.partner.kf.enroll.req.AddressType;
import com.sreenutech.partner.kf.enroll.req.ClientInfoType;
import com.sreenutech.partner.kf.enroll.req.EnrollInfoType;
import com.sreenutech.partner.kf.enroll.req.KFSvcEnrollRequestType;
import com.st.service.kf.partner.imp.KFSvcImpl;
import com.st.service.kf.partner.util.KFSvcEnumException;
import com.st.service.kf.partner.util.KFSvcInvalidDataException;
import com.st.service.kf.partner.validate.KFSvcValidate;

public class ValidateTest {

	 @Test
	public void testValidatemethod() throws DatatypeConfigurationException {

		 KFSvcImpl kfsvcimpl=new KFSvcImpl();

		KFSvcValidate kfsvalidate = new KFSvcValidate();

		KFSvcEnrollRequestType wsreq = new KFSvcEnrollRequestType();

		ClientInfoType cinfo = new ClientInfoType();
		cinfo.setClientId(null);
		cinfo.setRequestId("11");
		cinfo.setChannelId("tyr");
		

		wsreq.setClientInfo(cinfo);
		EnrollInfoType einfotype=new EnrollInfoType();
		einfotype.setFName("hh");
		einfotype.setLName("dddd");
		einfotype.setTitle("haaa");
		einfotype.setGender("male");
		einfotype.setEmailId("k@gmail.com");
		
		AddressType addre=new AddressType();
		addre.setAddressLine1("hyd");
		einfotype.setAddress(addre);
		einfotype.setMob(1111);

		einfotype.setPinCode(3344);
		
		String mydatetime = "2011-09-29";
		
		XMLGregorianCalendar xgc = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(mydatetime);
		//einfotype.setDob(xgc);
	einfotype.setDob(xgc);
	einfotype.setCardNumber("debit");
	einfotype.setCity("hyd");
	einfotype.setState("Ap");
	einfotype.	setCountry("india");
	einfotype.	setTypeOfCard("sss");
	einfotype.setPreferedLanguage("telugu");
	wsreq.setEnrollInfo(einfotype);
		
	
	
		// System.out.println(wsreq.getClientInfo().getChannelId());

		try {
			kfsvalidate.enrollReqValidate(wsreq);
		} catch (KFSvcInvalidDataException e) {

			KFSvcEnumException enumex = e.getEnumException();
			System.out.println(enumex.getRespCode());
			junit.framework.Assert.assertEquals("KF001", enumex.getRespCode());
		}

	}
}