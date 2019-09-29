/*
 * OfferDtlsServiceImpl.java	
 *  Copyright 2016 Natwest, Inc. All rights reserved.
 *  Natwest PROPRIETARY/CONFIDENTIAL. You should not disclose
 *  Information otherwise terms and conditions will apply.
 */
package com.sreenutech.powermockito;

/**
 * @Author : Sreenu Dandu
 * @Date : 26-Jan-2017
 @Version : 1.0
 @Descritpion :
 * 
 */
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import com.sreenutec.powermockito.SuppressConstructor;

public class SuppressConstructorTest {
	@Test
	public void supresses_own_constructor() throws Exception {
	SuppressConstructor nasty = Whitebox.newInstance(SuppressConstructor.class);
		assertNotNull(nasty);
	}
}
