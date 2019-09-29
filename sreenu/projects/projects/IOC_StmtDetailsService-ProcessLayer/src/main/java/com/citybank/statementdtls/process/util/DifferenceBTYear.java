package com.citybank.statementdtls.process.util;

import java.util.Calendar;
import java.util.Date;

public class DifferenceBTYear {

	public static int difference(Date startDate, Date endDate) {

		long days = endDate.getTime() - startDate.getTime();
		int day = (int) (days / (1000 * 60 * 60 * 24));
		return day;

	}

	public static void main(String[] args) {

		// Date endDate = Calender.get

		Date endDate = Calendar.getInstance().getTime();
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, -90);

		Date startDate = calender.getTime();
		endDate = Calendar.getInstance().getTime();
		System.out.println(difference(startDate, endDate));

	}

}
