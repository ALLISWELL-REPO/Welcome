package com.alam.projectaa;

import com.alam.projecta.beans.AReq;
import com.alam.projecta.beans.AResp;
import com.sreenutech.b.B;
import com.sreenutech.project.b.beans.BReq;
import com.sreenutech.project.b.beans.BResp;

public class A {
	B b = null;

	public A(B b) {
		this.b = b;
	}

	public AResp m1(AReq areq) {
		System.out.println("Entered into A class");
		BReq breq = new BReq();
		breq.setOid(areq.getOid());
		breq.setName(areq.getName());

		// backend b call

		BResp bresp = b.m2(breq);

		AResp aresp = new AResp();
		aresp.setDesc(bresp.getDesc());

		return aresp;

	}

}