package com.citybank.card.stmtsvc.client;

import com.citybank.card.stmtsvc.client.beans.StatementDtlsWebReq;
import com.citybank.card.stmtsvc.client.beans.StatementDtlsWebResp;

public interface StatementDtlsSvcClient {
	public StatementDtlsWebResp getTransactions(StatementDtlsWebReq  webReq);
	

}
