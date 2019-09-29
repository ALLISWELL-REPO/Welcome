package com.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DemoCalender {

	public static String convertXmlGregorain(XMLGregorianCalendar xgre) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		GregorianCalendar gcalender = xgre.toGregorianCalendar();
		Date date = gcalender.getTime();
		String dateString = sdf.format(date);
		return dateString;
	}

	public static void main(String[] args) throws DatatypeConfigurationException {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		System.out.println(convertXmlGregorain(xgcal));
	}

}
