package org.nhs.patientinfosrv.service.builders;

import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbRes;
import org.nhs.patientinfo.v1.schemas.res.PatientInfoResType;
import org.nhs.patientinfo.v1.schemas.res.StatusType;

public class PatientInfoResBuilder {

	public PatientInfoResType buildProcessRes(PatientInfoProcessVbRes vRes) {
		PatientInfoResType vv=new PatientInfoResType();
		 StatusType type=new StatusType();
         type.setResMsg(vRes.getResMsg());
         type.setRespCode(vRes.getRespCode());
                 vv.setStatus(type);
		return vv;
	}

	
	

}
