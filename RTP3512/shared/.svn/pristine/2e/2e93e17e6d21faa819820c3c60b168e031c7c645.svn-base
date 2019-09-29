package com.st.spring.mvc.model;

import java.util.Arrays;

public enum Weekday {
	
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY;
	
	private Weekday() {
		
	}
	
	public static boolean isValid(String weekday) {
		boolean match = Arrays.stream(Weekday.values())
				.anyMatch(v -> v.name().equalsIgnoreCase(weekday));
		return match;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
