package com.sreenutech;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JersyRestClient {

	public static void main(String[] args) {
		
		//1. create the client Object
		Client client = Client.create();
		//2. Using client object get the webResource Object
		WebResource resource = client.resource
		("http://localhost:2015/01_jaxrs_path_example/rest/orderregx/12121");
		//3. Using webResource Object invoke the service
		ClientResponse response = resource.accept("text/xml").get(ClientResponse.class);
		String resp = response.getEntity(String.class);
		System.out.println("resp is :"+resp);
		

	}

}
