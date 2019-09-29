package com.citybank.statementdtls.process.valuebeans;

import java.util.List;

import com.citybank.statementdtls.dao.beans.TrasactionDAO;

public class StatementDtlsProcessVbRes {
	private String respCode;
	private String respMsg;
	private List<TransactionProcess> transProcess;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public List<TransactionProcess> getTransProcess() {
		return transProcess;
	}

	public void setTransProcess(List<TransactionProcess> transProcess) {
		this.transProcess = transProcess;
	}
	
}
