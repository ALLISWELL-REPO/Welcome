package com.citybank.stmtdtlssvc.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citybank.stmtdtlssvc.client.StatementDtlsSvcClient;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.beans.TransactionClient;
import com.citybank.stmtdtlssvc.web.beans.UserDetailsHttpReqCommad;

@Controller
@RequestMapping("/trasactionfrm.mvc")
public class StatementDetailsController {
	@Autowired
	protected StatementDtlsSvcClient statementDtlsSvcClient=null;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getSampleForm() {
		return "trasactionform";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getTransactionStatememts(@ModelAttribute UserDetailsHttpReqCommad reqCommad,Model model) {
	    System.out.println("controller");
		StatementDtlsWebReq webReq=new StatementDtlsWebReq();
		webReq.setCardNum(reqCommad.getCardNum());
		webReq.setCvvNum(reqCommad.getCvvNum());
		webReq.setEndDate(reqCommad.getEndDate());
		webReq.setExpDate(reqCommad.getExpDate());
		webReq.setNameOnCard(reqCommad.getNameOnCard());
		webReq.setStartDate(reqCommad.getStartDate());
		webReq.setTypeOfCate(reqCommad.getTypeOfCate());
		
		
		StatementDtlsWebRes webRes = statementDtlsSvcClient.getTrasactions(webReq);
		
		System.out.println(webRes.getRespCode());
	
		
		
		model.addAttribute("webRes", webRes);
		
                                       		
		List<TransactionClient> webtranslist=webRes.getWebTransList();
		int listSize=webtranslist.size();
		model.addAttribute("webtranslist", webtranslist);
		model.addAttribute("listSize", listSize);
		return "success";
	}
	public StatementDtlsSvcClient getStatementDtlsSvcClient() {
		return statementDtlsSvcClient;
	}
	public void setStatementDtlsSvcClient(StatementDtlsSvcClient statementDtlsSvcClient) {
		this.statementDtlsSvcClient = statementDtlsSvcClient;
	}
	/*public static void main(String[] args) {
		StatementDetailsController controller=new StatementDetailsController();
		UserDetailsHttpReqCommad reqCommad=new UserDetailsHttpReqCommad();
		reqCommad.setCardNum("11223344");
		reqCommad.setCvvNum(123);
		reqCommad.setEndDate("01-06-2018");
		reqCommad.setExpDate("11/22");
		reqCommad.setNameOnCard("arun sunny");
		reqCommad.setStartDate("01-04-2018");
		reqCommad.setTypeOfCate("ALL");
		controller.getTransactionStatememts(reqCommad);
	}*/
	
}
