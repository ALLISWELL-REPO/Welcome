package org.o2.register.svc.client.impl;

import org.o2.register.svc.client.bean.RegisterSvcWebReq;
import org.o2.register.svc.client.bean.RegisterSvcWebRes;

public class ClientCall {

	public static void main(String[] args) {
		RegisterSvcWebReq req=new RegisterSvcWebReq();
		req.setAccNumber("12345");
		req.setCardNum("12345");
		req.setChannelId("web");
		req.setClientId("121");
		req.setCvv("123");
		req.setExpDate("10/25");
		req.setMobileNum(546221);
		req.setNameOnCard("sonu");
		req.setReqId("111");
		
		RegisterSvcClientImpl clientImpl=new RegisterSvcClientImpl();
		RegisterSvcWebRes resp = clientImpl.enrollment(req);
		System.out.println(resp);
	}
	
	
}
