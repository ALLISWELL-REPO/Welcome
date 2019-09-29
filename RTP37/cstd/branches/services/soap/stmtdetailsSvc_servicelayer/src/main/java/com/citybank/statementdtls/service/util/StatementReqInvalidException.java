package com.citybank.statementdtls.service.util;

public class StatementReqInvalidException extends Exception {

	private String errorCode;
	private String errorMsg;

	public StatementReqInvalidException(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
