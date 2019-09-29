package com.citybank.statementdtls.process.valuebeans;

import java.util.List;

public class StatementDtlsProcessVbRes {
	private String respCode;
	private String respMsg;
	private List<TransactionsProcess> transProcess;
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
	public List<TransactionsProcess> getTransProcess() {
		return transProcess;
	}
	public void setTransProcess(List<TransactionsProcess> transProcess) {
		this.transProcess = transProcess;
	}
	@Override
	public String toString() {
		return "StatementDtlsProcessVbRes [respCode=" + respCode + ", respMsg=" + respMsg + ", transProcess="
				+ transProcess + "]";
	}
	  

}
