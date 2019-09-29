package com.citybank.stmtdtlssvc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.beans.TransactionClient;

@Controller

public class SortingPaginationController {
	private static final int pageSize = 4;
	List<TransactionClient> transList = null;

	@RequestMapping(value = "pagination", method = RequestMethod.GET)
	public String pagination(HttpServletRequest request, Model model) {
		System.out.println("enter into pagination controller");
		HttpSession session = request.getSession();
		transList = (List<TransactionClient>) session.getAttribute("webtranslistSession");
		System.out.println(transList.size());
		int currentPageNo = 0;
		int noOfRecords = transList.size();
		int noOfPages = 0;

		String action = request.getParameter("action");
		System.out.println("action " + action);
		if (action == null) {
			currentPageNo = 1;
		} else {
			currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
			if ("prev".equals(action)) {
				currentPageNo--;
			} else if ("next".equals(action)) {
				currentPageNo++;
			}
		}
		if (noOfRecords % pageSize == 0) {
			noOfPages = noOfRecords / pageSize;
		} else {
			noOfPages = (noOfRecords / pageSize) + 1;
		}
		List<TransactionClient> pagedList = processPagination(pageSize, currentPageNo);
		model.addAttribute("pagedList", pagedList);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("noOfPages", noOfPages);
		System.out.println("currentPageNo " + currentPageNo);
		
		//extra logic
		StatementDtlsWebRes webRes=(StatementDtlsWebRes)session.getAttribute("webResSession");
		int listSize=webRes.getWebTransList().size();
		model.addAttribute("listSize", listSize);
		model.addAttribute("webRes", webRes);
		
		System.out.println("exit from pagination controller");
		return "ministatement";
	}

	private List<TransactionClient> processPagination(int pagesize, int currentPageNo) {
		System.out.println("enter into processPagination ");
		int startIndex = 0;
		int endIndex = 0;
		List<TransactionClient> pagedList = new ArrayList<TransactionClient>();
		startIndex = (pagesize * currentPageNo) - (pagesize);
		endIndex = (pagesize * currentPageNo) - 1;
		int record = 0;
		for (TransactionClient transaction : transList) {
			while (record <= endIndex) {
				if (record >= startIndex) {
					pagedList.add(transList.get(record));
					System.out.println("record value " + record);
				}
				
				record++;
			}
		}
		System.out.println("pagedList.size() " + pagedList.size());
		System.out.println("exit from processPagination ");
		return pagedList;
	}

}
