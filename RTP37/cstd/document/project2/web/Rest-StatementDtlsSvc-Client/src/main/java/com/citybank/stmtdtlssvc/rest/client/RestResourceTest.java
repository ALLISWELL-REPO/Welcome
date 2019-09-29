package com.citybank.stmtdtlssvc.rest.client;

import javax.ws.rs.core.MediaType;

import com.citybank.statementdtls_schema.resp.StatementDtlsResType;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestResourceTest {
	public static void main(String[] args) {
		/*
		 * RestTemplate restTemplate=new RestTemplate(); StatementDtlsResType
		 * resp = restTemplate.getForObject(
		 * "http://localhost:9005/Rest-StatementDtlsSvc-Resource-war/rest/statement/getTransaction?cvv=123",
		 * StatementDtlsResType.class);
		 * System.out.println(resp.getStatusBlock().getRespMsg());
		 */

		Client client = Client.create();
		WebResource resource = client.resource(
				"http://localhost:9005/Rest-StatementDtlsSvc-Resource-war/rest/statement/getTransaction?cvv=123");
		ClientResponse response = resource.accept(MediaType.APPLICATION_XML).header("channel-id", "web")
				.get(ClientResponse.class);

		/*
		 * String resp=response.getEntity(String.class);
		 * System.out.println(resp);
		 */

		StatementDtlsResType resp = response.getEntity(StatementDtlsResType.class);

		System.out.println(resp.getStatusBlock().getRespCode());
	}
}
