package com.app;

import java.util.Calendar;
import java.util.Date;

public class DiffYear {
	public static int diffrence(Date startDate, Date endDate) {
		long days = endDate.getTime() - startDate.getTime();
		int day = (int) (days / (1000 * 60 * 60 * 24));
		return day;
	}

	public static void main(String[] args) {
		Date endDate = Calendar.getInstance().getTime();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -90);
		Date startDate = Calendar.getInstance().getTime();
		 endDate = Calendar.getInstance().getTime();
		System.out.println(diffrence(startDate, endDate));

	}

}
