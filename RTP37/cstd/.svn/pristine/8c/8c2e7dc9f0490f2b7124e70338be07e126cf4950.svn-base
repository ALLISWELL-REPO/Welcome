package com.pack1.customer;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		CustomerMapper cusmap=(CustomerMapper) ctx.getBean("edao");
		List<Customer_details> list=cusmap.getDetails();
		for(Customer_details clist : list){
			System.out.println(clist);
		}
		

	}

}
