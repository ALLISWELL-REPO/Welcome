package com.citybank.stmtdtlssvc.client;

import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
//
public interface StatementDtlsSvcClient {

	public StatementDtlsWebRes getTransactions(StatementDtlsWebReq webReq);

}
