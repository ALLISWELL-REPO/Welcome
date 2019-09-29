package com.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoJunitTest {
	@BeforeClass
	public static void beforeOnlyOnceForTest(){
		System.out.println("Before Class test");
	}
	
	@Before
	public void setUp(){
		System.out.println("setUp() execute");
	}
	
	@Test
	public void testM1(){
		System.out.println("testM1() execute");
	}
	
	@Test
	public void testM2(){
		System.out.println("testM2() execute");
	}
	
	@After
	public void tearDown(){
		System.out.println("tearDown() execute");
	}
	
	@AfterClass
	public static void afterOnlyOnceForTest(){
		System.out.println("After Class test");
	}

}
