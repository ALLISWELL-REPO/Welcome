package org.nhs.patientinfo.service.client.beans;

public class PatientInfoWebRes {
	protected String respCode;
	protected String resMsg;
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientInfoWebRes [respCode=");
		builder.append(respCode);
		builder.append(", resMsg=");
		builder.append(resMsg);
		builder.append("]");
		return builder.toString();
	}
	

}
