package org.nhs.patientinfo.dao.Util;

public class BeginessException extends Exception {
	
	private String respCode;
	private String respMsg;
	public BeginessException(String respCode, String respMsg) {
		super();
		this.respCode = respCode;
		this.respMsg = respMsg;
		
	}
	public String getRespCode() {
		return respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
}
