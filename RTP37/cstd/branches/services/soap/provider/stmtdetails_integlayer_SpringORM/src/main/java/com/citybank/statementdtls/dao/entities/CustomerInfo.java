package com.citybank.statementdtls.dao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer_details")
public class CustomerInfo {

	@Id
	private int id;
	
	@Column(name = "cardnum")
	private String Card_num;
	
	@Column(name = "cvv")
	private String Cvv_num;
	
	@Column(name = "nameoncard")
	private String Name_on_card;
	
	@Column(name = "expdate")
	@Temporal(TemporalType.DATE)
	private Date Exp_Date;
	
	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private Date Date_Birth;
	
	@Column(name = "credit")
	private String credit_desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCard_num() {
		return Card_num;
	}

	public void setCard_num(String card_num) {
		Card_num = card_num;
	}

	public String getCvv_num() {
		return Cvv_num;
	}

	public void setCvv_num(String cvv_num) {
		Cvv_num = cvv_num;
	}

	public String getName_on_card() {
		return Name_on_card;
	}

	public void setName_on_card(String name_on_card) {
		Name_on_card = name_on_card;
	}

	public Date getExp_Date() {
		return Exp_Date;
	}

	public void setExp_Date(Date exp_Date) {
		Exp_Date = exp_Date;
	}

	public Date getDate_Birth() {
		return Date_Birth;
	}

	public void setDate_Birth(Date date_Birth) {
		Date_Birth = date_Birth;
	}

	public String getCredit_desc() {
		return credit_desc;
	}

	public void setCredit_desc(String credit_desc) {
		this.credit_desc = credit_desc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerInfo [id=");
		builder.append(id);
		builder.append(", Card_num=");
		builder.append(Card_num);
		builder.append(", Cvv_num=");
		builder.append(Cvv_num);
		builder.append(", Name_on_card=");
		builder.append(Name_on_card);
		builder.append(", Exp_Date=");
		builder.append(Exp_Date);
		builder.append(", Date_Birth=");
		builder.append(Date_Birth);
		builder.append(", credit_desc=");
		builder.append(credit_desc);
		builder.append("]");
		return builder.toString();
	}

	
	

}
