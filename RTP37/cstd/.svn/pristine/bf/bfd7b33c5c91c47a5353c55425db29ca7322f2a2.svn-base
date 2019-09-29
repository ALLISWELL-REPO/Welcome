package com.alam.ajax.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alam.ajax.bean.StatementWebResponse;
import com.alam.ajax.bean.Transaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StatementServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String cardNum = request.getParameter("cardNum");
		String cvv = request.getParameter("cvv");
		String nameOnCard = request.getParameter("nameOnCard");

		System.out.println(cardNum);
		System.out.println(cvv);
		System.out.println(nameOnCard);

		response.setContentType("application/json");

		List<Transaction> transactions = new ArrayList<Transaction>();
		for (int i = 0; i <= 5; i++) {
			Transaction tran = new Transaction();
			tran.setTransId("TRANS" + i);
			tran.setMerchantname("MERCHANT" + i);
			tran.setDate(new Date().toString());
			tran.setDesc("TRANSDESC" + i);
			tran.setAmount(1000 * i);
			tran.setStatus("success");
			tran.setRemarks("NA");
			transactions.add(tran);
		}
		StatementWebResponse webResp=new StatementWebResponse();
		webResp.setRespCode("0000");
		webResp.setResMsg("success");
		webResp.setTransList(transactions);
		/*ObjectMapper mapper=new ObjectMapper();
		String writeValueString=mapper.*/
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String jsonResponse=gson.toJson(webResp);
		System.out.println(jsonResponse);
		out.println(jsonResponse);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
