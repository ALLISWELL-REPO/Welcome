package com.citybank.statementdtls.dao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transaction_details")
public class TransactionDetails {
	@Id
	@Column
	private int id;
	
	@Column(name="cardnum")
	private String Card_num;
	
	@Column(name="trans_id")
	private String trans_id;
	
	@Column(name="date")
	
	private Date date_value;
	
	@Column(name="name")
	private String name_value;
	
	@Column(name="descrption")
	private String description;
	
	@Column(name="merchant_name")
	private String merchantname;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="status")
	private String status;
	
	@Column(name="remarks")
	private String remark;

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

	public String getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}

	public Date getDate_value() {
		return date_value;
	}

	public void setDate_value(Date date_value) {
		this.date_value = date_value;
	}

	public String getName_value() {
		return name_value;
	}

	public void setName_value(String name_value) {
		this.name_value = name_value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TransactionDetails [id=" + id + ", Card_num=" + Card_num + ", trans_id=" + trans_id + ", date_value="
				+ date_value + ", name_value=" + name_value + ", description=" + description + ", merchantname="
				+ merchantname + ", amount=" + amount + ", status=" + status + ", remark=" + remark + "]";
	}


	
	

	

}
