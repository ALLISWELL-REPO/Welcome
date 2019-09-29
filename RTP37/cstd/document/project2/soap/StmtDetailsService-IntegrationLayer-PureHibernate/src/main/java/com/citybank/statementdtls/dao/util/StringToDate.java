package com.citybank.statementdtls.dao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	public static Date convertStringToDate(String sDate){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Date date=null;
		try {
			date = sdf.parse(sDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return date;
	}
	public static void main(String[] args) {
		Date date = convertStringToDate("2018-04-02");
		System.out.println(date);
	}
}
