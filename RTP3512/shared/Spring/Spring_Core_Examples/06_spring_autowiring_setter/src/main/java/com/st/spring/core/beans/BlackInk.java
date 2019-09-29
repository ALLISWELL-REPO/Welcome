package com.st.spring.core.beans;

import org.springframework.stereotype.Component;

import com.st.spring.core.beans.interfaces.Ink;

@Component
public class BlackInk implements Ink {

	public String getBrandName() {
		return "Parker";
	}

	public String getColor() {
		return "Black";
	}

}
