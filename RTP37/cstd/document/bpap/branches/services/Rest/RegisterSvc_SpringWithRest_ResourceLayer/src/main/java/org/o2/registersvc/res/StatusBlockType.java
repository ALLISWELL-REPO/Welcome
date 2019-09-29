
package org.o2.registersvc.res;

import org.springframework.stereotype.Component;

@Component
public class StatusBlockType {


	private String respCode;
  
	private String respMsg;

    
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
		return "StatusBlockType [respCode=" + respCode + ", respMsg=" + respMsg + "]";
	}

    
    
}
