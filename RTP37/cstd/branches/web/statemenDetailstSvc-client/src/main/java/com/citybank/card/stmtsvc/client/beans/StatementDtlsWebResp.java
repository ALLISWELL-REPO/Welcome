package com.citybank.card.stmtsvc.client.beans;

import java.util.List;


public class StatementDtlsWebResp {
	private String respCode;
	private String respMsg;
	private List<TransactionRespProcess> transResProcess;
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
	public List<TransactionRespProcess> getTransResProcess() {
		return transResProcess;
	}
	public void setTransResProcess(List<TransactionRespProcess> transResProcess) {
		this.transResProcess = transResProcess;
	}
	@Override
	public String toString() {
		return "StatementDtlsWebResp [respCode=" + respCode + ", respMsg=" + respMsg + ", transResProcess="
				+ transResProcess + "]";
	}
	
	
	

}
