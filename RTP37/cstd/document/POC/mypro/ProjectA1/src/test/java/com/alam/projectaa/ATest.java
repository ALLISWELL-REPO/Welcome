package com.alam.projectaa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;

import com.alam.projecta.beans.AReq;
import com.alam.projecta.beans.AResp;
import com.sreenutech.b.B;
import com.sreenutech.project.b.beans.BReq;
import com.sreenutech.project.b.beans.BResp;
@RunWith(MockitoJUnitRunner.class)
public class ATest {
	A a=null;
	//B mockB=null;
	@Mock
	B mockB;
	
	@Before
	public void setUp(){
		
	//mockB=Mockito.mock(B.class);
	a=new A(mockB);
	}
	@Test
	public void testM1(){
		System.out.println("Enter into MockObject");
		BResp bres=new BResp();
		bres.setDesc("deliverd");
		
		Mockito.when(mockB.m2(Matchers.any(BReq.class))).thenReturn(bres);
		System.out.println("enter mockb");
		AReq areq=new AReq();
		AResp aresp=a.m1(areq);
		Assert.assertEquals("deliverd", aresp.getDesc());
		System.out.println("Exit from mock object");
	}
	@After
	public void tearDown(){
		
	}
}