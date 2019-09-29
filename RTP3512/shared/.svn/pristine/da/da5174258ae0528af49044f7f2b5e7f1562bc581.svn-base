package com.st.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.st.spring.core.beans.interfaces.Ink;

@Component
public class BlackInk implements Ink {

	@Value("${blackink.brand}")
	private String brandName;
	
	@Value("${blackink.color}")
	private String color;
	
	public String getBrandName() {
		return this.brandName;
	}

	public String getColor() {
		return this.color;
	}

}
