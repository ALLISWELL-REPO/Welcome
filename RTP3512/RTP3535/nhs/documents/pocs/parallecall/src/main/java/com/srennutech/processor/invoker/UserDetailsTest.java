package com.srennutech.processor.invoker;

import java.util.concurrent.ExecutionException;

import com.sreenutech.beans.UserDetails;
import com.sreenutech.processor.UserDetailsProcessor;

public class UserDetailsTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		UserDetailsProcessor processor=new UserDetailsProcessor();
		UserDetails userDetails = processor.getUser("1234");
		System.out.println(userDetails);
	}

}
