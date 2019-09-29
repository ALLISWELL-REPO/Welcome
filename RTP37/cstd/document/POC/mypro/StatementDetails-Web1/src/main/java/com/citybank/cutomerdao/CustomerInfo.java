package com.citybank.cutomerdao;

import java.util.Date;

public class CustomerInfo {
	private String cust_id;
	private String cust_name;
	private String address;
	private String city;
	private String state;
	private String pin;
	private Date enrollment;
	private String Account_number;
	private String balance;
	private String cardnumber;
	private String cvv;
	private String expdate;
	private String nameoncard;
	private String status;
	private Date dob;
	private String mobilenumber;
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
	public Date getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(Date enrollment) {
		this.enrollment = enrollment;
	}
	public String getAccount_number() {
		return Account_number;
	}
	public void setAccount_number(String account_number) {
		Account_number = account_number;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
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
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerInfo [cust_id=");
		builder.append(cust_id);
		builder.append(", cust_name=");
		builder.append(cust_name);
		builder.append(", address=");
		builder.append(address);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", pin=");
		builder.append(pin);
		builder.append(", enrollment=");
		builder.append(enrollment);
		builder.append(", Account_number=");
		builder.append(Account_number);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", cardnumber=");
		builder.append(cardnumber);
		builder.append(", cvv=");
		builder.append(cvv);
		builder.append(", expdate=");
		builder.append(expdate);
		builder.append(", nameoncard=");
		builder.append(nameoncard);
		builder.append(", status=");
		builder.append(status);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", mobilenumber=");
		builder.append(mobilenumber);
		builder.append(", emailid=");
		builder.append(emailid);
		builder.append("]");
		return builder.toString();
	}
	
}
