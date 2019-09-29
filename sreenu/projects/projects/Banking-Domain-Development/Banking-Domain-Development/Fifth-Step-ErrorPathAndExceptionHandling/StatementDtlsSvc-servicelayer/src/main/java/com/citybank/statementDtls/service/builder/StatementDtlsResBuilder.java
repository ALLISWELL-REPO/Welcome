package com.citybank.statementDtls.service.builder;

import java.util.ArrayList;
import java.util.List;

import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementDtls.process.valuebeans.TransactionProcess;
import com.citybank.statementdtls.schema.res.StatementDtlsRespType;
import com.citybank.statementdtls.schema.res.StatusBlockType;
import com.citybank.statementdtls.schema.res.TransactionDetailsType;
import com.citybank.statementdtls.schema.res.TransactionType;

public class StatementDtlsResBuilder {

	public StatementDtlsRespType respSvcBuilder(StatementDtlsProcessVbRes vbResp) {

		StatementDtlsRespType wsResp = new StatementDtlsRespType();

		StatusBlockType statusType = new StatusBlockType();

		statusType.setExpncode(vbResp.getExpncode());
		statusType.setExpmsg(vbResp.getExpmsg());

		wsResp.setStatusBlock(statusType);

		// List logic

		List<TransactionProcess> transProcessList = vbResp.getTransProcess();

		List<TransactionType> wsList = new ArrayList<TransactionType>();

		TransactionDetailsType transDetailsType = new TransactionDetailsType();

		for (TransactionProcess transProcess : transProcessList) {

			TransactionType transWs = new TransactionType();

			transWs.setTransid(transProcess.getTransid());
			transWs.setName(transProcess.getName());
			transWs.setDesc(transProcess.getDesc());
			transWs.setAmount(transProcess.getAmount());
			transWs.setMerchantname(transProcess.getMerchantname());
			transWs.setStatus(transProcess.getStatus());
			transWs.setRemarks(transProcess.getRemarks());

			transDetailsType.getTransaction().add(transWs);

		}

		wsResp.setTransactionDetails(transDetailsType);

		System.out.println("Exit from service layer");

		return wsResp;

	}

}
