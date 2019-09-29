package com.citybank.statementdtls.process.valuebeans;

import java.util.List;

public class StatementDtlsProcessVbRes {

	private String expncode;

	private String expmsg;

	private List<TransactionProcess> transProcess;

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

	public List<TransactionProcess> getTransProcess() {
		return transProcess;
	}

	public void setTransProcess(List<TransactionProcess> transProcess) {
		this.transProcess = transProcess;
	}

	@Override
	public String toString() {
		return "StatementDtlsProcessVbRes [expncode=" + expncode + ", expmsg="
				+ expmsg + ", transProcess=" + transProcess + "]";
	}

}
