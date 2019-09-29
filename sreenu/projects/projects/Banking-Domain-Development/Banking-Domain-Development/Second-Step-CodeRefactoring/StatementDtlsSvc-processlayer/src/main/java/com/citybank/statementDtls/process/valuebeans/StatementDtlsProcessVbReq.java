package com.citybank.statementDtls.process.valuebeans;

public class StatementDtlsProcessVbReq {

	private String clientid;

	private String channelid;

	private String cardnum;

	private String cvvnum;

	private String expdate;

	private String nameoncard;

	private String startdate;

	private String enddate;

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getChannelid() {
		return channelid;
	}

	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getCvvnum() {
		return cvvnum;
	}

	public void setCvvnum(String cvvnum) {
		this.cvvnum = cvvnum;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "StatementDtlsProcessVbReq [clientid=" + clientid
				+ ", channelid=" + channelid + ", cardnum=" + cardnum
				+ ", cvvnum=" + cvvnum + ", expdate=" + expdate
				+ ", nameoncard=" + nameoncard + ", startdate=" + startdate
				+ ", enddate=" + enddate + "]";
	}

}
