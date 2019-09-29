package com.citybank.statementDtls.service.builder;

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

		// preapre wsResp transction

		TransactionDetailsType svcTransList = new TransactionDetailsType();

		for (TransactionProcess transProcess : transProcessList) {

			TransactionType transType = new TransactionType();

			transType.setTransid(transProcess.getTransid());
			transType.setAmount(transProcess.getAmount());
			transType.setDesc(transProcess.getDesc());
			transType.setMerchantname(transProcess.getMerchantname());
			transType.setName(transProcess.getName());
			transType.setStatus(transProcess.getStatus());
			transType.setRemarks(transProcess.getRemarks());

		}

		wsResp.setTransactionDetails(svcTransList);

		System.out.println("Exit from service layer");

		return wsResp;

	}

}
