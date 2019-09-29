package com.citybank.statementdtls.service.builder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.DateRangeType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;

public class StatementDtlsSvcReqBuilderTest {

	StatementDtlsSvcReqBuilder reqBuilder = null;
	StatementDtlsReqType wsReq = null;
	StatementDtlsProcessVbReq vbReq = null;

	@Before
	public void setUp() throws Exception {
		reqBuilder = new StatementDtlsSvcReqBuilder();
		wsReq = buildWsReq();
		vbReq = new StatementDtlsProcessVbReq();
	}

	private StatementDtlsReqType buildWsReq() {
		StatementDtlsReqType wsReq = new StatementDtlsReqType();
		ClientDetailsType clientDtls = new ClientDetailsType();
		clientDtls.setClientid("web");
		clientDtls.setChannelid("online ");
		clientDtls.setReqid("1212121 ");
		wsReq.setClientDetails(clientDtls);
		CustomerDetailsType custDetails = new CustomerDetailsType();
		custDetails.setCardnum("789456123789456");
		custDetails.setCvvnum("547");
		custDetails.setExpdate("08/2018");
		custDetails.setNameoncard("Abhinav");
		wsReq.setCustomerDetails(custDetails);

		TransCategoryType transCategory = new TransCategoryType();
		DateRangeType dateRange = new DateRangeType();
		// dateRange.setStartdate("");
		// dateRange.setEnddate("");
		transCategory.setDateRange(dateRange);
		transCategory.setTypeofcategory("ALL");
		wsReq.setTransCategory(transCategory);
		return wsReq;
	}

	@Test
	public void testProcessReqBuilderVbReqObject_NotNull_Sernario() {
		StatementDtlsProcessVbReq vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertNotNull(vbReq);
	}

	@Test
	public void testProcessReqBuilderClientId_Null_Sernario() {
		wsReq.getClientDetails().setClientid(null);
		StatementDtlsProcessVbReq vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getClientId());
	}

	@Test
	public void testProcessReqBuilderClientId_Empty_Sernario() {
		wsReq.getClientDetails().setClientid("");
		StatementDtlsProcessVbReq vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getClientId());
	}

	@Test
	public void testProcessReqBuilderChannelId_Null_Sernario() {
		wsReq.getClientDetails().setChannelid(null);
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getChannelId());
	}

	@Test
	public void testProcessReqBuilderChannelId_Empty_Sernario() {
		wsReq.getClientDetails().setChannelid("");
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getChannelId());
	}

	@Test
	public void testProcessReqBuilderCardNum_Null_Sernario() {
		wsReq.getCustomerDetails().setCardnum(null);
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getCardNum());
	}

	@Test
	public void testProcessReqBuilderCardNum_Empty_Sernario() {
		wsReq.getCustomerDetails().setCardnum("");
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getCardNum());
	}

	@Test
	public void testProcessReqBuilderCvv_Null_Sernario() {
		wsReq.getCustomerDetails().setCvvnum(null);
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getCvvnum());
	}

	@Test
	public void testProcessReqBuilderCvv_NotNull_Sernario() {
		wsReq.getCustomerDetails().setCvvnum("234");
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("234", vbReq.getCvvnum());
	}

	@Test
	public void testProcessReqBuilderCvv_Empty_Sernario() {
		wsReq.getCustomerDetails().setCvvnum("");
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getCvvnum());
	}

	@Test
	public void testProcessReqBuilderExpDate_Null_Sernario() {
		wsReq.getCustomerDetails().setExpdate(null);
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getExpDate());
	}

	@Test
	public void testProcessReqBuilderExpDate_NotNull_Sernario() {
		wsReq.getCustomerDetails().setExpdate("08-2018");
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("08-2018", vbReq.getExpDate());
	}

	@Test
	public void testProcessReqBuilderExpDate_Empty_Sernario() {
		wsReq.getCustomerDetails().setExpdate("");
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getExpDate());
	}

	@Test
	public void testProcessReqBuilderNameOncard_Null_Sernario() {
		wsReq.getCustomerDetails().setNameoncard(null);
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getNameOncard());
	}

	@Test
	public void testProcessReqBuilderNameOncard_NotNull_Sernario() {
		wsReq.getCustomerDetails().setNameoncard("Ravi");
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("Ravi", vbReq.getNameOncard());
	}

	@Test
	public void testProcessReqBuilderNameOncard_Empty_Sernario() {
		wsReq.getCustomerDetails().setNameoncard("");
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getNameOncard());
	}

	@Test
	public void testProcessReqBuilderTypeOfTransaction_Null_Sernario() {
		wsReq.getTransCategory().setTypeofcategory(null);
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getTypeOfcateg());
	}

	@Test
	public void testProcessReqBuilderTypeOfTransaction_NotNull_Sernario() {
		wsReq.getTransCategory().setTypeofcategory("Success");
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("Success", vbReq.getTypeOfcateg());
	}

	@Test
	public void testProcessReqBuilderTypeOfTransaction_Empty_Sernario() {
		wsReq.getTransCategory().setTypeofcategory("");
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getTypeOfcateg());
	}

	@Test
	public void testProcessReqBuilderStartDate_Null_Sernario() {
		wsReq.getTransCategory().getDateRange().setStartdate(null);
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getStartDate());
	}

	@Ignore
	@Test
	public void testProcessReqBuilderStartDate_Empty_Sernario() {
		wsReq.getTransCategory().getDateRange();
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getStartDate());
	}

	@Test
	public void testProcessReqBuilderEndDate_Null_Sernario() {
		wsReq.getTransCategory().getDateRange().setEnddate(null);
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getEndDate());
	}

	@Ignore
	@Test
	public void testProcessReqBuilderEndDate_Empty_Sernario() {
		wsReq.getTransCategory().getDateRange().setEnddate(null);
		vbReq = reqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getEndDate());
	}

	@After
	public void tearDown() throws Exception {
		reqBuilder = null;
		wsReq = null;
		vbReq = null;
	}
}
