package com.sreenutech;

import org.springframework.web.client.RestTemplate;

public class SpringRestClient {

	public static void main(String[] args) {

		RestTemplate template = new RestTemplate();
		String resp = template.getForObject("http://localhost:2015/01_jaxrs_path_example/rest/orderregx/12121",
				String.class);
		System.out.println("Response is :" + resp);

	}

}
