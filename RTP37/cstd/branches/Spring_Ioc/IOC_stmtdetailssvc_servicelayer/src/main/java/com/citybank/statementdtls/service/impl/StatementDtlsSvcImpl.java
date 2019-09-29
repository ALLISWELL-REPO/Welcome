package com.citybank.statementdtls.service.impl;

import java.sql.SQLException;

import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;
import com.citybank.statementdtls.process.StatementDtlsProcess;
import com.citybank.statementdtls.process.impl.StatementDtlsProcessImpl;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.schema.res.StatusBlockType;
import com.citybank.statementdtls.service.StatementDetailsSvc;
import com.citybank.statementdtls.service.builder.StatementDtlsSvcReqBuilder;
import com.citybank.statementdtls.service.builder.StatementDtlsSvcResBuilder;
import com.citybank.statementdtls.service.util.StatementReqInvalidException;
import com.citybank.statementdtls.service.validator.StatementDtlsSvcReqValidator;

@WebService(endpointInterface = "com.citybank.statementdtls.service.StatementDetailsSvc")
public class StatementDtlsSvcImpl implements StatementDetailsSvc {

	//StatementDtlsProcessVbRes vbResp = null;
	StatementDtlsSvcReqValidator validator=null;
	StatementDtlsSvcReqBuilder svcReqBuilder=null;
	StatementDtlsSvcResBuilder svcRespBuilder=null;
	StatementDtlsProcess process=null;
	
	public StatementDtlsResType getTransactions(StatementDtlsReqType wsReq) {
		System.out.println("Enter into service layer");
		
		ApplicationContext context=new AnnotationConfigApplicationContext(StatementSvcConfig.class);
		validator=context.getBean(StatementDtlsSvcReqValidator.class);
		svcReqBuilder=context.getBean(StatementDtlsSvcReqBuilder.class);
		svcRespBuilder=context.getBean(StatementDtlsSvcResBuilder.class);
		process=context.getBean(StatementDtlsProcess.class);
		
		// TODO Auto-generated method stub
		// 1.get the req form client
		// 2.prepare the req from process layer
		// validation

		validator = new StatementDtlsSvcReqValidator();
		StatementDtlsResType wsRes = new StatementDtlsResType();
		try {
			validator.validate(wsReq);

			// prepare the request from the process
			StatementDtlsSvcReqBuilder reqSvcBuilder = new StatementDtlsSvcReqBuilder();
			StatementDtlsProcessVbReq vbreq = reqSvcBuilder.processReqBuilder(wsReq);

			// call the process
		 
			// StatementDtlsProcessVbRes vbResp;

			StatementDtlsProcessVbRes vbResp = process.getTransactions(vbreq);

			// prepare the SvcRes,ie.convert vbRes to SvcRes
			StatementDtlsSvcResBuilder resSvcBuilder = new StatementDtlsSvcResBuilder();
			wsRes = resSvcBuilder.resClientBuilder(vbResp);

		} catch (StatementReqInvalidException stReq) {
			StatusBlockType statusBlock = new StatusBlockType();
			System.out.println("Enter into ReqInvalid Layer");
			statusBlock.setErrorcode(stReq.getErrorCode());
			statusBlock.setErrormsg(stReq.getErrorMsg());
			wsRes.setStatusBlock(statusBlock);
			//stReq.printStackTrace();
			return wsRes;
		} catch (BusinessException bs) {
			StatusBlockType statusBlock = new StatusBlockType();
			System.out.println("Enter into Business Layer");
			statusBlock.setErrorcode(bs.getDbErrorCode());
			statusBlock.setErrormsg(bs.getDbErrorMsg());
			wsRes.setStatusBlock(statusBlock);
			System.out.println("error code" + bs.getDbErrorCode());
			//bs.printStackTrace();
			return wsRes;

		} catch (SystemException se) {
			StatusBlockType statusBlock = new StatusBlockType();
			System.out.println("Enter into System Layer");
			statusBlock.setErrorcode(se.getSysErrorCode());
			statusBlock.setErrormsg(se.getSysErrorMsg());
			wsRes.setStatusBlock(statusBlock);
			System.out.println("error code" + se.getSysErrorCode());
			//se.printStackTrace();
			return wsRes;
		} catch (ClassNotFoundException ce) {
			StatusBlockType statusBlock = new StatusBlockType();
			statusBlock.setErrorcode("2001");
			statusBlock.setErrormsg("Enter into class not found Exception");
			wsRes.setStatusBlock(statusBlock);
			//ce.printStackTrace();
		} catch (SQLException se) {

			StatusBlockType statusBlock = new StatusBlockType();
			statusBlock.setErrorcode("2002");
			statusBlock.setErrormsg("Enter into SQL Exception");
			wsRes.setStatusBlock(statusBlock);
			//se.printStackTrace();
		}
		return wsRes;

	}

	public static void main(String[] args) {
		StatementDtlsSvcImpl svImpl = new StatementDtlsSvcImpl();
		// create wsReq object
		StatementDtlsReqType reqType = new StatementDtlsReqType();
		ClientDetailsType clientDtlType = new ClientDetailsType();
		clientDtlType.setClientid("Flipkart");
		clientDtlType.setChannelid("online");
		clientDtlType.setReqid("Req1D11");

		CustomerDetailsType customerDetailsType = new CustomerDetailsType();
		customerDetailsType.setCardnum("576111000888978");
		customerDetailsType.setCvvnum("345");
		customerDetailsType.setExpdate("2019-01-02");
		customerDetailsType.setNameoncard("ashish");

		TransCategoryType transCategoryType = new TransCategoryType();
		// transCategoryType.getDataRange().setStartdate("01-05-2018");
		// transCategoryType.getDataRange().setEndDate("01-07-2018");
		reqType.setClientDetails(clientDtlType);
		reqType.setCustomerDetails(customerDetailsType);
		// reqType.setTransCategory(transCategoryType);
		// reqType.getClientDetails().setClientid("111");
		// call the service method
		StatementDtlsResType wsResp = svImpl.getTransactions(reqType);
		System.out.println(wsResp.getStatusBlock().getReapcode());
		System.out.println(wsResp.getStatusBlock().getRespmsg());

	}

}
