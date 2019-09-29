package org.o2.registersvc.service.util;

public class RegisterSvcReqInvalid extends Exception{

	private String respCode;
	private String respMsg;
	
	
	public RegisterSvcReqInvalid(String respCode, String respMsg) {
	
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
