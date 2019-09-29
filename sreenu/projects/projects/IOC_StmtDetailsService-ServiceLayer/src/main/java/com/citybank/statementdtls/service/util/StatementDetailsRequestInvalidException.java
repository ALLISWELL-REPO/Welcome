package com.citybank.statementdtls.service.util;

public class StatementDetailsRequestInvalidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public StatementDetailsRequestInvalidException(String errorcode,
			String errormsg) {
		super();
		this.errorcode = errorcode;
		this.errormsg = errormsg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatementDetailsRequestInvalidException [errorcode=");
		builder.append(errorcode);
		builder.append(", errormsg=");
		builder.append(errormsg);
		builder.append("]");
		return builder.toString();
	}

}
