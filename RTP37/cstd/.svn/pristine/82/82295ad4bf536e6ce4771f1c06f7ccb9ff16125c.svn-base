package org.o2.registersvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_DETAILS")
public class CustomerDetails {

	@Id
	@GeneratedValue
	private String sno;
	
	@Column(name="card_numb")
	private String cardNumb;
	
	@Column(name="CVV")
	private String cvv;
	
	@Column(name="EXP")
	private String expDate;
	
	@Column(name="NAME_ON_CARD")
	private String nameOnCard;
	
	@Column(name="MOB_NUMB")
	private long mobNumb;
	
	
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
	public long getMobNumb() {
		return mobNumb;
	}
	public void setMobNumb(long mobNumb) {
		this.mobNumb = mobNumb;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDetails [cardNumb=");
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
