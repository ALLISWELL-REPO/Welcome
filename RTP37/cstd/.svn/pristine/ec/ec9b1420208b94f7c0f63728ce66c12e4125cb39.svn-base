package com.alam.spring_with_rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.alam.artifact.orderreq.OrderReqtype;
import com.alam.artifact.orderres.OrderRestype;

public class Spring_Rest_GetClient {

	public static void main(String[] args) throws RestClientException, URISyntaxException {
	RestTemplate template=new RestTemplate();
	OrderReqtype request=new OrderReqtype();
	request.setOid("123");
	request.setName("mobile");
	String uri="http://localhost:8454/04_Rest_Jersey_OrderServicePostExample/rest/a1/b1";
	OrderRestype response=template.postForObject(new URI(uri), request, OrderRestype.class);
	System.out.println(response);
	
	

	}

}
