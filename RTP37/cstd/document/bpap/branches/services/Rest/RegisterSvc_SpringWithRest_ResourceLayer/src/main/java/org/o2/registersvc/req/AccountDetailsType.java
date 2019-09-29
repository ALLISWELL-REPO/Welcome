
package org.o2.registersvc.req;

import org.springframework.stereotype.Component;

@Component
public class AccountDetailsType {

  
    private String accNumber;
    private long mobNumber;

   
    public String getAccNumber() {
        return accNumber;
    }

   
    public void setAccNumber(String value) {
        this.accNumber = value;
    }

    public long getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(long value) {
        this.mobNumber = value;
    }

    
    
	@Override
	public String toString() {
		return "AccountDetailsType [accNumber=" + accNumber + ", mobNumber=" + mobNumber + "]";
	}

    
    
    
    
}
