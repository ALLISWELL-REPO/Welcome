package com.citybank.cards.statement.bootservice.util;

public class StmtSvcReqInvalidException extends Exception {
	private String errorCode;
	private String errorMsg;

	public StmtSvcReqInvalidException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
