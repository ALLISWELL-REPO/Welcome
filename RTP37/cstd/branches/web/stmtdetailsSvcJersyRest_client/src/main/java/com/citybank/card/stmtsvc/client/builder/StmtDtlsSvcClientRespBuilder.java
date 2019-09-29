package com.citybank.card.stmtsvc.client.builder;

import java.util.ArrayList;
import java.util.List;

import com.citybank.card.stmtsvc.client.beans.StatementWebResp;
import com.citybank.card.stmtsvc.client.beans.Transaction;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.schema.res.TransactionType;

public class StmtDtlsSvcClientRespBuilder {
	
	public StatementWebResp buildWebResponse(StatementDtlsResType wsRes) {
		StatementWebResp webRes = new StatementWebResp();
		webRes.setRespCode(wsRes.getStatusBlock().getReapcode());
		webRes.setRespMsg(wsRes.getStatusBlock().getRespmsg());
		List<Transaction> clientTransList = new ArrayList<Transaction>();
		if (wsRes.getTransDetails() != null) {
			if (wsRes.getTransDetails().getTransaction()!= null) {
		List<TransactionType> wsTransList = wsRes.getTransDetails().getTransaction();
		for (TransactionType trans : wsTransList) {
			Transaction transClient = new Transaction();
			transClient.setId(trans.getId());
			transClient.setName(trans.getName());
			transClient.setAmount(trans.getAmount());
			transClient.setDesc(trans.getDesc());
			// transClient.setDate(trans.get);
			transClient.setMerchantname(trans.getMerchantname());
			transClient.setRemarks(trans.getRemark());
			transClient.setStatus(trans.getStatus());
			clientTransList.add(transClient);
		}
			}
		}

		webRes.setTransaction(clientTransList);
		
	
		return webRes;

}
}
		
