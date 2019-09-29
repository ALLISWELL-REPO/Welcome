package com.citybank.stmtdtlssvc.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.beans.TransactionClient;
import com.citybank.stmtdtlssvc.rest.client.StatementSvcClientImpl;
import com.citybank.stmtdtlssvc.web.beans.CustomerDetails;

@Controller
@RequestMapping("statementdetails.mvc")
public class StatementInfoController {
	
	protected StatementSvcClientImpl restClientImpl = new StatementSvcClientImpl();

	@RequestMapping(method = RequestMethod.GET)
	public String getTransaction(HttpServletRequest request,Model model) throws JsonParseException, JsonMappingException, IOException {
		HttpSession session = request.getSession();
		CustomerDetails customerDetails = (CustomerDetails) session.getAttribute("custDetailssession");
		System.out.println("card Number "+customerDetails.getCardNumber());
		StatementDtlsWebReq webReq = new StatementDtlsWebReq();

		webReq.setCardNum(customerDetails.getCardNumber());
		webReq.setCvvNum(Integer.valueOf(customerDetails.getCvv()));
		webReq.setExpDate(customerDetails.getExpDate());
		webReq.setNameOnCard(customerDetails.getNameOnCard());

		StatementDtlsWebRes webRes = restClientImpl.getTransactions(webReq);
        System.out.println("webRes "+webRes);
		System.out.println("controller"+webRes.getRespCode());
		System.out.println("controller list "+webRes.getWebTransList().size());
		
		
		List<TransactionClient> webtranslist=webRes.getWebTransList();
		int listSize=webtranslist.size();
	
		
		/*model.addAttribute("webtranslist", webtranslist);
		model.addAttribute("listSize", listSize);
		model.addAttribute("webRes", webRes);*/
		
		
		session.setAttribute("webResSession", webRes);
		session.setAttribute("webtranslistSession", webtranslist);
		
		return "statementdetails";
	}

	
	
}
