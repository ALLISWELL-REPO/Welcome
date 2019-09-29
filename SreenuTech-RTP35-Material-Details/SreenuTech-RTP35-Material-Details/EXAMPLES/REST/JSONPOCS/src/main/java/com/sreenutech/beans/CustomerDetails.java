package com.sreenutech.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName(value = "Customer")
@JsonInclude(Include.NON_NULL)
 @JsonIgnoreProperties({"fname","lname"})
@JsonPropertyOrder({"account","orders"})
//@XmlRootElement
public class CustomerDetails {
    @JsonProperty("customer-id")
	private String id;
	private String name;
	@JsonProperty("f_name")
	private String fname;
	//@JsonProperty("l_name")
	@JsonIgnore
	private String lname;
	//@JsonIgnore
	private String emailid;
	private String mobileNo;
	private List<String> addresses;
	private Orders orders;
	private Account account;
	
	
	
	//@JsonSetter("cust_id")
	
	public String getId() {
		return id;
	}
	
	//@JsonSetter("cust_id")
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	//@JsonSetter("f-name")
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	//@JsonSetter("l-name")
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDetails [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", fname=");
		builder.append(fname);
		builder.append(", lname=");
		builder.append(lname);
		builder.append(", emailid=");
		builder.append(emailid);
		builder.append(", mobileNo=");
		builder.append(mobileNo);
		builder.append(", addresses=");
		builder.append(addresses);
		builder.append(", orders=");
		builder.append(orders);
		builder.append(", account=");
		builder.append(account);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
