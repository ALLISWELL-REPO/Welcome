package com.sreenutech.test;

import java.util.concurrent.ExecutionException;

import com.sreenutech.beans.UserDetails;
import com.sreenutech.processer.UserProcesser;

public class Test {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		UserProcesser process = new UserProcesser();
		UserDetails details = new UserDetails();
		details.getuId();

		process.getUser(details.getuId());
		System.out.println(process);
	}

}
