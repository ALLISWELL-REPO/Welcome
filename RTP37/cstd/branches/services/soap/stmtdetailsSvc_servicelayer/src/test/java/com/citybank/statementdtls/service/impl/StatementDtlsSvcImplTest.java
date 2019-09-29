/* @CityBank 2018.All Rights are reserved.It is confidential
 * We should disclose this information outside.
 * Otherwise terms and conditions will apply.
 *  
 */
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
import com.citybank.statementdtls.process.valuebeans.TransactionsProcess;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.service.util.StatementDtlsServiceUtilityTest;

 @RunWith(PowerMockRunner.class)
 @PrepareForTest({ StatementDtlsSvcImpl.class })

public class StatementDtlsSvcImplTest {

	StatementDtlsSvcImpl svcImpl = null;
	StatementDtlsReqType wsReq = null;
	StatementDtlsProcessImpl mockProcessImpl = null;

	@Before
	public void setUp() throws Exception {
		svcImpl = new StatementDtlsSvcImpl();
		wsReq = StatementDtlsServiceUtilityTest.buildWSReq();
		mockProcessImpl = PowerMockito.mock(StatementDtlsProcessImpl.class);
		PowerMockito.whenNew(StatementDtlsProcessImpl.class).withNoArguments().thenReturn(mockProcessImpl);
	}

	
	@Test
	public void testGetTransactions() throws ClassNotFoundException, BusinessException, SystemException, SQLException  {
		PowerMockito.when(mockProcessImpl.getTransactions(Matchers.any(StatementDtlsProcessVbReq.class))).thenReturn(buildVbResp());
		StatementDtlsResType wsResp = svcImpl.getTransactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("0000", wsResp.getStatusBlock().getReapcode());
	}
	@Test
	public void test_Transaction_BusinessException() throws ClassNotFoundException, BusinessException, SystemException, SQLException{
		PowerMockito.when(mockProcessImpl.getTransactions(Matchers.any(StatementDtlsProcessVbReq.class))).thenThrow(new BusinessException("100", "cleintid invalid"));
		StatementDtlsResType wsRes=svcImpl.getTransactions(wsReq);
		assertNotNull(wsRes);
		assertEquals("100", wsRes.getStatusBlock().getErrorcode());
	}
	@Test
	public void test_Trasaction_SysteException() throws ClassNotFoundException, BusinessException, SystemException, SQLException{
		  PowerMockito.when(mockProcessImpl.getTransactions(Matchers.any(StatementDtlsProcessVbReq.class))).thenThrow(new SystemException("101", "thisis SystemException"));
			StatementDtlsResType wsRes=svcImpl.getTransactions(wsReq);
			assertNotNull(wsRes);
			assertEquals("101", wsRes.getStatusBlock().getErrorcode());
	}

	
	private StatementDtlsProcessVbRes buildVbResp() {
		
		System.out.println("Enterd into mock VbResp.");
		StatementDtlsProcessVbRes vbResp = new StatementDtlsProcessVbRes();
		vbResp.setRespCode("0000");
		vbResp.setRespMsg("success");
		List<TransactionsProcess> transProcesslist = new ArrayList<TransactionsProcess>();
		TransactionsProcess transprocess = new TransactionsProcess();
		transprocess.setId("777888");
		transprocess.setDate("01-05-2018");
		transprocess.setAmount("9000");
		transprocess.setDesc("good");
		transprocess.setMerchantname("Flipkart");
		transprocess.setStatus("success");
		transprocess.setRemarks("NA");
		transProcesslist.add(transprocess);
		vbResp.setTransProcess(transProcesslist);
		return vbResp;
	}

	
	@After
	public void tearDown() throws Exception {
		svcImpl = null;
		wsReq = null;
		mockProcessImpl = null;
	}

}
