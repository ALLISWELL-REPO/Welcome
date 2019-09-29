
package com.citybank.statementdtls_schema.resp;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;

/*@JsonPropertyOrder({ 
	"StatusBlock",
	"TransDetails"
	})*/

@JsonRootName("StatementDtlsResType")
public class StatementDtlsResType {
	@JsonProperty
	protected StatusBlockType StatusBlock;
	@JsonProperty
	protected TransDetailsType TransDetails;



	public StatusBlockType getStatusBlock() {
		return StatusBlock;
	}



	public void setStatusBlock(StatusBlockType statusBlock) {
		StatusBlock = statusBlock;
	}



	public TransDetailsType getTransDetails() {
		return TransDetails;
	}



	public void setTransDetails(TransDetailsType transDetails) {
		TransDetails = transDetails;
	}



	@Override
	public String toString() {
		return "StatementDtlsResType [StatusBlock=" + StatusBlock + ", TransDetails=" + TransDetails + "]";
	}




}
