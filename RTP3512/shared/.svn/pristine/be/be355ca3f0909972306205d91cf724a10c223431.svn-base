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
import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sreenutec.powermockito.PrivateMethod;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PrivateMethod.class)
public class PrivateMethodTest {
	@Test
	public void stubs_private_methods() throws Exception {
		PrivateMethod privateMethodClass = spy(new PrivateMethod());
	when(privateMethodClass, "secretValue").thenReturn("123");
		assertEquals("123", privateMethodClass.exposeTheSecretValue());
	}
}
