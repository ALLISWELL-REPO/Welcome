package org.o2.registersvc.intg.impl;

import java.sql.SQLException;

import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;

public class Main {

	public static void main(String[] args) {
		

		RegisterSvcDAOReq daoreq=new RegisterSvcDAOReq();
		
		daoreq.setAccountNum("123");
		daoreq.setCardNum("564");
		daoreq.setChannelId("web");
		daoreq.setClientId("101");
		daoreq.setCvv("123");
		daoreq.setExpDate("10/23");
		daoreq.setMobileNum(321);
		daoreq.setNameOnCard("sonu");
		
		RegisterSvcDAOImpl dao=new RegisterSvcDAOImpl();
		try {
			RegisterSvcDAORes daoresp = dao.enrollment(daoreq);
			//System.out.println(daoresp.getDaoRespCode());
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
		}
		
	}

}
