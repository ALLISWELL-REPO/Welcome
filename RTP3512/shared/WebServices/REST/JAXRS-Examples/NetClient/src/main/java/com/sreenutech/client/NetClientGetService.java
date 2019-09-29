package com.sreenutech.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetClientGetService {

	public static void main(String[] args) throws IOException {
		
		//1. Create URL object
		URL url = new URL("http://localhost:2017/01_jaxrs_helloworld_jersy_example/rest/hellores/abc");
		
		//2. Using URL get the connection object
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "text/xml");
			
		//3. Invoke the service
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		String line = br.readLine();
		
		while( line != null ){
			System.out.println(line);
			line = br.readLine();
		}
		
		

	}

}
