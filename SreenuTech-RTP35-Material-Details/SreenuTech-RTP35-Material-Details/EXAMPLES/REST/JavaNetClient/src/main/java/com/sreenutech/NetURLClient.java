package com.sreenutech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetURLClient {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://localhost:2015/01_jaxrs_helloworld_jersy_example/rest/hellores/abc");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "text/xml");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String line = br.readLine();
		while( line != null ){
		System.out.println("line is :"+line);
		line = br.readLine();
			
		}

	}

}
