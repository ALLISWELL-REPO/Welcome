package com.citybank.statementdtls.process.valuebeans;

import java.util.Calendar;
import java.util.Date;

public class DiffrenceBtYear {

	public static int diffrenceYear(Date startDate, Date endDate) {
		long days = endDate.getTime() - startDate.getTime();
		int day = (int) (days / (1000 * 60 * 60 * 24));
		return day;

	}

	public static void main(String[] args) {
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, -90);
		Date startDate = Calendar.getInstance().getTime();
		Date endDate = Calendar.getInstance().getTime();
		System.out.println(diffrenceYear(startDate, endDate));

	}

}
