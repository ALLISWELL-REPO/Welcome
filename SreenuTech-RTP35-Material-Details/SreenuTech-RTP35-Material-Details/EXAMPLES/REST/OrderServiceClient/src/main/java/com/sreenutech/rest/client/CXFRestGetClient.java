package com.sreenutech.rest.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;


public class CXFRestGetClient {

	public static void main(String[] args) {

		List<Object> providers = new ArrayList<Object>();
		providers.add(new JacksonJsonProvider());

		WebClient client = WebClient.create(
				"http://localhost:2015/06_jaxrs_BookService_json_usecase/rest/",
				providers);

		BookResp user = client.accept("application/json")
				.path("books").get(BookResp.class);

		System.out.println(user);
	}

}
