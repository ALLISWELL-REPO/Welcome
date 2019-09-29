package com.sreenutech.orders.exception;

public class OrderServiceException extends Exception {

	private String respCode;
	private String respMSg;

	public OrderServiceException(String respCode,String respMSg) {
		this.respCode = respCode;
		this.respMSg = respMSg;
	}

	public String getRespCode() {
		return respCode;
	}

	public String getRespMSg() {
		return respMSg;
	}

	
}
