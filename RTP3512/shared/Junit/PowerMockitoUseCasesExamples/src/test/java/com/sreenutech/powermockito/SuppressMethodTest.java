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
import static org.junit.Assert.assertFalse;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sreenutec.powermockito.SuppressMethod;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SuppressMethod.class)
public class SuppressMethodTest {
	@Test
	public void supresses_method() throws Exception {
		suppress(method(SuppressMethod.class, "getCurrency"));
		SuppressMethod method = new SuppressMethod();
		assertFalse(method.format("10").contains("$"));
	}
}
