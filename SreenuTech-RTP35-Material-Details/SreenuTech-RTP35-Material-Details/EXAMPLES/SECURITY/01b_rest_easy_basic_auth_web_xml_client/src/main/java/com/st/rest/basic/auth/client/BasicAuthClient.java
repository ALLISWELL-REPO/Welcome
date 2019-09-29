package com.st.rest.basic.auth.client;

import java.util.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class BasicAuthClient {
	
	public static void main(String args[]) throws Exception {
		
		// build authorization content
		String auth = "admin" + ":" + "password123";
		byte[] authBytes = Base64.getEncoder().encode(auth.getBytes());
		
		String authHeader = "Basic " + new String(authBytes); 
		
		// build a client and hit the service
		Client client  = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/01_rest_easy_role_based_auth_web_xml/services/customers")
				.request().header("Authorization", authHeader).get();
		
		if (response.getStatus() != 200) {
			throw new Exception("Service call failed with status: " + response.getStatus());
		}
		
		String respContent = response.readEntity(String.class);
		
		System.out.println("****** Response obtained from service call ******");
		System.out.println(respContent);
		System.out.println("----------------- ----------------- -------------");
	}

}
