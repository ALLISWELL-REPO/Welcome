package com.keybank.cardstmttranssvc.intg.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import com.keybank.cardstmttranssvc.intg.beans.CardStmtTransSvcDAOReq;
import com.keybank.cardstmttranssvc.intg.beans.CardStmtTransSvcDAORes;
import com.keybank.cardstmttranssvc.intg.util.BusinessException;
import com.keybank.cardstmttranssvc.intg.util.SystemException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DriverManager.class,Connection.class,
	CallableStatement.class,ResultSet.class,CardStmtTransSvcDAOImpl.class})

public class CardStmtTransSvcDAOImplTest {

	CardStmtTransSvcDAOImpl daoImpl = null;
	Connection mockConn = null;
	CallableStatement mockcs = null;
	ResultSet mockRS = null;
	@Before
	public void setUp() throws Exception {
		
		daoImpl = new CardStmtTransSvcDAOImpl();
		PowerMockito.mockStatic(DriverManager.class);
		mockConn = PowerMockito.mock(Connection.class);
		PowerMockito.when(DriverManager.getConnection(Matchers.anyString(),Matchers.anyString(),Matchers.anyString())).thenReturn(mockConn);
		mockcs = PowerMockito.mock(CallableStatement.class);
		PowerMockito.when(mockConn.prepareCall(Matchers.anyString())).thenReturn(mockcs);
		mockRS = PowerMockito.mock(ResultSet.class);
		PowerMockito.when(mockcs.executeQuery()).thenReturn(mockRS);
		PowerMockito.when(mockRS.next()).thenReturn(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTransactions() throws BusinessException, SystemException, SQLException {
		
		PowerMockito.when(mockcs.getString(6)).thenReturn("0");
		
		
		PowerMockito.when(mockRS.getString("trans_Id")).thenReturn("12112");
		PowerMockito.when(mockRS.getString("amount")).thenReturn("1000");
		PowerMockito.when(mockRS.getString("date")).thenReturn("12-01-2018");
		PowerMockito.when(mockRS.getString("desc")).thenReturn("good");
		PowerMockito.when(mockRS.getString("merchantName")).thenReturn("reliance");
		PowerMockito.when(mockRS.getString("remark")).thenReturn("NA");
		PowerMockito.when(mockRS.getString("rewards")).thenReturn("10000");
		PowerMockito.when(mockRS.getString("status")).thenReturn("Delivered");
		
		
		CardStmtTransSvcDAOReq daoReq = new CardStmtTransSvcDAOReq();
		daoReq.setCardNum("121112112");
		daoReq.setCvv("123");
		daoReq.setClientId("web");
		daoReq.setChannelId("ONLINE");
		
		CardStmtTransSvcDAORes daoResp = daoImpl.getTransactions(daoReq);
		Assert.assertNotNull(daoResp);
		
	}

}
