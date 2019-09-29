package com.citybank.statementdtls.service.builder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.process.valuebeans.TransactionsProcess;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;

public class StatementDtlsSvcResBuilderTest {

	StatementDtlsSvcResBuilder resBuilder = null;
	StatementDtlsProcessVbRes vbResp = null;

	@Before
	public void setUp() throws Exception {
		resBuilder = new StatementDtlsSvcResBuilder();
		vbResp = buildVbResp();
	}

	@Test
	public void testLoadProcessVbResSucess() {
		StatementDtlsResType svcRes=resBuilder.resClientBuilder(vbResp);
		assertEquals("0000", svcRes.getStatusBlock().getReapcode());
	}
	@Test
	public void testLoadProcessNo_Transaction(){
		StatementDtlsResType svcRes=resBuilder.resClientBuilder(vbResp);
		svcRes.setTransDetails(null);
		assertEquals(null, svcRes.getTransDetails());
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
		resBuilder = null;
		vbResp = null;
	}

}
