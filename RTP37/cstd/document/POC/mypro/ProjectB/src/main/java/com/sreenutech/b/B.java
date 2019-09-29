package com.sreenutech.b;

import com.sreenutech.project.b.beans.BReq;
import com.sreenutech.project.b.beans.BResp;

public class B {

public BResp m2(BReq breq )	{
	System.out.println("Enterd into B class");
	BResp bres=new BResp();
	bres.setDesc("deliverd");
	
	return bres;
	
}

	}


