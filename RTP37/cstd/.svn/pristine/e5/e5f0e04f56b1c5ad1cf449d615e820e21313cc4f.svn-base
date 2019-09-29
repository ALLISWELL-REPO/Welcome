package org.o2.payment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_details")
public class CustomerDetails {
	
	@Column
	private String card_num;
	@Column
	private String name_on_card;
	@Column
	private String cvv;
	@Column
	private String exp_date;
	@Id
	@Column
	private int mobile_num;
	public final String getCard_num() {
		return card_num;
	}
	public final void setCard_num(String card_num) {
		this.card_num = card_num;
	}
	public final String getName_on_card() {
		return name_on_card;
	}
	public final void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}
	public final String getCvv() {
		return cvv;
	}
	public final void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public final String getExp_date() {
		return exp_date;
	}
	public final void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	public final int getMobile_num() {
		return mobile_num;
	}
	public final void setMobile_num(int mobile_num) {
		this.mobile_num = mobile_num;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDetails [card_num=");
		builder.append(card_num);
		builder.append(", name_on_card=");
		builder.append(name_on_card);
		builder.append(", cvv=");
		builder.append(cvv);
		builder.append(", exp_date=");
		builder.append(exp_date);
		builder.append(", mobile_num=");
		builder.append(mobile_num);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
