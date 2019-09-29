package com.citybank.card.stmtsvc.client.builder;

import java.util.ArrayList;
import java.util.List;

import com.citybank.card.stmtsvc.client.beans.StatementDtlsWebResp;
import com.citybank.card.stmtsvc.client.beans.TransactionRespProcess;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.schema.res.TransactionType;

public class StatementSvcClientResBuilder {

	public StatementDtlsWebResp buildWsResponse(StatementDtlsResType wsRes) {
		// TODO Auto-generated method stub

		StatementDtlsWebResp webRes = new StatementDtlsWebResp();
		webRes.setRespCode(wsRes.getStatusBlock().getReapcode());
		webRes.setRespMsg(wsRes.getStatusBlock().getRespmsg());

		List<TransactionRespProcess> clientTransList = new ArrayList<TransactionRespProcess>();
		List<TransactionType> wsTransList = wsRes.getTransDetails().getTransaction();
		for (TransactionType trans : wsTransList) {
			TransactionRespProcess transProClient = new TransactionRespProcess();
			transProClient.setId(trans.getId());
			transProClient.setName(trans.getName());
			transProClient.setDate(trans.getDate());
			transProClient.setAmount(trans.getAmount());
			transProClient.setDesc(trans.getDesc());
			// transProClient.setDate(trans.getDate());
			transProClient.setMerchantname(trans.getMerchantname());
			transProClient.setRemarks(trans.getRemark());
			transProClient.setStatus(trans.getStatus());

			clientTransList.add(transProClient);

		}
		webRes.setTransResProcess(clientTransList);

		return webRes;
	}

}
