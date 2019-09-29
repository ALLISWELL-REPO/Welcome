package com.sreenutech.projecta;

import com.sreenutech.projecta.beans.AReq;
import com.sreenutech.projecta.beans.AResp;
import com.sreenutech.projectb.B;
import com.sreenutech.projectb.beans.BReq;
import com.sreenutech.projectb.beans.BResp;
import com.sreenutech.projectc.C;

public class A {
	//B b;
	//C c;
	public A(){
		//this.b = b;
		//this.c = c;
		
	}
	
	public AResp m1(AReq areq) {
		AResp aresp = null;
		try {
			System.out.println("Entered into A class");
			BReq breq = new BReq();
			breq.setOid(areq.getOid());
			breq.setName(areq.getName());
			//backend b call
			B b = new B();
			BResp bresp = b.m1(breq);
			//cakend c all
			float price = C.m1(areq.getOid());
			aresp = new AResp();
			aresp.setDesc(bresp.getDesc());
			aresp.setPrice(price);
		} catch (Exception e) {
			System.out.println("enetered into exception");
			
			e.printStackTrace();
		}
		
		return aresp;
		
	}
	
}
