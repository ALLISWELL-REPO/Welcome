package com.citybank.statementdtls.dao.util;

public class SystemException extends Exception {

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

	public SystemException(String errorcode, String errormsg) {
		super();
		this.errorcode = errorcode;
		this.errormsg = errormsg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemException [errorcode=");
		builder.append(errorcode);
		builder.append(", errormsg=");
		builder.append(errormsg);
		builder.append("]");
		return builder.toString();
	}

}
