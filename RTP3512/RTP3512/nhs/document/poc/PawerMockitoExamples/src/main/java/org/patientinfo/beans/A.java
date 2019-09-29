package org.patientinfo.beans;

import com.powermockito.beans.B;
import com.powermockito.beans.BReq;
import com.powermockito.beans.BRes;

public class A {
	public ARes createPatient(AReq req) {
		BReq req1 = new BReq();
		req.setPatientid(req.getPatientid());
		req.setNhsNumber(req.getNhsNumber());
		req.setFirstName(req.getFirstName());
		req.setLastName(req.getLastName());
		req.setGender(req.getGender());

		B b = new B();
		BRes res = b.createPatient(req1);
		ARes a = new ARes();
		a.setStatus(res.getStatus());

		System.out.println(a.getStatus());

		return a;

	}

}
