package com.citybank.stmtdtls.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citybank.stmtdtls.web.beans.UserDetailsDemonObject;
import com.citybank.stmtdtlssvc.client.StatementDtlsSvcClient;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.beans.TransactionClient;

@Controller
@RequestMapping("/transactionfrm.mvc")

public class StatementDetailsController {

	@Autowired
	protected StatementDtlsSvcClient statementDtlsSvcClient ;

	@RequestMapping(method = RequestMethod.GET)
	public String getSampleForm() {
		return "transactionform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String getTransactionStatement(
			@ModelAttribute UserDetailsDemonObject reqCommand, Model model) {

		System.out.println("Controller");
		StatementDtlsWebReq webReq = new StatementDtlsWebReq();

		webReq.setCardnum(reqCommand.getCardnum());

		webReq.setCvvnum(reqCommand.getCvvnum());
		webReq.setNameoncard(reqCommand.getNameoncard());
		webReq.setExpdate(reqCommand.getExpdate());
		webReq.setTypeOfCategory(reqCommand.getTypeOfCategory());
		webReq.setStartdate(reqCommand.getStartdate());
		webReq.setEnddate(reqCommand.getEnddate());

		StatementDtlsWebRes webRes = statementDtlsSvcClient
				.getTransactions(webReq);

		System.out.println(webRes.getExpncode());
		System.out.println(webRes.getWebTransList().size());

		model.addAttribute("weRes", webRes);

		List<TransactionClient> webtranslist = webRes.getWebTransList();
		model.addAttribute("webtranslist", webtranslist);

		return "success";

	}

	/*public StatementDtlsSvcClient getStatementDtlsSvcClient() {

		return statementDtlsSvcClient;
	}

	public void setStatementDtlsSvcClient(
			StatementDtlsSvcClient statementDtlsSvcClient) {

		this.statementDtlsSvcClient = statementDtlsSvcClient;

	}
*/
}
