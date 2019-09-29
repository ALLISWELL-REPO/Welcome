package com.citybank.stmtdtlssvc.client.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls.schema.res.StatementDtlsRespType;
import com.citybank.statementdtls.schema.res.TransactionType;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.beans.TransactionClient;

@Component
public class StatementDtlsSvcClientResBuilder {

	public StatementDtlsWebRes buildWebResponse(StatementDtlsRespType wsRes) {

		StatementDtlsWebRes webRes = new StatementDtlsWebRes();

		webRes.setExpncode(wsRes.getStatusBlock().getExpncode());
		
		webRes.setExpmsg(wsRes.getStatusBlock().getExpncode());

		List<TransactionClient> clientTransList = new ArrayList<TransactionClient>();
		List<TransactionType> wsTransList = wsRes.getTransactionDetails()
				.getTransaction();

		for (TransactionType trans : wsTransList) {

			TransactionClient transClient = new TransactionClient();
			transClient.setTransid(trans.getTransid());
			transClient.setDesc(trans.getDesc());
			transClient.setAmount(trans.getAmount());
			transClient.setMerchantname(trans.getMerchantname());
			transClient.setName(trans.getName());
			transClient.setStatus(trans.getStatus());
			transClient.setRemarks(trans.getRemarks());

			clientTransList.add(transClient);

		}
		webRes.setWebTransList(clientTransList);

		return webRes;
	}

	public static void main(String[] args) {
		
	}
	
}
