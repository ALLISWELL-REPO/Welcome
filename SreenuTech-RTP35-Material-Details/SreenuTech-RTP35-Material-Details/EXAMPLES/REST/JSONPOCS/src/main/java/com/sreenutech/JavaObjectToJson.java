package com.sreenutech;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sreenutech.beans.Account;
import com.sreenutech.beans.CustomerDetails;
import com.sreenutech.beans.Order;
import com.sreenutech.beans.Orders;

public class JavaObjectToJson {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		//Prepare the java Object with the help of artifacts
		CustomerDetails custDtls = new CustomerDetails();
		custDtls.setId("212");
		//custDtls.setFname("sreenu");
		//custDtls.setLname("tech");
		//custDtls.setMobileNo("99667485496");
		//custDtls.setEmailid("sreenu.wsi@gmail.com");
		//prepare the address objs
		List<String> addresses = new ArrayList<String>();
		addresses.add("HomeAddress : S.R.Nagar");
		addresses.add("Office Address : HitechCity");
		addresses.add("Permanent Address : Hyderabad");
		custDtls.setAddresses(addresses);
		Orders orders = new Orders();
		//prepare orderList objects
		List<Order> orderList = new ArrayList<Order>();
		Order order = new Order();
		order.setoId("1244");
		order.setName("mobile");
		order.setPrice("35000");
		order.setOdate("20-01-02917");
		order.setCurrency("$");
		//order.setDesc("good order");
		
		orderList.add(order);
		orderList.add(order);
		orderList.add(order);
		orders.setOrder(orderList);
		//set Orders 
		custDtls.setOrders(orders);
		//Prepare the Account Object
		Account account = new Account();
		account.setCardNumber(454354545);
		account.setCvvNumber(123);
		account.setNameOnCard("Sreenu");
		account.setTypeOfBank("HDFC");
		//set Accounts
		custDtls.setAccount(account);
		
		// convert java object  to JSON : writeValue(...)
		
		ObjectMapper mapper = new ObjectMapper();
		 //mapper.disable(MapperFeature.USE_ANNOTATIONS);
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		//mapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:\\Sreenu-Stuff\\WebServices\\JAXRS\\JSON-WorkSpace\\JSONExamples\\src\\main\\resources\\file.json"), custDtls);
		
		String jsonData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(custDtls);
		System.out.println(jsonData);

	}

}
