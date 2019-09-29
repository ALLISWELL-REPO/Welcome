package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citybank.card.stmtsvc.client.beans.StatementDtlsWebReq;
import com.citybank.card.stmtsvc.client.beans.StatementDtlsWebResp;
import com.citybank.card.stmtsvc.client.beans.TransactionRespProcess;
import com.citybank.card.stmtsvc.client.impl.StatementDtlsSvcClientImpl;

@Controller
public class StatementController {
	@RequestMapping(value = "/statementInfo.html", method = RequestMethod.POST)
	public String getStatementInfo(HttpServletRequest request, HttpServletResponse response,Model model) {
		System.out.println("Entered into Controller");
		String page = null;

		StatementDtlsWebResp webRes;
		// Get httpReq from client and store in webReq
		StatementDtlsWebReq webReq = new StatementDtlsWebReq();
		webReq.setCardNum(request.getParameter("cardNum"));
		webReq.setCvvNum(request.getParameter("cvvNum"));
		webReq.setExpDate(request.getParameter("expDate"));
		webReq.setNameOnCard(request.getParameter("nameOnCard"));
		// Create client object and call the getTransaction(webReq) method
		StatementDtlsSvcClientImpl client = new StatementDtlsSvcClientImpl();
		webRes = client.getTransactions(webReq);
		System.out.println("after controller");
		List<TransactionRespProcess> webList=webRes.getTransResProcess();
		System.out.println("=================="+webList);
		model.addAttribute("webList", webList);
		System.out.println("end");
		return "success";
	}
}