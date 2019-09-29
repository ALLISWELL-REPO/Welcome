package com.citybank.stmtdtlssvc.web.beans;

public class UserDetailsHttpReqCommad {
	protected String cardNum;
	protected int cvvNum;
	protected String expDate;
	private String nameOnCard;
	protected String typeOfCate;
	protected String startDate;
	protected String endDate;
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
		return "UserDetailsHttpReqCommad [cardNum=" + cardNum + ", cvvNum=" + cvvNum + ", expDate=" + expDate
				+ ", nameOnCard=" + nameOnCard + ", typeOfCate=" + typeOfCate + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
}
