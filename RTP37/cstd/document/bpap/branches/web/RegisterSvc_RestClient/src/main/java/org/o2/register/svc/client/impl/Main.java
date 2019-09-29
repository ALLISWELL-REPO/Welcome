package org.o2.register.svc.client.impl;

import org.o2.register.svc.client.bean.RegisterSvcWebReq;
import org.o2.register.svc.client.bean.RegisterSvcWebRes;

public class Main {

	public static void main(String[] args) {
		RegisterSvcWebReq wsReq=new RegisterSvcWebReq();

		wsReq.setAccNumber("101");
		wsReq.setCardNum("521");
		wsReq.setChannelId("web");
		wsReq.setClientId("111");
		wsReq.setCvv("123");
		wsReq.setExpDate("10/36");
		wsReq.setMobileNum(8898877);
		wsReq.setNameOnCard("sonu");
		wsReq.setReqId("30");
		
		RegisterSvcClientImpl ClientImpl=new RegisterSvcClientImpl();
		RegisterSvcWebRes resp=ClientImpl.enrollment(wsReq);
		System.out.println(resp);
	}
		
	
}
