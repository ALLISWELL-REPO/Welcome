package com.citybank.stmtdtlssvc.client.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StatementDtlsWebRes {

	private String expncode;

	private String expmsg;

	private List<TransactionClient> webTransList;

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

	public List<TransactionClient> getWebTransList() {
		return webTransList;
	}

	public void setWebTransList(List<TransactionClient> webTransList) {
		this.webTransList = webTransList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatementDtlsWebRes [expncode=");
		builder.append(expncode);
		builder.append(", expmsg=");
		builder.append(expmsg);
		builder.append(", webTransList=");
		builder.append(webTransList);
		builder.append("]");
		return builder.toString();
	}

}
