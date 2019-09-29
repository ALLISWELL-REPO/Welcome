package com.sreenutech.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class OrderJson {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		Customer cust = new Customer();
		cust.setFname("sreenu");
		cust.setLname("tech");
		cust.setMobile(3438438438l);
		/*List<String> address = new ArrayList<String>();
		address.add("hyd");
		address.add("srnagar");
		address.add("hitechcity");
		cust.setAddress(address);*/
		
		Order r = new Order();
		r.setOid(121212);
		r.setOname("mobile");
		r.setOtype("ele");
		r.setDelviered(true);
		
		List<Order> orders = new ArrayList<Order>();
		orders.add(r);
		orders.add(r);
		orders.add(r);
		cust.setOrders(orders);
		
		Account acct = new Account();
		acct.setAccNum("43434343434");
		acct.setBal(1000);
		cust.setAccount(acct);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cust);
		System.out.println("json data is :"+json);
		

	}

}
