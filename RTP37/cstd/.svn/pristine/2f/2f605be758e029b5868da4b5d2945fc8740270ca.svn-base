package com.citybank.statementdtls.service.builder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.DataRangeType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
public class StatementDtlsSvcReqBuilderTest {
	StatementDtlsSvcReqBuilder svcreqBuilder = null;
	StatementDtlsReqType wsReq = null;
	StatementDtlsProcessVbReq vbReq = null;
	
	@Before
	public void setUp() throws Exception {
		svcreqBuilder = new StatementDtlsSvcReqBuilder();
		wsReq = buildWsReq();
		vbReq = new StatementDtlsProcessVbReq();
	}

	@Test
	public void testProcessReqBuilderVbReqObject_NotNull_Sernario() {
		StatementDtlsProcessVbReq vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertNotNull(vbReq);
	}
	
	@Test
	public void testProcessReqBuilderClientId_Null_Sernario() {
		wsReq.getClientDetails().setClientid(null);
		StatementDtlsProcessVbReq vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getClientId());
	}
	
	
	@Test
	public void testProcessReqBuilderClientId_Empty_Sernario() {
		wsReq.getClientDetails().setClientid("");
		StatementDtlsProcessVbReq vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getClientId());
	}
	
	@Test
	public void testProcessReqBuilderChannelId_Null_Sernario() {
		wsReq.getClientDetails().setChannelid(null);
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getChannelId());
	}
	
	
	@Test
	public void testProcessReqBuilderChannelId_Empty_Sernario() {
		wsReq.getClientDetails().setChannelid("");
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getChannelId());
	}
	
	
	@Test
	public void testProcessReqBuilderCardNum_Null_Sernario() {
		wsReq.getCustomerDetails().setCardnum(null);
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getCardNum());
	}

	@Test
	public void testProcessReqBuilderCardNum_Empty_Sernario() {
		wsReq.getCustomerDetails().setCardnum("");
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getCardNum());
	}
	
	@Test
	public void testProcessReqBuilderCvv_Null_Sernario() {
		wsReq.getCustomerDetails().setCvvnum(null);
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getCvvNum());
	}
	
	
	@Test
	public void testProcessReqBuilderCvv_NotNull_Sernario() {
		wsReq.getCustomerDetails().setCvvnum("878");
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("878", vbReq.getCvvNum());
	}
	
	@Test
	public void testProcessReqBuilderCvv_Empty_Sernario() {
		wsReq.getCustomerDetails().setCvvnum("");
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getCvvNum());
		//Assert.assertNotEquals(0, vbReq.getCvvNum());
	}
	
	@Test
	public void testProcessReqBuilderExpDate_Null_Sernario() {
		wsReq.getCustomerDetails().setExpdate(null);
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getExpDate());
	}
	
	@Test
	public void testProcessReqBuilderExpDate_NotNull_Sernario() {
		wsReq.getCustomerDetails().setExpdate("09-08-2019");
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("09-08-2019", vbReq.getExpDate());
	}
	
	@Test
	public void testProcessReqBuilderExpDate_Empty_Sernario() {
		wsReq.getCustomerDetails().setExpdate("");
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getExpDate());
	}
	
	@Test
	public void testProcessReqBuilderNameOncard_Null_Sernario() {
		wsReq.getCustomerDetails().setNameoncard(null);
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getNameOnCard());
	}
	
	@Test
	public void testProcessReqBuilderNameOncard_NotNull_Sernario() {
		wsReq.getCustomerDetails().setNameoncard("ABCD");
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("ABCD", vbReq.getNameOnCard());
	}

	@Test
	public void testProcessReqBuilderNameOncard_Empty_Sernario() {
		wsReq.getCustomerDetails().setNameoncard("");
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getNameOnCard());
	}

	@Test
	public void testProcessReqBuilderTypeOfTransaction_Null_Sernario() {
		wsReq.getTransCategory().setTypeofcategory(null);
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getTypeOfCate());
	}
	
	@Test
	public void testProcessReqBuilderTypeOfTransaction_NotNull_Sernario() {
		wsReq.getTransCategory().setTypeofcategory("success");
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("success", vbReq.getTypeOfCate());
	}
	
	@Test
	public void testProcessReqBuilderTypeOfTransaction_Empty_Sernario() {
		wsReq.getTransCategory().setTypeofcategory("");
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals("", vbReq.getTypeOfCate());
	}
	
	@Test
	public void testProcessReqBuilderStartDate_Null_Sernario() {
		wsReq.getTransCategory().getDataRange().setStartdate(null);
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getStartDate());
	}

	
	@Test
	public void testProcessReqBuilderStartDate_Empty_Sernario() {
		wsReq.getTransCategory().getDataRange();
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getStartDate());
	}
	
	@Test
	public void testProcessReqBuilderEndDate_Null_Sernario() {
		wsReq.getTransCategory().getDataRange().setEnddate(null);
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getEndDate());
	}

	
	@Test
	public void testProcessReqBuilderEndDate_Empty_Sernario() {
		wsReq.getTransCategory().getDataRange().setEnddate(null);
		vbReq = svcreqBuilder.processReqBuilder(wsReq);
		Assert.assertEquals(null, vbReq.getEndDate());
	}
	private StatementDtlsReqType buildWsReq() {
		StatementDtlsReqType wsReq = new StatementDtlsReqType();
		ClientDetailsType clientDtls = new ClientDetailsType();
		clientDtls.setClientid("web");
		clientDtls.setChannelid("online ");
		clientDtls.setReqid("101010");
		wsReq.setClientDetails(clientDtls);
		
		CustomerDetailsType custDetails = new CustomerDetailsType();
		custDetails.setCardnum("578111000544594");
		custDetails.setCvvnum("878");
		custDetails.setExpdate("2018-09-09");
		custDetails.setNameoncard("ABCD");
		wsReq.setCustomerDetails(custDetails);

		TransCategoryType transCategory = new TransCategoryType();
		DataRangeType dateRange = new DataRangeType();
		 //dateRange.setStartdate("");
		//dateRange.setEnddate("");
		transCategory.setDataRange(dateRange);;
		transCategory.setTypeofcategory("ALL");
		wsReq.setTransCategory(transCategory);
		return wsReq;
	}

	@After
	public void tearDown() throws Exception {
		svcreqBuilder = null;
		wsReq = null;
		vbReq = null;
	}
}
