package com.sreenutech.rest.client;

import org.springframework.util.SystemPropertyUtils;
import org.sreenutech.ordersreq.OrderReqtype;
import org.sreenutech.ordersres.OrderRestype;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class OrderServiceRestClient {

	public static void main(String[] args) {
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:2015/05_jaxrs_OrderServicePost_Example/rest/postOrders/info");
		//resource.setProperty("cardnum", "1212121");
		//String request = "<OrderReqtype><oid>12121</oid><name>mobile</name></OrderReqtype>";
		OrderReqtype request = new OrderReqtype();
		request.setOid("12121");
		request.setName("mobile");
		
	ClientResponse response = resource.type("application/xml").header("cardnum", "1212121").post(ClientResponse.class, request);
	String resp = response.getEntity(String.class);
	System.out.println("service response is :"+resp);
	
	/*OrderRestype response1  = response.getEntity(OrderRestype.class);
	System.out.println(" response is :"+response1);
	System.out.println(" response is :"+response1.getStatus());
*/
	}

}
