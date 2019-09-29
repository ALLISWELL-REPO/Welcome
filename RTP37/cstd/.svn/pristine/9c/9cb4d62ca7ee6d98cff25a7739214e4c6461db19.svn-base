package org.o2.registersvc.intg.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ System.class, RegisterSvcDAOImpl.class, DriverManager.class, CallableStatement.class })

public class RegisterSvcDAOImplTest {

	RegisterSvcDAOImpl daoImpl = null;
	Connection mockConnection = null;
	CallableStatement mockCsStmt = null;

	@Before
	public void setUp() throws Exception {
		daoImpl = new RegisterSvcDAOImpl();
		mockConnection = PowerMockito.mock(Connection.class);
		PowerMockito.mockStatic(System.class);
		PowerMockito.mockStatic(DriverManager.class);
		mockCsStmt = PowerMockito.mock(CallableStatement.class);
	}

	@Test
	public void testEnrollment() throws BussinessException, SystemException, UnknownException, SQLException {

		RegisterSvcDAOReq daoReq = buildDAOReq();
		PowerMockito.when(System.getProperty(Mockito.anyString())).thenReturn("dev");
		PowerMockito.when(DriverManager.getConnection(Matchers.anyString(), Matchers.anyString(), Matchers.anyString()))
				.thenReturn(mockConnection);
		PowerMockito.when(mockConnection.prepareCall(Mockito.anyString())).thenReturn(mockCsStmt);
		PowerMockito.when(mockCsStmt.execute()).thenReturn(true);
		PowerMockito.when(mockCsStmt.getString(9)).thenReturn("0000");
		PowerMockito.when(mockCsStmt.getString(10)).thenReturn("success");
		RegisterSvcDAORes daoResp = daoImpl.enrollment(daoReq);
		Assert.assertNotNull(daoResp);
	}

	private RegisterSvcDAOReq buildDAOReq() {

		// prepare the daoReq
		RegisterSvcDAOReq daoReq = new RegisterSvcDAOReq();
		daoReq.setAccountNum("123");
		daoReq.setCardNum("123456");
		daoReq.setChannelId("web");
		daoReq.setClientId("101");
		daoReq.setCvv("123");
		daoReq.setExpDate("10/34");
		daoReq.setMobileNum(88926768);
		daoReq.setNameOnCard("sonu");
		return daoReq;

	}
	
	
	
}
