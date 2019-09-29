package com.citybank.statementdtls.service.builder;

import static org.junit.Assert.*;

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
import com.citybank.statementdtls.service.impl.StatementDtlsSvcImpl;

public class StatementDtlsSvcReqBuilderTest {
	private StatementDtlsReqType wsReq = null;
	private StatementDtlsSvcReqBuilder reqBuilder = null;
	StatementDtlsProcessVbReq vbReq = null;
	
	@Before
	public void setUp() throws Exception {
		wsReq = buildWSReq();
		reqBuilder = new StatementDtlsSvcReqBuilder();
	}

	@After
	public void tearDown() throws Exception {
		wsReq = null;
		reqBuilder = null;
		vbReq = null;
	}

	
	@Test
	public void testBuildVBReq() {
		vbReq = reqBuilder.processReqBuilder(wsReq);
		assertNotNull(vbReq);
		assertEquals(wsReq.getClientDetails().getClientid(),vbReq.getClientId());
		assertEquals(wsReq.getClientDetails().getChannelid(), vbReq.getChannelId());
		//assertEquals(wsReq.getClientDetails().getReqid(), vbReq);
		
		assertEquals(wsReq.getCustomerDetails().getCardnum(), vbReq.getCardNum());
		assertEquals(wsReq.getCustomerDetails().getCvvnum(),vbReq.getCvvNum());
		assertEquals(wsReq.getCustomerDetails().getExpdate(),vbReq.getExpDate());
		assertEquals(wsReq.getCustomerDetails().getNameoncard(),vbReq.getNameOnCard());
	}

	// Building wsReq
	private StatementDtlsReqType buildWSReq() {
		
		StatementDtlsSvcImpl svImpl = new StatementDtlsSvcImpl();
		
		// prepare wsReq object
		StatementDtlsReqType wsReq = new StatementDtlsReqType();

		// Prepare ClientDetails object
		ClientDetailsType clientDetails = new ClientDetailsType();
		clientDetails.setClientid("MOBILE");
		clientDetails.setChannelid("ONLINE");

		// Prepare CustomerDetails object
		CustomerDetailsType customerDetails = new CustomerDetailsType();
		customerDetails.setCardnum("1234567890");
		customerDetails.setCvvnum(121);
		customerDetails.setExpdate("27-2021");
		customerDetails.setNameoncard("Nishant");

		TransCategoryType transCategoryType=new TransCategoryType();
		

		// Prepare DateRange object
		DataRangeType dateRange = new DataRangeType();

		wsReq.setClientDetails(clientDetails);
		wsReq.setCustomerDetails(customerDetails);
		///wsReq.setServiceDetails(serviceDetails);
		//wsReq.setDateRange(dateRange);
		// Set TrnasactionType
		wsReq.getTransCategory().setTypeofcategory("All");
		return wsReq;
	}

}
