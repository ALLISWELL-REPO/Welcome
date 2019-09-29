package org.o2.payment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "account_details")
public class AccountDetails {
	@Id
	@Column
	private String account_num;
	@Column
	private int mobile_num;
	
	public final String getAccount_num() {
		return account_num;
	}
	public final void setAccount_num(String account_num) {
		this.account_num = account_num;
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
		builder.append("AccountDetails [account_num=");
		builder.append(account_num);
		builder.append(", mobile_num=");
		builder.append(mobile_num);
		builder.append("]");
		return builder.toString();
	}
	
	

	

}
