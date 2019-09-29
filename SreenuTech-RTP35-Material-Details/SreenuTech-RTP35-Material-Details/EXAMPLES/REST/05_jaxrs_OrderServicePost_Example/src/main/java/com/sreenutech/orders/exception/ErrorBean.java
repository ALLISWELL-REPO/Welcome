package com.sreenutech.orders.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorBean {
	private String respCode;
	private String respMsg;
	private String userMessage;
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	@Override
	public String toString() {
		return "ErrorBean [respCode=" + respCode + ", respMsg=" + respMsg + "]";
	}
	
	
	

}
