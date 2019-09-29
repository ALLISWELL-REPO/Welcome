/*
 * OfferDtlsServiceImpl.java	
 *  Copyright 2016 Natwest, Inc. All rights reserved.
 *  Natwest PROPRIETARY/CONFIDENTIAL. You should not disclose
 *  Information otherwise terms and conditions will apply.
 */
package com.sreenutec.powermockito;

/**
 * @Author : Sreenu Dandu
 * @Date : 26-Jan-2017
 * @Version : 1.0
 * @Descritpion :
 * 
 */
public class StaticInitializationBlock {
	public static int value;
	static {
		
		value = 100 / 0;
		System.out.println("In static block");
	}
}
