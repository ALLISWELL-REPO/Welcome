package com.citybank.stmtdtls.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citybank.stmtdtls.web.beans.CustomerDetails;
import com.citybank.stmtdtlssvc.client.StatementDtlsSvcClient;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.beans.TransactionClient;

@Controller
@RequestMapping("statementdetails.mvc")
public class StatementInfoController {

	@Autowired
	protected StatementDtlsSvcClient statementDtlsSvcClient;

	@RequestMapping(method = RequestMethod.GET)
	public String getTransaction(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		CustomerDetails customerDetails = (CustomerDetails) session
				.getAttribute("custDetailssession");
		System.out.println(customerDetails.getCardNumber());

		StatementDtlsWebReq webReq = new StatementDtlsWebReq();

		webReq.setCardnum(customerDetails.getCardNumber());
		webReq.setCvvnum(customerDetails.getCvv());
		webReq.setExpdate(customerDetails.getExpDate());
		webReq.setNameoncard(customerDetails.getNameOnCard());

		StatementDtlsWebRes webRes = statementDtlsSvcClient
				.getTransactions(webReq);

		System.out.println("controller" + webRes.getExpncode());
		System.out.println("controller list" + webRes.getWebTransList().size());

		List<TransactionClient> webtranslist = webRes.getWebTransList();

		int listSize = webtranslist.size();
		System.out.println(listSize);
		session.setAttribute("webResSession", webRes);
		session.setAttribute("webtranslistSession", webtranslist);
		return "statementdetails";
	}

}
