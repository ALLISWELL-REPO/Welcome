package com.citybank.statementdtls.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;
import com.citybank.statementdtls.process.impl.StatementDtlsProcessImpl;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.process.valuebeans.TransactionProcess;
import com.citybank.statementdtls.service.util.StatementDtlsReqUtil;
import com.citybank.statementdtls_schema.req.StatementDtlsReqType;
import com.citybank.statementdtls_schema.resp.StatementDtlsResType;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StatementDetailsSvcImpl.class, StatementDtlsProcessImpl.class })
public class StatementDetailsSvcImplTest {
	StatementDetailsSvcImpl svcImpl = null;
	StatementDtlsReqType wsReq = null;
	StatementDtlsProcessImpl processMock = null;

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp()");
		svcImpl = new StatementDetailsSvcImpl();
		
		wsReq = StatementDtlsReqUtil.buildWsReq();
	
		processMock = PowerMockito.mock(StatementDtlsProcessImpl.class);
		PowerMockito.whenNew(StatementDtlsProcessImpl.class).withAnyArguments().thenReturn(processMock);
	}

	// checking validator class
	 @Test
	public void testGetTrasactions_StmtSvcReqInvalidException_WebReqNull()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into StmtSvcReqInvalidException");
		wsReq = null;

		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("Req001", wsResp.getStatusBlock().getRespCode());
	}

	 @Test
	public void testGetTrasactions_StmtSvcReqInvalidException_ClientDetailsNull()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into StmtSvcReqInvalidException");
		wsReq.setClientDetails(null);

		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("Req001", wsResp.getStatusBlock().getRespCode());
	}

	 @Test
	public void testGetTrasactions_StmtSvcReqInvalidException_Client_ChannelId()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into StmtSvcReqInvalidException");
		wsReq.getClientDetails().setChannelId(null);

		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("Req002", wsResp.getStatusBlock().getRespCode());
	}

	 @Test
	public void testGetTrasactions_StmtSvcReqInvalidException_Client_ClientId()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into StmtSvcReqInvalidException");
		wsReq.getClientDetails().setClientId(null);

		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("Req003", wsResp.getStatusBlock().getRespCode());
	}

	 @Test
	public void testGetTrasactions_StmtSvcReqInvalidException_Client_ReqId()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into StmtSvcReqInvalidException");
		wsReq.getClientDetails().setReqId(null);

		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("Req004", wsResp.getStatusBlock().getRespCode());
	}
	// customer details checking

	@Test
	public void testGetTrasactions_StmtSvcReqInvalidException_CustomerDetails_Null()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into StmtSvcReqInvalidException");
		wsReq.setCustomerDetails(null);

		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("Req001", wsResp.getStatusBlock().getRespCode());
	}

	 @Test
	public void testGetTrasactions_StmtSvcReqInvalidException_CustomerDetails_Cardnum()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into StmtSvcReqInvalidException");
		wsReq.getCustomerDetails().setCardnum(null);

		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("Req005", wsResp.getStatusBlock().getRespCode());
	}

	 @Test
	public void testGetTrasactions_StmtSvcReqInvalidException_CustomerDetails_Cvvnum()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into StmtSvcReqInvalidException");
		wsReq.getCustomerDetails().setCvvnum(null);

		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("Req006", wsResp.getStatusBlock().getRespCode());
	}

	 @Test
	public void testGetTrasactions_StmtSvcReqInvalidException_CustomerDetails_Expdate()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into StmtSvcReqInvalidException");
		wsReq.getCustomerDetails().setExpdate(null);

		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("Req007", wsResp.getStatusBlock().getRespCode());
	}

	 @Test
	public void testGetTrasactions_StmtSvcReqInvalidException_CustomerDetails_Nameoncard()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into StmtSvcReqInvalidException");
		wsReq.getCustomerDetails().setNameoncard(null);

		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("Req008", wsResp.getStatusBlock().getRespCode());
	}

	// with transaction
	 @Test
	public void testGetTrasactionsWithTrans()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into testGetTrasactions()");
		PowerMockito.when(processMock.getTrasactions(Matchers.any(StatementDtlsProcessVbReq.class)))
				.thenReturn(buildResponse());
		StatementDtlsResType resType = svcImpl.getTrasactions(wsReq);
		System.out.println("resType--->" + resType);
		assertNotNull(resType);
		assertEquals("000", resType.getStatusBlock().getRespCode());
		System.out.println("size of list " + resType.getTransDetails().getTrasaction().size());
		assertEquals(2, resType.getTransDetails().getTrasaction().size());

	}

	// without transaction
	 @Test
	public void testGetTrasactionsWithOutTrans()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		System.out.println("enter into testGetTrasactions()");
		PowerMockito.when(processMock.getTrasactions(Matchers.any(StatementDtlsProcessVbReq.class)))
				.thenReturn(buildResponseNoTrans());
		StatementDtlsResType resType = svcImpl.getTrasactions(wsReq);
		System.out.println("resType--->" + resType);
		assertNotNull(resType);
		assertEquals("000", resType.getStatusBlock().getRespCode());
		System.out.println("size of list " + resType.getTransDetails().getTrasaction().size());
		assertEquals(0, resType.getTransDetails().getTrasaction().size());

	}

	// checking business exception
	 @Test
	public void testGetTrasactions_BusinessException()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		PowerMockito.when(processMock.getTrasactions(Matchers.any(StatementDtlsProcessVbReq.class)))
				.thenThrow(new BusinessException("100", "card number involid"));
		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("100", wsResp.getStatusBlock().getRespCode());
	}

	// checking System Exception
	 @Test
	public void testGetTrasactions_SystemException()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		PowerMockito.when(processMock.getTrasactions(Matchers.any(StatementDtlsProcessVbReq.class)))
				.thenThrow(new SystemException("5555", "Unknow System exception"));
		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("5555", wsResp.getStatusBlock().getRespCode());
		assertEquals("Unknow System exception", wsResp.getStatusBlock().getRespMsg());
	}

	// checking ClassNotFoundException
	 @Test
	public void testGetTrasactions_ClassNotFoundException()
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		PowerMockito.when(processMock.getTrasactions(Matchers.any(StatementDtlsProcessVbReq.class)))
				.thenThrow(new ClassNotFoundException());
		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("2000", wsResp.getStatusBlock().getRespCode());
		assertEquals("class not found exception", wsResp.getStatusBlock().getRespMsg());
	}

	// checking SQLException
	 @Test
	public void SQLException() throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		PowerMockito.when(processMock.getTrasactions(Matchers.any(StatementDtlsProcessVbReq.class)))
				.thenThrow(new SQLException());
		StatementDtlsResType wsResp = svcImpl.getTrasactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("2001", wsResp.getStatusBlock().getRespCode());
		assertEquals("sql  exception", wsResp.getStatusBlock().getRespMsg());
	}

	@Test
	public void ExceptionChecking()
			throws ClassNotFoundException, BusinessException, SystemException, java.sql.SQLException {
		PowerMockito.when(processMock.getTrasactions(Matchers.any(StatementDtlsProcessVbReq.class)))
				.thenThrow(new NullPointerException());
		StatementDtlsResType resType = svcImpl.getTrasactions(wsReq);
		assertNotNull(resType);
		assertEquals("2002", resType.getStatusBlock().getRespCode());
	}

	private StatementDtlsProcessVbRes buildResponse() {
		StatementDtlsProcessVbRes processVbRes = new StatementDtlsProcessVbRes();

		TransactionProcess transProcess = new TransactionProcess();
		transProcess.setAmount("1000");
		transProcess.setDate("2018-06-24");
		transProcess.setDesc("goog");
		transProcess.setId("1111");
		transProcess.setMerchantName("zomoto");
		transProcess.setName("arun");
		transProcess.setRemarks("N/A");
		transProcess.setStatus("success");

		TransactionProcess transProcess2 = new TransactionProcess();
		transProcess2.setAmount("2000");
		transProcess2.setDate("2018-06-12");
		transProcess2.setDesc("goog");
		transProcess2.setId("1111");
		transProcess2.setMerchantName("paytm");
		transProcess2.setName("arun");
		transProcess2.setRemarks("N/A");
		transProcess2.setStatus("fail");

		List<TransactionProcess> transList = new ArrayList<>();
		transList.add(transProcess);
		transList.add(transProcess2);

		processVbRes.setRespCode("000");
		processVbRes.setRespMsg("success");
		processVbRes.setTransProcess(transList);

		return processVbRes;
	}

	private StatementDtlsProcessVbRes buildResponseNoTrans() {
		StatementDtlsProcessVbRes processVbRes = new StatementDtlsProcessVbRes();
		List<TransactionProcess> transList = new ArrayList<>();

		processVbRes.setRespCode("000");
		processVbRes.setRespMsg("success");
		processVbRes.setTransProcess(transList);

		return processVbRes;
	}

	@After
	public void tearDown() throws Exception {
	}
}
