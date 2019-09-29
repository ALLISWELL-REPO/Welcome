package com.sreenutech.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
@JsonIgnoreType
public class Orders {
	private List<Order> order;

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [order=");
		builder.append(order);
		builder.append("]");
		return builder.toString();
	}
	
	

}
