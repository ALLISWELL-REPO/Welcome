package com.citybank.statementdtls.dao.beans;

import java.util.List;

public class StatementDtlsDAORes {
	private String respCode;
	private String respMsg;
	private List<TransactionsDAO> transDAO;
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
	public List<TransactionsDAO> getTransDAO() {
		return transDAO;
	}
	public void setTransDAO(List<TransactionsDAO> transDAO) {
		this.transDAO = transDAO;
	}
	@Override
	public String toString() {
		return "StatementDtlsDAORes [respCode=" + respCode + ", respMsg=" + respMsg + ", transDAO=" + transDAO + "]";
	}
	

}
