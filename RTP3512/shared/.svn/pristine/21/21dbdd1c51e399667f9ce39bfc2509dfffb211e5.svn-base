package com.sreenutech;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.sreenutech.ordersreq.OrderReqtype;
import org.sreenutech.ordersres.OrderRestype;

public class SpringRestGetClient {

	public static void main(String[] args) throws RestClientException, URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		/*String response = restTemplate.getForObject("http://localhost:2017/01_jaxrs_helloworld_jersy_example/rest/hellores/abc", String.class);
		System.out.println("Response is :"+response);*/
		
		 OrderReqtype req = new OrderReqtype();
		 req.setOid("12121");
		 req.setName("mobile");
		 String uri = "http://localhost:2017/05_jaxrs_OrderServicePost_Example/rest/postOrders/info";
		 OrderRestype response = restTemplate.postForObject(new URI(uri), req, OrderRestype.class);
		 System.out.println(response);
		
		

	}

}
