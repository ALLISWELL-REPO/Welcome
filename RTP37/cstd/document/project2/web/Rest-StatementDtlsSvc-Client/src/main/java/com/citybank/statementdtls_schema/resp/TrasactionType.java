


package com.citybank.statementdtls_schema.resp;

import org.codehaus.jackson.annotate.JsonProperty;

public class TrasactionType {
	@JsonProperty
    protected String id;
	@JsonProperty
    protected String name;
	@JsonProperty
    protected String desc;
	@JsonProperty
    protected String MarchatName;
	@JsonProperty
    protected String amout;
	@JsonProperty
    protected String status;
	@JsonProperty
    protected String remark;

 
    public String getId() {
        return id;
    }

 
    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

  
    public void setName(String value) {
        this.name = value;
    }

    public String getDesc() {
        return desc;
    }

  
    public void setDesc(String value) {
        this.desc = value;
    }

    public String getMarchatName() {
        return MarchatName;
    }

    public void setMarchatName(String value) {
        this.MarchatName = value;
    }

    public String getAmout() {
        return amout;
    }

    public void setAmout(String value) {
        this.amout = value;
    }

  
    public String getStatus() {
        return status;
    }

  
    public void setStatus(String value) {
        this.status = value;
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String value) {
        this.remark = value;
    }


	@Override
	public String toString() {
		return "TrasactionType [id=" + id + ", name=" + name + ", desc=" + desc + ", MarchatName=" + MarchatName
				+ ", amout=" + amout + ", status=" + status + ", remark=" + remark + "]";
	}


	

}
