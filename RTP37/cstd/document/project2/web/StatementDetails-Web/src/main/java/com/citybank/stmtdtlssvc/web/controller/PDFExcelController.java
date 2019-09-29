package com.citybank.stmtdtlssvc.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.citybank.stmtdtlssvc.client.beans.TransactionClient;

@Controller
@RequestMapping("download")
public class PDFExcelController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView pdfDownload(HttpServletRequest request, Model model) {
		System.out.println("enter into pdf controller");
		String view = request.getParameter("view");
		int listSize = 0;
		HttpSession session = request.getSession();
		List<TransactionClient> listOfTrans = (List<TransactionClient>) session.getAttribute("webtranslistSession");

		System.out.println("pdf controllor list  " + listOfTrans);
		if ("pdf".equals(view)) {
			if (listOfTrans != null) {
				System.out.println("pdf controllor list size " + listOfTrans.size());
				listSize = listOfTrans.size();
				return new ModelAndView("pdfView", "listOfTrans", listOfTrans);
			}
		}else if("excel".equals(view)){
			return new ModelAndView("excelView", "listOfTrans", listOfTrans);
		}

		System.out.println("exit from  pdf controller");
		return new ModelAndView("error");
	}

}
