package org.o2.register.svc.builder;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.o2.register.svc.client.beans.RegisterSvcWebReq;

public class RegisterServletReqBuilder {

	public RegisterSvcWebReq buildWebReq(HttpServletRequest req) {
		
		RegisterSvcWebReq webReq=new RegisterSvcWebReq();
		
		webReq.setCardNum(req.getParameter("CardNumber"));
		webReq.setCvv(req.getParameter("cvvNumber"));
		webReq.setExpDate(req.getParameter("expDate"));
		webReq.setNameOnCard(req.getParameter("nameOnCard"));
		
		webReq.setMobileNum(Long.valueOf(req.getParameter("mobileNumber")));
	    webReq.setAccNumber("12542");
		
	    webReq.setClientId("online");
	    webReq.setChannelId("web");
	    webReq.setReqId(UUID.randomUUID().toString());
	    
		return webReq;
	}

}
