package com.citybank.statementdtls_schema.req;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("ClientDetailsType")
public class ClientDetailsType {

    protected String clientId;
    protected String channelId;
    protected String reqId;

    public String getClientId() {
        return clientId;
    }

  
    public void setClientId(String value) {
        this.clientId = value;
    }


    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String value) {
        this.channelId = value;
    }

 
    public String getReqId() {
        return reqId;
    }

    public void setReqId(String value) {
        this.reqId = value;
    }

}
