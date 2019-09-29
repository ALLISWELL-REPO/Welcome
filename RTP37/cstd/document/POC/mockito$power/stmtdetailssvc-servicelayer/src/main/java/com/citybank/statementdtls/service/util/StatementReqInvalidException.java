/* @CityBank 2018.All Rights are reserved.It is confidential
 * We should disclose this information outside.
 * Otherwise terms and conditions will apply.
 *  
 */
package com.citybank.statementdtls.service.util;

/**
 * @author stech10 Jun 27, 2018 @ version
 */
public class StatementReqInvalidException extends Exception {
	private static final long serialVersionUID = 1L;

	private String ErrorCode;
	private String ErrorMsg;

	/**
	 * @param errorCode
	 * @param errorMsg
	 */
	public StatementReqInvalidException(String errorCode, String errorMsg) {
		ErrorCode = errorCode;
		ErrorMsg = errorMsg;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return ErrorCode;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return ErrorMsg;
	}

}
