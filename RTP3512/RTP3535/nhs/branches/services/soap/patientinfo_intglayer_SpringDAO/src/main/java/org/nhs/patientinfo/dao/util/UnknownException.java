/**
 * NHS.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.dao.util;

/**
 * @author: Stech
 * @Date     :  Mar 4, 2018
 * Description:  
 */
public class UnknownException extends Exception {
	private String respCode;
	private String respMsg;

	public UnknownException(String respCode, String respMsg) {
     System.out.println("entered into Unknown Exception ");
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientInfoReqValidException [respCode=");
		builder.append(respCode);
		builder.append(", respMsg=");
		builder.append(respMsg);
		builder.append("]");
		return builder.toString();
	}

}
