package com.sreenutech;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.sreenutech.ordersreq.OrderReqtype;
import org.sreenutech.ordersres.OrderRestype;

public class SpringRestPostClient {

	public static void main(String[] args) {

		RestTemplate template = new RestTemplate();
		
		String url="http://localhost:2015/05_jaxrs_OrderServicePost_Example/rest/postOrders/info";
		
		OrderReqtype req = new OrderReqtype();
		req.setOid("12121");
		req.setName("mobile");
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();     

		headers.add("Accept", "application/json");
		
		HttpEntity entity = new HttpEntity(req, headers);
		
		 ResponseEntity<String> resp = template.exchange(url, HttpMethod.POST, entity, String.class);
		OrderRestype resp1 = template.postForObject(url, req, OrderRestype.class);
		//System.out.println("Response is :" + resp.getBody());

	}

}
