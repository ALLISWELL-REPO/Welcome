package org.o2.registersvc.intg.impl;

import java.io.IOException;
import java.sql.SQLException;

import org.o2.registersvc.integration.config.IntgSpringConfig;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) throws IOException {
		ApplicationContext context=new AnnotationConfigApplicationContext(IntgSpringConfig.class);
		//RegisterSvcDAOImpl_Springjdbc dao=(RegisterSvcDAOImpl_Springjdbc) context.getBean(RegisterSvcDAOImpl_Springjdbc.class);
		RegisterSvcDAOImpl_Springjdbc dao=context.getBean(RegisterSvcDAOImpl_Springjdbc.class);
		//System.out.println("Dao "+dao);
		
		RegisterSvcDAOReq req=new RegisterSvcDAOReq();
		req.setAccountNum("1232");//ACC_NUMB
		req.setCardNum("2344");
		req.setChannelId("web");//CHANNEL_ID
		req.setClientId("101");//CLIENT_ID
		req.setCvv("654");
		req.setExpDate("10/36");
		req.setMobileNum(321);//MOB_NUMB
		req.setNameOnCard("sonu");
		
		
		
		try {
			dao.enrollment(req);
			
		} catch (BussinessException e) {
			
			
		} catch (SystemException e) {
			
			
		} catch (UnknownException e) {
			
			
		} catch (SQLException e) {
			
			
		}
	
	}
	
	
	
}
