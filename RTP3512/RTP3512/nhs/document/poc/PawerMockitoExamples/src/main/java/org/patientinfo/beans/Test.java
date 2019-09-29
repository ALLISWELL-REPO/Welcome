package org.patientinfo.beans;

public class Test {
	public static void main(String args[])
	{
		
		 A a=new A();
		   AReq req =new AReq();
		ARes res = a.createPatient(req );
		     res.getStatus();
		  System.out.println("this is the response is db:"+res) ;  
		 
		
	}

}
