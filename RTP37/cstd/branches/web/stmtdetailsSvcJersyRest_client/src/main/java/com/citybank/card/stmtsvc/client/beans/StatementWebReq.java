package com.citybank.card.stmtsvc.client.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StatementWebReq {
	
	private String cardNumber;
	private String cvvNumber;
	private String nameOnCard;
	private String typeOfCat;
	private String expDate;
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	private String startDate;
	private String endDate;
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getTypeOfCat() {
		return typeOfCat;
	}
	public void setTypeOfCat(String typeOfCat) {
		this.typeOfCat = typeOfCat;
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
		return "StatementWebReq [cardNumber=" + cardNumber + ", cvvNumber=" + cvvNumber + ", nameOnCard=" + nameOnCard
				+ ", typeOfCat=" + typeOfCat + ", expDate=" + expDate + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	

}
