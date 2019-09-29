package com.citybank.stmtdtls.web.controller;

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
		System.out.println("Entered into pdf controller");

		String view = request.getParameter("view");
		int listSize = 0;
		HttpSession session = request.getSession();

		List<TransactionClient> listofTrans = (List<TransactionClient>) session
				.getAttribute("webtranslistSession");

		System.out.println("PDF controller list" + listofTrans);

		if ("pdf".equals(view)) {

			if (listofTrans != null) {
				System.out.println("PDF controller list" + listofTrans.size());

				listSize = listofTrans.size();

				return new ModelAndView("pdfview", "listofTrans", listofTrans);

			}

			else if ("excel".equals(view)) {
				return new ModelAndView("excelview", "listofTrans", listofTrans);

			}

		}

		System.out.println("exit from pdf/excel controller");

		return new ModelAndView("error");

	}

}
