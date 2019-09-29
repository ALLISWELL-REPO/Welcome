package com.citybank.statementdtls.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.citybank.statementdetails.service.StatementDetails;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;
import com.citybank.statementdtls.process.StatementDtlsProcess;
import com.citybank.statementdtls.process.builder.StatementDtlsProcessResBuiler;
import com.citybank.statementdtls.process.impl.StatementDtlsProcessImpl;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.process.valuebeans.TransactionProcess;
import com.citybank.statementdtls.service.builder.StatementDtlsSvcReqBuilder;
import com.citybank.statementdtls.service.builder.StatementDtlsSvcResBuilder;
import com.citybank.statementdtls.service.util.StmtSvcReqInvalidException;
import com.citybank.statementdtls.service.validator.StatementDtlsSvcValidator;
import com.citybank.statementdtls_schema.req.ClientDetailsType;
import com.citybank.statementdtls_schema.req.CustomerDetailsType;
import com.citybank.statementdtls_schema.req.StatementDtlsReqType;
import com.citybank.statementdtls_schema.req.TransCategoryType;
import com.citybank.statementdtls_schema.resp.StatementDtlsResType;
import com.citybank.statementdtls_schema.resp.StatusBlockType;
import com.citybank.statementdtls_schema.resp.TransDetailsType;
import com.citybank.statementdtls_schema.resp.TrasactionType;

@WebService(endpointInterface = "com.citybank.statementdetails.service.StatementDetails")
public class StatementDetailsSvcImpl implements StatementDetails {

	public StatementDtlsResType getTrasactions(StatementDtlsReqType wsReq) {
		System.out.println("Enter into service layer");
		StatementDtlsResType wsRes = new StatementDtlsResType();
		try {
			// 1.get the request from the client
			// 2.validate the wsReq
			StatementDtlsSvcValidator serviceValidator = new StatementDtlsSvcValidator();
			serviceValidator.validateWsRequest(wsReq);
			// 2.prepare the request for process layer
			StatementDtlsSvcReqBuilder processVbBuilder = new StatementDtlsSvcReqBuilder();
			StatementDtlsProcessVbReq vbReq = processVbBuilder.buildProcessVbRequest(wsReq);
			// 3. call the process
			StatementDtlsProcess process = new StatementDtlsProcessImpl();
			StatementDtlsProcessVbRes vbRes;
			vbRes = process.getTrasactions(vbReq);
			// System.out.println(vb.ge);
			// Now prepare process value bean response to wsres bean response
			StatementDtlsSvcResBuilder wsResBuilder = new StatementDtlsSvcResBuilder();
			wsRes = wsResBuilder.buildWsResponse(vbRes);
			
		} catch (BusinessException be) {
			System.out.println("Enter into Business exception");
			StatusBlockType blockType = new StatusBlockType();
			blockType.setRespCode(be.getErrorCode());
			blockType.setRespMsg(be.getErrorMsg());
			wsRes.setStatusBlock(blockType);
			be.printStackTrace();
		} catch (SystemException se) {
			System.out.println("Enter into SystemException");
			StatusBlockType blockType = new StatusBlockType();
			blockType.setRespCode(se.getErrorCode());
			blockType.setRespMsg(se.getErrorMsg());
			se.printStackTrace();
			wsRes.setStatusBlock(blockType);
		} catch (StmtSvcReqInvalidException sre) {
			StatusBlockType statusBlockType = new StatusBlockType();
			statusBlockType.setRespCode(sre.getErrorCode());
			statusBlockType.setRespMsg(sre.getErrorMsg());
			wsRes.setStatusBlock(statusBlockType);
			sre.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("enter into ClassNotFoundException catch block in service");
			StatusBlockType statusBlockType = new StatusBlockType();
			statusBlockType.setRespCode("2000");
			statusBlockType.setRespMsg("class not found exception");
			wsRes.setStatusBlock(statusBlockType);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("enter into SQLException catch block in service");
			StatusBlockType statusBlockType = new StatusBlockType();
			statusBlockType.setRespCode("2001");
			statusBlockType.setRespMsg("sql  exception");
			wsRes.setStatusBlock(statusBlockType);
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("enter into Exception catch block in service 1");
			StatusBlockType statusBlockType = new StatusBlockType();
			statusBlockType.setRespCode("2002");
			statusBlockType.setRespMsg("Unknown exception");
			wsRes.setStatusBlock(statusBlockType);
			e.printStackTrace();
		}
		// System.out.println("service List
		// "+wsRes.getTransDetails().getTrasaction().size());
		System.out.println("Exit from service layer");
		return wsRes;
	}

	public static void main(String[] args) {
		StatementDetailsSvcImpl svcImpl = new StatementDetailsSvcImpl();

		// Create WsReq Object
		StatementDtlsReqType reqType = new StatementDtlsReqType();

		ClientDetailsType clientDetailsType = new ClientDetailsType();
		clientDetailsType.setClientId("web");
		clientDetailsType.setChannelId("online");
		clientDetailsType.setReqId("514324");

		CustomerDetailsType customerDetailsType = new CustomerDetailsType();
		customerDetailsType.setCardnum("4590050000032147");
		customerDetailsType.setCvvnum("514");
		customerDetailsType.setExpdate("2018-04-03");
		customerDetailsType.setNameoncard("sunny");

		// TransCategoryType transCategoryType = new TransCategoryType();

		// transCategoryType.getDateRange().setStartDate("01-04-2018");
		// transCategoryType.getDateRange().setEndDate("01-06-2018");
		// transCategoryType.setTypeOfCategory("full");
		reqType.setClientDetails(clientDetailsType);
		reqType.setCustomerDetails(customerDetailsType);
		// reqType.setTransCategory(transCategoryType);

		// call service method
		System.out.println("hi");
		StatementDtlsResType wsResp = svcImpl.getTrasactions(reqType);
		System.out.println("bye");
		System.out.println(wsResp.getStatusBlock().getRespCode());
		System.out.println(wsResp.getStatusBlock().getRespMsg());
		// System.out.println("service List
		// hi"+wsResp.getTransDetails().getTrasaction().size());
		// System.out.println(wsResp.getStatusBlock().getErrorCode());
		// System.out.println(wsResp.getStatusBlock().getRespCode());
		// System.out.println(wsResp.getStatusBlock().getRespMsg());
		// System.out.println(wsResp.getTransDetails().getTrasaction().get(1).getAmout());

	}

}
