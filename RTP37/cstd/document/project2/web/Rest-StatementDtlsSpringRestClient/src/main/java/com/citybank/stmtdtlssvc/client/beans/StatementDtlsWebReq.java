package com.citybank.stmtdtlssvc.client.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StatementDtlsWebReq {
	private String cardNum;
	private int cvvNum;
	private String expDate;
	private String nameOnCard;
	private String typeOfCate;
	private String startDate;
	private String endDate;

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

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "StatementDtlsWebReq [cardNum=" + cardNum + ", cvvNum=" + cvvNum + ", expDate=" + expDate
				+ ", nameOnCard=" + nameOnCard + ", typeOfCate=" + typeOfCate + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}
