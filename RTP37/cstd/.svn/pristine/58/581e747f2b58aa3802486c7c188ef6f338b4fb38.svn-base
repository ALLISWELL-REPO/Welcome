/* @CityBank 2018.All Rights are reserved.It is confidential
 * We should disclose this information outside.
 * Otherwise terms and conditions will apply.
 *  
 */
package com.citybank.statementdtls.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import com.citybank.statementDtls.dao.util.BussinessException;
import com.citybank.statementDtls.dao.util.SystemException;
import com.citybank.statementDtls.process.impl.StatementDtlsProcessImpl;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbResp;
import com.citybank.statementDtls.process.valuebeans.TransactionsProcess;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.resp.StatementDtlsRespType;
import com.citybank.statementdtls.service.util.StatementDtlsServiceUtilityTest;

/**
 * @author stech9 Jul 24, 2018
 * @Version
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ StatementDetailsSvcImpl.class })
public class StatementDetailsSvcImplTest {

	StatementDetailsSvcImpl svcImpl = null;
	StatementDtlsReqType wsReq = null;
	StatementDtlsProcessImpl mockProcessImpl = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		svcImpl = new StatementDetailsSvcImpl();
		wsReq = StatementDtlsServiceUtilityTest.buildWSReq();
		mockProcessImpl = PowerMockito.mock(StatementDtlsProcessImpl.class);
		PowerMockito.whenNew(StatementDtlsProcessImpl.class).withNoArguments().thenReturn(mockProcessImpl);
	}

	/**
	 * Test method for
	 * {@link com.citybank.statementdtls.service.impl.StatementDetailsSvcImpl#getTransactions(com.citybank.statementdtls.schema.req.StatementDtlsReqType)}.
	 * 
	 * @throws SystemException
	 * @throws BussinessException
	 */
	@Test
	public void testGetTransactions() throws BussinessException, SystemException {
		PowerMockito.when(mockProcessImpl.getTransactions(Matchers.any(StatementDtlsProcessVbReq.class)))
				.thenReturn(buildVbResp());
		StatementDtlsRespType wsResp = svcImpl.getTransactions(wsReq);
		assertNotNull(wsResp);
		assertEquals("000", wsResp.getStatusBlock().getRespCode());
	}

	/**
	 * @return
	 */
	private StatementDtlsProcessVbResp buildVbResp() {
		System.out.println("Enterd into mock VbResp.");
		StatementDtlsProcessVbResp vbResp = new StatementDtlsProcessVbResp();
		vbResp.setRespCode("000");
		vbResp.setRespMsg("Success");
		List<TransactionsProcess> transProcesslist = new ArrayList<TransactionsProcess>();
		TransactionsProcess transprocess = new TransactionsProcess();
		transprocess.setId("12121");
		transprocess.setDate("01-05-2018");
		transprocess.setAmount("1000");
		transprocess.setDesc("good");
		transprocess.setMerchantname("Central");
		transprocess.setStatus("Success");
		transprocess.setRemarks("NA");
		transProcesslist.add(transprocess);
		vbResp.setTransProcess(transProcesslist);
		return vbResp;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		svcImpl = null;
		wsReq = null;
		mockProcessImpl = null;
	}

}
