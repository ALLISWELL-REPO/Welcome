package com.st.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;

import com.st.spring.core.beans.interfaces.Ink;

public class BlackInk implements Ink {
	
	@Value("${blackink.brand}")
	private String brandName;
	
	@Value("${blackink.color}")
	private String color;
	
	public BlackInk() {
		
	}

	public String getBrandName() {
		return this.brandName;
	}

	public String getColor() {
		return this.color;
	}

}
