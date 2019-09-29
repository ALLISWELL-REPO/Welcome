package org.register.beans;

public class O2RegReq {

	private String  cardNumb;
	private String  cvv;
	private String  expDate;
	private String  nameOnCard;
	private String  mobNumb;
	
	
	
	public String getCardNumb() {
		return cardNumb;
	}
	public void setCardNumb(String cardNumb) {
		this.cardNumb = cardNumb;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
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
	public String getMobNumb() {
		return mobNumb;
	}
	public void setMobNumb(String mobNumb) {
		this.mobNumb = mobNumb;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("O2RegReq [cardNumb=");
		builder.append(cardNumb);
		builder.append(", cvv=");
		builder.append(cvv);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append(", mobNumb=");
		builder.append(mobNumb);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
