package com.alam.ajax.bean;

import java.util.List;

public class StatementWebResponse {
	private String respCode;
	private String resMsg;
	private List<Transaction> transactions;
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public List<Transaction> getTransList() {
		return transactions;
	}
	public void setTransList(List<Transaction> transList) {
		this.transactions = transList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatementWebResponse [respCode=");
		builder.append(respCode);
		builder.append(", resMsg=");
		builder.append(resMsg);
		builder.append(", transList=");
		builder.append(transactions);
		builder.append("]");
		return builder.toString();
	}
	
	

}
