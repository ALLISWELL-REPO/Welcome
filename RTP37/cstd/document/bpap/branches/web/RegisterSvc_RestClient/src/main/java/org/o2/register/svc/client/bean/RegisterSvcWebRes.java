/*@NHS All rights are reserved.You should not disclose the
 * Information outside otherwise terms and conditions will apply
 * 
 */
package org.o2.register.svc.client.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author stech
 * @Date 22-Apr-2018
   @Description : 
 * 
 */
@XmlRootElement
public class RegisterSvcWebRes {

	private float rateOfPer;
	private String creditStatus;
	private String respCode;
	private String respMsg;
	
	public float getRateOfPer() {
		return rateOfPer;
	}
	public void setRateOfPer(float rateOfPer) {
		this.rateOfPer = rateOfPer;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	
	
}
