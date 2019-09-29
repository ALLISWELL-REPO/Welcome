package com.sreenutech.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreType;


//@JsonIgnoreType
public class Account {
	
	private int cardNumber;
	private int cvvNumber;
	private String typeOfBank;
	private String nameOnCard;
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public String getTypeOfBank() {
		return typeOfBank;
	}
	public void setTypeOfBank(String typeOfBank) {
		this.typeOfBank = typeOfBank;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [cardNumber=");
		builder.append(cardNumber);
		builder.append(", cvvNumber=");
		builder.append(cvvNumber);
		builder.append(", typeOfBank=");
		builder.append(typeOfBank);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
