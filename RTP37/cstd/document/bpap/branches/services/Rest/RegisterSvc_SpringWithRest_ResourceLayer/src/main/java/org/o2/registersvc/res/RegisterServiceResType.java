
package org.o2.registersvc.res;

import org.springframework.stereotype.Component;

@Component
public class RegisterServiceResType {

  
	private StatusBlockType statusBlock;

	private CreditCheckType creditCheck;

   
    public StatusBlockType getStatusBlock() {
        return statusBlock;
    }

    public void setStatusBlock(StatusBlockType value) {
        this.statusBlock = value;
    }

    public CreditCheckType getCreditCheck() {
        return creditCheck;
    }

   
    public void setCreditCheck(CreditCheckType value) {
        this.creditCheck = value;
    }

}
