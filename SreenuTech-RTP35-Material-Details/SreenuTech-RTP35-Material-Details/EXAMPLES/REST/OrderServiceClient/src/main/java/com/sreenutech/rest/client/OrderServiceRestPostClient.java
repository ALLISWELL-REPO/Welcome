package com.sreenutech.rest.client;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.sreenutech.ordersreq.OrderReqtype;
import org.sreenutech.ordersres.OrderRestype;

public class OrderServiceRestPostClient {

	public static void main(String[] args) {

		RestTemplate template = new RestTemplate();

		OrderReqtype request = new OrderReqtype();
		request.setOid("12121");
		request.setName("mobile");
		String url = "http://localhost:2015/05_jaxrs_OrderServicePost_Example/rest/postOrders/info";
		/*OrderRestype response = template.postForObject(url, request, OrderRestype.class);
		System.out.println("response is :" + response.getStatus());*/
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_XML);
	
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		headers.set("cardnum", "121212");
		headers.set("date", "121212");
		headers.set("cardnum", "121212");

		HttpEntity<OrderReqtype> entityReq = new HttpEntity<OrderReqtype>(request, headers);
		
		
		ResponseEntity<OrderRestype> entiryResp = template.exchange(url, HttpMethod.POST, entityReq, OrderRestype.class);
		System.out.println("response is :" + entiryResp.getBody());
		
	
		OrderRestype response = entiryResp.getBody();
		if( response != null && response.getStatus() != null ){
			System.out.println("response is :" + entiryResp.getBody().getStatus());	
		}
		else{
			System.out.println("response is :" + response);
		}
		

	}

}
