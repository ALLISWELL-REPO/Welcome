
package com.citybank.statementdtls_schema.req;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("ServiceDetailsType")
public class ServiceDetailsType {

    protected String servicename;
    protected String api;
    protected String version;

   
    public String getServicename() {
        return servicename;
    }

    
    public void setServicename(String value) {
        this.servicename = value;
    }

 
    public String getApi() {
        return api;
    }

  
    public void setApi(String value) {
        this.api = value;
    }

 
    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

}
