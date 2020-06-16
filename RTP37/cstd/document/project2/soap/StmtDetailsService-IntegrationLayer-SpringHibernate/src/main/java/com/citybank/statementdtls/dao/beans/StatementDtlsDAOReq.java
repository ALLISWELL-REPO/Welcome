package com.citybank.statementdtls.dao.beans;

public class StatementDtlsDAOReq {
	private String clientId;
	private String channelId;
	private String cardNum;
	private int cvvNum;
	private String expDate;
	private String nameOnCard;
	private String typeOfCate;
	private String startDate;
	private String ensDate;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public int getCvvNum() {
		return cvvNum;
	}
	public void setCvvNum(int cvvNum) {
		this.cvvNum = cvvNum;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getTypeOfCate() {
		return typeOfCate;
	}
	public void setTypeOfCate(String typeOfCate) {
		this.typeOfCate = typeOfCate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEnsDate() {
		return ensDate;
	}
	public void setEnsDate(String ensDate) {
		this.ensDate = ensDate;
	}
	@Override
	public String toString() {
		return "StatementDtlsDAOReq [clientId=" + clientId + ", channelId=" + channelId + ", cardNum=" + cardNum
				+ ", cvvNum=" + cvvNum + ", expDate=" + expDate + ", nameOnCard=" + nameOnCard + ", typeOfCate="
				+ typeOfCate + ", startDate=" + startDate + ", ensDate=" + ensDate + "]";
	}
	

}