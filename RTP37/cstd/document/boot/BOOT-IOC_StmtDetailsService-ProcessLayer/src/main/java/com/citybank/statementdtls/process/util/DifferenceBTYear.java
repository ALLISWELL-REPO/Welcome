package com.citybank.statementdtls.process.util;

import java.util.Calendar;
import java.util.Date;

public class DifferenceBTYear {
	public static int diferrence(Date startDate, Date endDate) {
		long days = endDate.getTime()-startDate.getTime();
		int day=(int) (days/(1000*60*60*24));
		return day;
	}

	public static void main(String[] args) {
		Date endDate=Calendar.getInstance().getTime();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -90);
		Date startDate = calendar.getTime();
		endDate = Calendar.getInstance().getTime();
		System.out.println(diferrence(startDate, endDate));
	}

}
