package com.keybank.cardstmttranssvc.service.impl;

import static org.junit.Assert.assertEquals;

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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.keybank.cardstmttranssvc.intg.util.BusinessException;
import com.keybank.cardstmttranssvc.intg.util.SystemException;
import com.keybank.cardstmttranssvc.process.CardStmtTransSvcProcess;
import com.keybank.cardstmttranssvc.process.impl.CardStmtTransSvcProcessImpl;
import com.keybank.cardstmttranssvc.process.valuebeans.CardStmtTransSvcProcessVBReq;
import com.keybank.cardstmttranssvc.process.valuebeans.CardStmtTransSvcProcessVBRes;
import com.keybank.cardstmttranssvc.process.valuebeans.TransactionProcess;
import com.keybank.cardstmttranssvc.service.builder.CardStmtTransSvcReqBuilder;
import com.keybank.cardstmttranssvc.service.builder.CardStmtTransSvcResBuilder;
import com.keybank.cardstmttranssvc.service.validator.CardStmtTransSvcValidator;
import com.keybank.cardstmttranssvc_req.schema.req.CardStmtTransReqType;
import com.keybank.cardstmttranssvc_req.schema.req.ClientContextType;
import com.keybank.cardstmttranssvc_req.schema.req.CustomerContextType;
import com.keybank.cardstmttranssvc_req.schema.req.DateRangeType;
import com.keybank.cardstmttranssvc_req.schema.req.ServiceDetailsType;
import com.keybank.cardstmttranssvc_resp.schema.resp.CardStmtTransRespType;
@RunWith(PowerMockRunner.class)
@PrepareForTest({CardStmtTransSvcProcess.class,
	CardStmtTransSvcImpl.class,ApplicationContext.class,
	AnnotationConfigApplicationContext.class,CardStmtTransSvcReqBuilder.class,
	CardStmtTransSvcValidator.class,CardStmtTransSvcResBuilder.class})
public class CardStmtTransSvcImplTest {
	AnnotationConfigApplicationContext mockannCtxt = null;
	CardStmtTransSvcImpl svcImpl = null;
	CardStmtTransReqType wsReq = null;
	CardStmtTransSvcProcess mockProcess = null;
	ApplicationContext mockContext  = null;
	CardStmtTransSvcProcessImpl mockProcessImpl = null;
	CardStmtTransSvcValidator mockValidator = null;
	CardStmtTransSvcReqBuilder mockReqBuilder = null;
	CardStmtTransSvcResBuilder mockRespBuilder = null;
	@Before
	public void setUp() throws Exception {
		svcImpl = new CardStmtTransSvcImpl();
		wsReq = buildWSReq();
		mockContext = PowerMockito.mock(ApplicationContext.class);
		mockannCtxt = PowerMockito.mock(AnnotationConfigApplicationContext.class);
		PowerMockito.whenNew(AnnotationConfigApplicationContext.class).withAnyArguments().thenReturn(mockannCtxt);
		
		mockReqBuilder = PowerMockito.mock(CardStmtTransSvcReqBuilder.class);
		PowerMockito.when(mockannCtxt.getBean(CardStmtTransSvcReqBuilder.class)).thenReturn(mockReqBuilder);
		PowerMockito.when(mockReqBuilder.buildVBReq(Matchers.any(CardStmtTransReqType.class))).thenCallRealMethod();
		mockRespBuilder = PowerMockito.mock(CardStmtTransSvcResBuilder.class);
		PowerMockito.when(mockannCtxt.getBean(CardStmtTransSvcResBuilder.class)).thenReturn(mockRespBuilder);
		PowerMockito.when(mockRespBuilder.buildWSRes(Matchers.any(CardStmtTransSvcProcessVBRes.class))).thenCallRealMethod();
		
		
       mockValidator = PowerMockito.mock(CardStmtTransSvcValidator.class);
		
		PowerMockito.when(mockannCtxt.getBean(CardStmtTransSvcValidator.class)).thenReturn(mockValidator);
		
		
		mockProcess = PowerMockito.mock(CardStmtTransSvcProcess.class);
		mockProcessImpl = PowerMockito.mock(CardStmtTransSvcProcessImpl.class);
		
		PowerMockito.when(mockannCtxt.getBean(CardStmtTransSvcProcessImpl.class)).thenReturn(mockProcessImpl);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testTransactions_Detaisl() throws BusinessException, SystemException {
		PowerMockito.when(mockProcessImpl.getTransactions(Matchers.any(CardStmtTransSvcProcessVBReq.class))).thenReturn(buildVBResp());
		
		CardStmtTransRespType wsresp = svcImpl.getTransactions(wsReq);
		System.out.println("wsresponse is :"+wsresp);
		assertEquals("000", wsresp.getStatusBlock().getRespCode());
		
	}
	
	@Test
	public void testTransactions_BusinessExce() throws BusinessException, SystemException {
		PowerMockito.when(mockProcessImpl.getTransactions(Matchers.any(CardStmtTransSvcProcessVBReq.class))).thenThrow(new BusinessException("100", "clientid invalid"));
		
		CardStmtTransRespType wsresp = svcImpl.getTransactions(wsReq);
		System.out.println("wsresponse is :"+wsresp);
		assertEquals("100", wsresp.getStatusBlock().getRespCode());
		
	}
	private CardStmtTransSvcProcessVBRes buildVBResp() {
		CardStmtTransSvcProcessVBRes vbResp = new CardStmtTransSvcProcessVBRes();
		vbResp.setRespCode("000");
		vbResp.setRespMsg("Success");
		List<TransactionProcess> transProcessList = new ArrayList<TransactionProcess>();
		TransactionProcess transProcess = new TransactionProcess();
		transProcess.setAmount("1000");
		transProcess.setDate("12-01-2018");
		transProcess.setDesc("good");
		transProcess.setMerchantName("Central");
		transProcess.setRewards("1000");
		transProcessList.add(transProcess);
				
		vbResp.setTransProcess(transProcessList);
		
		return vbResp;
	}

	private CardStmtTransReqType buildWSReq() {
		// prepare wsReq object
		CardStmtTransReqType wsReq = new CardStmtTransReqType();

		// Prepare ClientContext object
		ClientContextType clientContext = new ClientContextType();
		clientContext.setClientId("MOBILE");
		clientContext.setChannelId("ONLINE");
		clientContext.setReqId("RQ-1");

		// Prepare CustomerContext object
		CustomerContextType customerContext = new CustomerContextType();
		customerContext.setCardNum("1234567890");
		customerContext.setCvvNum("121");
		customerContext.setExpDate("12-2021");
		customerContext.setNameOnCard("PRAVEEN");

		// Prepare ServiceDetails objects
		ServiceDetailsType serviceDetails = new ServiceDetailsType();
		serviceDetails.setServiceName("CardStmtSvc");
		serviceDetails.setApiName("getTransactions(");
		serviceDetails.setVersion("1.0");

		// Prepare DateRange object
		DateRangeType dateRange = new DateRangeType();

		wsReq.setClientContext(clientContext);
		wsReq.setCustomerContext(customerContext);
		wsReq.setServiceDetails(serviceDetails);
		wsReq.setDateRange(dateRange);
		// Set TrnasactionType
		wsReq.setTransType("ALL");
		return wsReq;
	}

}
