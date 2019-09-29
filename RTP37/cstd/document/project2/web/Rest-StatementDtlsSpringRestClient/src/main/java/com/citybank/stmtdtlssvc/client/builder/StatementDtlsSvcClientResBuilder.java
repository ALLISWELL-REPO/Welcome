package com.citybank.stmtdtlssvc.client.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls_schema.resp.StatementDtlsResType;
import com.citybank.statementdtls_schema.resp.TrasactionType;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.beans.TransactionClient;

@Component
public class StatementDtlsSvcClientResBuilder {

	public StatementDtlsWebRes buildWebResponse(StatementDtlsResType wsRes) {
		StatementDtlsWebRes webRes = new StatementDtlsWebRes();
		webRes.setRespCode(wsRes.getStatusBlock().getRespCode());
		webRes.setRespMsg(wsRes.getStatusBlock().getRespMsg());
		List<TransactionClient> clientTransList = new ArrayList<TransactionClient>();
		if (wsRes.getTransDetails() != null) {
			if (wsRes.getTransDetails().getTrasaction() != null) {
				List<TrasactionType> wsTransList = wsRes.getTransDetails().getTrasaction();
				for (TrasactionType trans : wsTransList) {
					TransactionClient transClient = new TransactionClient();
					transClient.setId(trans.getId());
					transClient.setName(trans.getName());
					transClient.setAmount(trans.getAmout());
					transClient.setDesc(trans.getDesc());
					// transClient.setDate(trans.get);
					transClient.setMerchantName(trans.getMarchatName());
					transClient.setRemarks(trans.getRemark());
					transClient.setStatus(trans.getStatus());
					clientTransList.add(transClient);
				}

			}
		}
		webRes.setWebTransList(clientTransList);
		return webRes;
		
	}

}
