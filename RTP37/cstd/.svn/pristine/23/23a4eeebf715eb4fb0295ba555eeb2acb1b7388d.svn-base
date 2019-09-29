package org.o2.registersvc.process.impl;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.Context;

import org.o2.register.process.springconfig.ProcessSpringConfig;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProcessMain {

	
	
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(ProcessSpringConfig.class);
		RegisterSvcProcessImpl process=context.getBean(RegisterSvcProcessImpl.class);
		RegisterSvcProcessVBReq vbreq=new RegisterSvcProcessVBReq();
		
		vbreq.setAccountNum("123");//ACC_NUMB
		vbreq.setCardNum("2344");
		vbreq.setChannelId("web");//CHANNEL_ID
		vbreq.setClientId("101");//CLIENT_ID
		vbreq.setCvv("654");
		vbreq.setExpDate("10/36");
		vbreq.setMobileNum(321);//MOB_NUMB
		vbreq.setNameOnCard("sonu");
		try {
			process.enrollment(vbreq);
		} catch (BussinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
