package com.sreenutech.rest.client;

import org.springframework.web.client.RestTemplate;

public class BooksRestClient {

	public static void main(String[] args) {
		
		RestTemplate template  = new RestTemplate();
		 //System.out.println(template.getForObject("http://localhost:2015/06_jaxrs_BookService_json_usecase/rest/books", String.class));

		
	BookResp resp = template.getForObject("http://localhost:2015/06_jaxrs_BookService_json_usecase/rest/books", BookResp.class);
	System.out.println("Response is :"+resp);
	
	}

}
