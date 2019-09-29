package com.citybank.custdao;

import java.sql.Date;

public class CustomerInfo {
	private String cust_id;
	private String cust_name;
	private String address;
	private String city;
	private String state;
	private String pin;
	private Date enrollment_date;
	private String account_no;
	private String balance;
	private String cardnum;
	private String cvv;
	private String expdate;
	private String nameoncard;
	private String status;
	private Date dob;
	private String mobile;
	private String emailid;
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Date getEnrollment_date() {
		return enrollment_date;
	}
	public void setEnrollment_date(Date enrollment_date) {
		this.enrollment_date = enrollment_date;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	public String getNameoncard() {
		return nameoncard;
	}
	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "CustomerInfo [cust_id=" + cust_id + ", cust_name=" + cust_name + ", address=" + address + ", city="
				+ city + ", state=" + state + ", pin=" + pin + ", enrollment_date=" + enrollment_date + ", account_no="
				+ account_no + ", balance=" + balance + ", cardnum=" + cardnum + ", cvv=" + cvv + ", expdate=" + expdate
				+ ", nameoncard=" + nameoncard + ", status=" + status + ", dob=" + dob + ", mobile=" + mobile
				+ ", emailid=" + emailid + "]";
	}
	
	
	
}
