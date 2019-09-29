package com.citybank.statementDtls.dao.util;

public class BusinessException extends Exception {

	private String errorcode;
	private String errormsg;

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public BusinessException(String errorcode, String errormsg) {
		super();
		this.errorcode = errorcode;
		this.errormsg = errormsg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusinessException [errorcode=");
		builder.append(errorcode);
		builder.append(", errormsg=");
		builder.append(errormsg);
		builder.append("]");
		return builder.toString();
	}

}
