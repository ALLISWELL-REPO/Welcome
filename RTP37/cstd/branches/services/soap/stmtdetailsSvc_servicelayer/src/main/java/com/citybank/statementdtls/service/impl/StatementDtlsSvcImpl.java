package com.citybank.statementdtls.service.impl;

import java.sql.SQLException;

import javax.jws.WebService;

import org.apache.log4j.Logger;

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
	private static final String CLASS_NAME="StatementDtlsSvcImpl";
	private Logger logger = Logger.getLogger(StatementDtlsSvcImpl.class);

	public StatementDtlsResType getTransactions(StatementDtlsReqType wsReq) {
		String methodName="getTransactions";
		String version="1";
		long timetaken;
		String typeOfError="S";
		String errorCode="0000";
		String errorMsg="Success";
		String contextPath="";
		String dateTime="";
		
		long startTime=System.currentTimeMillis();
		
		logger.debug("Enter into service layer");
		// 1.get the req form client
		// 2.prepare the req from process layer
		// validation
		logger.debug("start validation");
		StatementDtlsSvcReqValidator validator = new StatementDtlsSvcReqValidator();
		StatementDtlsResType wsRes = new StatementDtlsResType();
		try {
			validator.validate(wsReq);

			// prepare the request from the process
			StatementDtlsSvcReqBuilder reqSvcBuilder = new StatementDtlsSvcReqBuilder();
			StatementDtlsProcessVbReq vbreq = reqSvcBuilder.processReqBuilder(wsReq);

			// call the process
			StatementDtlsProcess process = new StatementDtlsProcessImpl();
			// StatementDtlsProcessVbRes vbResp;

			StatementDtlsProcessVbRes vbResp = process.getTransactions(vbreq);

			// prepare the SvcRes,ie.convert vbRes to SvcRes
			StatementDtlsSvcResBuilder resSvcBuilder = new StatementDtlsSvcResBuilder();
			wsRes = resSvcBuilder.resClientBuilder(vbResp);

		} catch (StatementReqInvalidException stReq) {
			typeOfError="Invalid_Exception";
			errorCode=stReq.getErrorCode();
			errorMsg=stReq.getErrorMsg();
			
			StatusBlockType statusBlock = new StatusBlockType();
			statusBlock.setErrorcode(errorCode);
			statusBlock.setErrormsg(errorMsg);
			wsRes.setStatusBlock(statusBlock);
			logger.error(stReq.getErrorCode(),stReq );
			return wsRes;
		} catch (BusinessException bs) {
			typeOfError="Business_Exception";
			errorCode=bs.getDbErrorCode();
			errorMsg=bs.getDbErrorMsg();
			
			StatusBlockType statusBlock = new StatusBlockType();
			statusBlock.setErrorcode(errorCode);
			statusBlock.setErrormsg(errorMsg);
			wsRes.setStatusBlock(statusBlock);
			logger.error(bs.getDbErrorCode(),bs);
			return wsRes;

		} catch (SystemException se) {
			typeOfError="System_Exception";
			errorCode=se.getSysErrorCode();
			errorMsg=se.getSysErrorMsg();
			
			StatusBlockType statusBlock = new StatusBlockType();
			statusBlock.setErrorcode(errorCode);
			statusBlock.setErrormsg(errorMsg);
			wsRes.setStatusBlock(statusBlock);
			logger.error(se.getSysErrorCode(),se);
			return wsRes;
		} catch (ClassNotFoundException ce) {
			typeOfError="ClassNotFound_Exception";
			errorCode="2001";
			errorMsg="Enter into class not found Exception";
			
			StatusBlockType statusBlock = new StatusBlockType();
			statusBlock.setErrorcode(errorCode);
			statusBlock.setErrormsg(errorMsg);
			wsRes.setStatusBlock(statusBlock);
			logger.error("u got ClassNotFound Exception",ce);

		} catch (SQLException se) {
			typeOfError="System_Exception";
			errorCode="2002";
			errorMsg="Enter into SQL Exception";

			StatusBlockType statusBlock = new StatusBlockType();
			statusBlock.setErrorcode(errorCode);
			statusBlock.setErrormsg(errorMsg);
			wsRes.setStatusBlock(statusBlock);
			logger.error("u got SqlException Exception",se);
			
		}catch(Exception e){
			logger.fatal("u got fatal Exception",e);
		}
		finally {
			String clientId="XXXXXXXXX"+wsReq.getClientDetails().getClientid();
			String channelId=wsReq.getClientDetails().getChannelid();
			String ReqId=wsReq.getClientDetails().getReqid();
			String cardNum=wsReq.getCustomerDetails().getCardnum().substring(10, 15);
			long endTime=System.currentTimeMillis();
			timetaken=startTime-endTime;
			
			StringBuffer sbf=new StringBuffer();
			sbf.append(dateTime).append("|")
			.append(CLASS_NAME).append("|")
			.append(contextPath).append("|")
			.append(methodName).append("|")
			.append(version).append("|")
			.append(clientId).append("|")
			.append(channelId).append("|")
			.append(ReqId).append("|")
			.append(cardNum).append("|")
			.append(timetaken).append("|")
			.append(typeOfError).append("|")
			.append(errorCode).append("|")
			.append(errorMsg).append("|");                                 
			
			
		}
		logger.debug("Exit from Service layer");
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
		customerDetailsType.setExpdate("02-10-2014");
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
