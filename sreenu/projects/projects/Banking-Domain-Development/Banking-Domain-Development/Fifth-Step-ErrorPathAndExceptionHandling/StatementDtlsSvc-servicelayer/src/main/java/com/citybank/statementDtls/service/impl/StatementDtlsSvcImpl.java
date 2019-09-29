package com.citybank.statementDtls.service.impl;

import javax.jws.WebService;

import com.citybank.statementDtls.dao.util.BusinessException;
import com.citybank.statementDtls.dao.util.SystemException;
import com.citybank.statementDtls.process.StatementDtlsProcess;
import com.citybank.statementDtls.process.impl.StatementDtlsProcessImpl;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementDtls.service.builder.StatementDtlsResBuilder;
import com.citybank.statementDtls.service.builder.StatementDtlsSvcReqBuilder;
import com.citybank.statementDtls.service.util.StatementDetailsRequestInvalidException;
import com.citybank.statementDtls.service.validator.StatementDtlsSvcReqValidator;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.statementdtls.schema.res.StatementDtlsRespType;
import com.citybank.statementdtls.schema.res.StatusBlockType;
import com.citybank.statementdtls.service.StatementDetailsService;

@WebService(endpointInterface = "com.citybank.statementdtls.service.StatementDetailsService")
public class StatementDtlsSvcImpl implements StatementDetailsService {

	public StatementDtlsRespType getTransactions(StatementDtlsReqType wsreq) {

		StatementDtlsRespType wsResp = null;

		try {

			StatementDtlsSvcReqValidator validator = new StatementDtlsSvcReqValidator();
			validator.validate(wsreq);

			StatementDtlsSvcReqBuilder reqSvcBuilder = new StatementDtlsSvcReqBuilder();

			StatementDtlsProcessVbReq vbReq = reqSvcBuilder
					.processReqBuilder(wsreq);

			StatementDtlsProcess process = (StatementDtlsProcess) new StatementDtlsProcessImpl();

			StatementDtlsProcessVbRes vbResp = process.getTransactions(vbReq);

			StatementDtlsResBuilder resSvcBuilder = new StatementDtlsResBuilder();

			wsResp = resSvcBuilder.respSvcBuilder(vbResp);

		}

		catch (StatementDetailsRequestInvalidException e) {

			StatusBlockType stBlock = new StatusBlockType();

			stBlock.setErrorcode(e.getErrorcode());
			stBlock.setErrormsg(e.getErrormsg());

			e.printStackTrace();

		}

		catch (BusinessException be) {

			StatusBlockType stBlock = new StatusBlockType();
			stBlock.setErrorcode(be.getErrorcode());
			stBlock.setErrormsg(be.getErrormsg());

			be.printStackTrace();

		}

		catch (SystemException se) {

			StatusBlockType stBlock = new StatusBlockType();
			stBlock.setErrorcode(se.getErrorcode());
			stBlock.setErrormsg(se.getErrormsg());

		}

		return wsResp;

	}

	public static void main(String[] args) {

		StatementDtlsSvcImpl svcImpl = new StatementDtlsSvcImpl();
		StatementDtlsReqType wsReq = new StatementDtlsReqType();

		ClientDetailsType clientDetails = new ClientDetailsType();

		clientDetails.setClientid("Amazon");
		clientDetails.setChannelid("online");
		clientDetails.setReqid("123");

		CustomerDetailsType custDetails = new CustomerDetailsType();

		custDetails.setCardnum("4592000021383928");
		custDetails.setCvvnum("595");
		custDetails.setExpdate("11-22");
		custDetails.setNameoncard("Rohit K.");

		TransCategoryType cateType = new TransCategoryType();
		cateType.setTypeOfCategory("All");

		wsReq.setClientDetails(clientDetails);
		wsReq.setCustomerDetails(custDetails);
		wsReq.setTransCategory(cateType);

		// call the service method

		StatementDtlsRespType wsResp = svcImpl.getTransactions(wsReq);

		System.out.println(wsResp.getStatusBlock().getExpncode());
		System.out.println(wsResp.getStatusBlock().getExpmsg());
		System.out.println(wsResp.getTransactionDetails().getTransaction());
	}

}
