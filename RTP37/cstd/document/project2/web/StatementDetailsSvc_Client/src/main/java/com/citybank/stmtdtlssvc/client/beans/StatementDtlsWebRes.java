package com.citybank.stmtdtlssvc.client.beans;

import java.util.List;


public class StatementDtlsWebRes {
	private String respCode;
	private String respMsg;
	private List<TransactionClient> webTransList;
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
	public List<TransactionClient> getWebTransList() {
		return webTransList;
	}
	public void setWebTransList(List<TransactionClient> webTransList) {
		this.webTransList = webTransList;
	}

}