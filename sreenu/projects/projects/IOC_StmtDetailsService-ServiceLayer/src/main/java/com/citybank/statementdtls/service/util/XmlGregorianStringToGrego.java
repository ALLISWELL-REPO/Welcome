package com.citybank.statementdtls.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XmlGregorianStringToGrego {

	public static XMLGregorianCalendar getGregorianCalendar(String sdate) {

		XMLGregorianCalendar xgcal = null;
		GregorianCalendar gcal = new GregorianCalendar();
		Date date = null;
		try {

			date = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		gcal.setTime(date);
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}

		return xgcal;
	}
	
	public static void main(String[] args) {
		
		XMLGregorianCalendar xgc = getGregorianCalendar("2017-06-23");
		
	}

}
