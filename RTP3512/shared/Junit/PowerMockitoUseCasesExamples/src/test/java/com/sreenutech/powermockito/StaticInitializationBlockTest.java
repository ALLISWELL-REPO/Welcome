/*
 * OfferDtlsServiceImpl.java	
 *  Copyright 2016 Natwest, Inc. All rights reserved.
 *  Natwest PROPRIETARY/CONFIDENTIAL. You should not disclose
 *  Information otherwise terms and conditions will apply.
 */
package com.sreenutech.powermockito;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sreenutec.powermockito.StaticInitializationBlock;

@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("com.sreenutech.powermockito.StaticInitializationBlock")
public class StaticInitializationBlockTest {
	@Test
	public void supresses_static_initialization_blocks() {
		assertEquals(0, StaticInitializationBlock.value);
	}
}
