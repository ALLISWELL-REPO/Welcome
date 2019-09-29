package com.citybank.statementdtls.dao.util;

public class BusinessException extends Exception {
	private String dbErrorCode;
	private String dbErrorMsg;

	public BusinessException(String dbErrorCode, String dbErrorMsg) {
		this.dbErrorCode = dbErrorCode;
		this.dbErrorMsg = dbErrorMsg;
	}

	public String getDbErrorCode() {
		return dbErrorCode;
	}

	public String getDbErrorMsg() {
		return dbErrorMsg;
	}
	

}
