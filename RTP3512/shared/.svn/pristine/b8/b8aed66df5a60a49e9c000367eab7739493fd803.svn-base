/*
 * OfferDtlsServiceImpl.java	
 *  Copyright 2016 Natwest, Inc. All rights reserved.
 *  Natwest PROPRIETARY/CONFIDENTIAL. You should not disclose
 *  Information otherwise terms and conditions will apply.
 */
package com.sreenutech.powermockito;

import static org.junit.Assert.*;
import static org.powermock.api.support.membermodification.MemberMatcher.constructor;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sreenutec.powermockito.DontExtendMePlease;
import com.sreenutec.powermockito.SuppressSuperConstructor;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SuppressSuperConstructor.class)
public class SuppressSuperConstructorTest {
	@Test
	public void supresses_super_class_constructor() {
		suppress(constructor(DontExtendMePlease.class));
		new SuppressSuperConstructor();
		assertTrue("Just checking", true);
	}
}
