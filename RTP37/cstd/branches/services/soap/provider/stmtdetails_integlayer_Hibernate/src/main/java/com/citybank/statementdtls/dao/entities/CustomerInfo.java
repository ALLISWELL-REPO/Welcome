package com.citybank.statementdtls.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String Exp_Date;
	
	@Column(name = "dob")
	private String Date_Birth;
	
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

	public String getExp_Date() {
		return Exp_Date;
	}

	public void setExp_Date(String exp_Date) {
		Exp_Date = exp_Date;
	}

	public String getDate_Birth() {
		return Date_Birth;
	}

	public void setDate_Birth(String date_Birth) {
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
		return "CustomerInfo [id=" + id + ", Card_num=" + Card_num + ", Cvv_num=" + Cvv_num + ", Name_on_card="
				+ Name_on_card + ", Exp_Date=" + Exp_Date + ", Date_Birth=" + Date_Birth + ", credit_desc="
				+ credit_desc + "]";
	}
	
	

}
