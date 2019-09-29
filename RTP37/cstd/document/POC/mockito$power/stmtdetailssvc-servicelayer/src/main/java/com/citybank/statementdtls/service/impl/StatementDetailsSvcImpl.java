/* @CityBank 2018.All Rights are reserved.It is confidential
 * We should disclose this information outside.
 * Otherwise terms and conditions will apply.
 *  
 */
package com.citybank.statementdtls.service.impl;

import javax.jws.WebService;

import com.citybank.statementDtls.dao.util.BussinessException;
import com.citybank.statementDtls.dao.util.SystemException;
import com.citybank.statementDtls.process.StatementDtlsProcess;
import com.citybank.statementDtls.process.impl.StatementDtlsProcessImpl;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbResp;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.DateRangeType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.statementdtls.schema.resp.StatementDtlsRespType;
import com.citybank.statementdtls.schema.resp.StatusBlockType;
import com.citybank.statementdtls.service.StatementDetailsSvc;
import com.citybank.statementdtls.service.builder.StatementDtlsSvcReqBuilder;
import com.citybank.statementdtls.service.builder.StatementDtlsSvcRespBuilder;
import com.citybank.statementdtls.service.util.StatementReqInvalidException;
import com.citybank.statementdtls.service.validator.StatementDtlsSvcReqValidator;

/**
 * @author Abhinav
 *
 *         Jun 22, 2018
 */
@WebService(endpointInterface = "com.citybank.statementdtls.service.StatementDetailsSvc")
public class StatementDetailsSvcImpl implements StatementDetailsSvc {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.citybank.statementdtls.service.StatementDetailsSvc#getTransactions(
	 * com.citybank.statementdtls.schema.req.StatementDtlsReqType)
	 */

	public StatementDtlsRespType getTransactions(StatementDtlsReqType wsReq) {
		System.out.println("Enter into Service Layer..");
		// 1= get the req from client
		StatementDtlsRespType wsResp = null;
		try {
			// Validation
			StatementDtlsSvcReqValidator reqValidate = new StatementDtlsSvcReqValidator();
			reqValidate.validateWSReq(wsReq);

			// 2= prepare the req for process layer
			StatementDtlsSvcReqBuilder reqbuild = new StatementDtlsSvcReqBuilder();
			StatementDtlsProcessVbReq vbReq = reqbuild.processReqBuilder(wsReq);

			// 3= call the process
			StatementDtlsProcess process = new StatementDtlsProcessImpl();
			StatementDtlsProcessVbResp vbResp = process.getTransactions(vbReq);

			// 4= prepare the wsResp with the help of processResp i.e
			// convert
			// vbResp to wsResp
			StatementDtlsSvcRespBuilder respbuild = new StatementDtlsSvcRespBuilder();
			wsResp = respbuild.buildServiceResp(vbResp);
			System.out.println("Exit From Service Layer..");
			return wsResp;
		} catch (StatementReqInvalidException sre) {
			wsResp = new StatementDtlsRespType();
			StatusBlockType status = new StatusBlockType();
			status.setErrorCode(sre.getErrorCode());
			status.setErrorMsg(sre.getErrorMsg());
			wsResp.setStatusBlock(status);
		} catch (BussinessException be) {
			be.printStackTrace();
			wsResp = new StatementDtlsRespType();
			StatusBlockType stBlock = new StatusBlockType();
			stBlock.setErrorCode(be.getDbRespCode());
			stBlock.setErrorMsg(be.getDbRespMsg());
			wsResp.setStatusBlock(stBlock);
		} catch (SystemException se) {
			se.printStackTrace();
			wsResp = new StatementDtlsRespType();
			StatusBlockType stBlock = new StatusBlockType();
			stBlock.setErrorCode(se.getDbRespCode());
			stBlock.setErrorMsg(se.getDbRespMsg());
			wsResp.setStatusBlock(stBlock);
		}
		return wsResp;
	}

	public static void main(String[] args) {
		StatementDetailsSvcImpl svcImpl = new StatementDetailsSvcImpl();
		StatementDtlsReqType wsReq = new StatementDtlsReqType();
		ClientDetailsType clientDtls = new ClientDetailsType();
		clientDtls.setClientid(" web");
		clientDtls.setChannelid("online");
		clientDtls.setReqid("1212121");
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

		// call the Service method
		StatementDtlsRespType wsResp = svcImpl.getTransactions(wsReq);
		wsResp.getStatusBlock().getRespCode();
		wsResp.getStatusBlock().getRespMsg();
		wsResp.getTransDetails().getTransaction();
		System.out.println(wsResp.toString());
		System.out.println(wsResp.getStatusBlock().getRespCode());
		System.out.println(wsResp.getStatusBlock().getRespMsg());
		System.out.println(wsResp.getTransDetails().getTransaction().size());
	}
}
