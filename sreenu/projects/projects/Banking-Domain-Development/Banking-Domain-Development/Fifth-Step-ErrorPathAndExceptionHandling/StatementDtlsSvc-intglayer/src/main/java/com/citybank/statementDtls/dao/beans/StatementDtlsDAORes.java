package com.citybank.statementDtls.dao.beans;

import java.util.List;

public class StatementDtlsDAORes {

	private String expncode;

	private String expmsg;

	private List<TransactionDAO> transDAO;

	public String getExpncode() {
		return expncode;
	}

	public void setExpncode(String expncode) {
		this.expncode = expncode;
	}

	public String getExpmsg() {
		return expmsg;
	}

	public void setExpmsg(String expmsg) {
		this.expmsg = expmsg;
	}

	public List<TransactionDAO> getTransDAO() {
		return transDAO;
	}

	public void setTransDAO(List<TransactionDAO> transDAO) {
		this.transDAO = transDAO;
	}

	@Override
	public String toString() {
		return "StatementDtlsDAORes [expncode=" + expncode + ", expmsg="
				+ expmsg + ", transDAO=" + transDAO + "]";
	}

}
