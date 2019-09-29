package com.sreenutech;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.sreenutech.ordersreq.OrderReqtype;
import org.sreenutech.ordersres.OrderRestype;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JersyRestPostClient {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		//1. create the client Object
		Client client = Client.create();
		//2. Using client object get the webResource Object
		WebResource resource = client.resource("http://localhost:2015/05_jaxrs_OrderServicePost_Example/rest/postOrders/info");
        //3. prepare the request object
		OrderReqtype req = new OrderReqtype();
		req.setOid("12121");
		req.setName("mobile");
		
		//3. Using webResource Object invoke the service
		
		ClientResponse response = resource.type("application/xml").accept("application/json").post(ClientResponse.class,req);
				
		//String resp = response.getEntity(String.class);
		String resp = response.getEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		OrderRestype resp1 = mapper.readValue(resp, OrderRestype.class);
		
		System.out.println("response is :"+resp1.getStatus());
		//System.out.println("response is :"+resp.getStatus());
				
		
		

	}

}
