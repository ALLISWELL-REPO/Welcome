package org.o2.registersvc.process.impl;

import java.io.IOException;
import java.sql.SQLException;

import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.springconfig.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) throws BussinessException, SystemException, UnknownException, SQLException, IOException {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
	
		RegisterSvcProcessImpl processimpl=ctx.getBean(RegisterSvcProcessImpl.class);
		RegisterSvcProcessVBReq vbreq=new RegisterSvcProcessVBReq();
		
		
		vbreq.setAccountNum("123");//ACC_NUMB
		vbreq.setCardNum("2344");
		vbreq.setChannelId("web");//CHANNEL_ID
		vbreq.setClientId("101");//CLIENT_ID
		vbreq.setCvv("654");
		vbreq.setExpDate("10/36");
		vbreq.setMobileNum(321);//MOB_NUMB
		vbreq.setNameOnCard("sonu");
		
		
		System.out.println(processimpl.enrollment(vbreq));
	}
}
