package com.citybank.statementDtls.process.valuebeans;

import javax.xml.bind.annotation.XmlElement;

public class TransactionProcess {

	private String transid;

	private String name;

	private String desc;

	private String merchantname;

	private String amount;

	private String status;

	private String remarks;

	public String getTransid() {
		return transid;
	}

	public void setTransid(String transid) {
		this.transid = transid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TransactionProcess [transid=" + transid + ", name=" + name
				+ ", desc=" + desc + ", merchantname=" + merchantname
				+ ", amount=" + amount + ", status=" + status + ", remarks="
				+ remarks + "]";
	}

}
