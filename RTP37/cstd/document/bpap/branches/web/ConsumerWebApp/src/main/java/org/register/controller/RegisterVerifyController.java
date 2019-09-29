package org.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.o2.register.svc.client.bean.RegisterSvcWebReq;
import org.o2.register.svc.client.bean.RegisterSvcWebRes;
import org.o2.register.svc.client.impl.RegisterSvcClientImpl;
import org.register.beans.O2RegResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import o2.register.formdata.O2RegistrationFormData;
import o2.register.springconfig.SpringConfig;

@Controller
public class RegisterVerifyController {

	@Autowired
	private O2RegResp resp ;
	
	//loading SpringSonfig class  
	ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
	
	/*
	@Autowired
	private RegisterSvcWebReq wsReq;
	*/
	
	
	@RequestMapping(value = "/registerverify", method = RequestMethod.POST)
	public O2RegResp processInVerify(@ModelAttribute O2RegistrationFormData regFormData, Model model,
			HttpServletRequest req) {

		//getting clientLayer object by using  dependency lookup 
		RegisterSvcWebReq wsReq=context.getBean(RegisterSvcWebReq.class);
		RegisterSvcClientImpl clientImpl=context.getBean(RegisterSvcClientImpl.class);
		
		
		HttpSession session = req.getSession();
		regFormData = (O2RegistrationFormData) session.getAttribute("regFormData");
		String accId = (String) session.getAttribute("accId");
		System.out.println("RegisterVerifyController::" + regFormData+"AcId::"+accId);
		
		//O2RegResp resp = new O2RegResp();
        
		//RegisterSvcClientImpl clientImpl=new RegisterSvcClientImpl();   
		//RegisterSvcWebReq wsReq=new RegisterSvcWebReq();
		
		//prpared wsReq
		wsReq.setAccNumber(accId);
		wsReq.setCardNum(regFormData.getCardNumb());
		wsReq.setCvv(regFormData.getCvv());
		wsReq.setExpDate(regFormData.getExpDate());
		wsReq.setNameOnCard(regFormData.getNameOnCard());
		wsReq.setMobileNum(regFormData.getMobNo());
		
		RegisterSvcWebRes wsResp = clientImpl.enrollment(wsReq);
		System.out.println(wsResp);
		resp.setRespCode(wsResp.getRespCode());
		resp.setRespMsg(wsResp.getRespMsg());
		
		return resp;
	}

}
