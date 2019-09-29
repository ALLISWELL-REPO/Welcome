


package com.citybank.statementdtls_schema.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



public class StatusBlockType {

    protected String errorCode;
    protected String errorMsg;
    protected String respCode;
    protected String respMsg;

   
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String value) {
        this.errorCode = value;
    }

   
    public String getErrorMsg() {
        return errorMsg;
    }


    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

    public String getRespCode() {
        return respCode;
    }

 
    public void setRespCode(String value) {
        this.respCode = value;
    }

   
    public String getRespMsg() {
        return respMsg;
    }

    
    public void setRespMsg(String value) {
        this.respMsg = value;
    }

	@Override
	public String toString() {
		return "StatusBlockType [errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", respCode=" + respCode
				+ ", respMsg=" + respMsg + "]";
	}
    

}
