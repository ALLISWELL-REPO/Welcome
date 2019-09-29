
package org.o2.registersvc.req;

import org.springframework.stereotype.Component;

@Component
public class ServiceDetailsType {

   
	private String serviceNumber;
   
	private String apiName;
    
	private String version;

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String value) {
        this.serviceNumber = value;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String value) {
        this.apiName = value;
    }

    public String getVersion() {
        return version;
    }

   
    public void setVersion(String value) {
        this.version = value;
    }

}
