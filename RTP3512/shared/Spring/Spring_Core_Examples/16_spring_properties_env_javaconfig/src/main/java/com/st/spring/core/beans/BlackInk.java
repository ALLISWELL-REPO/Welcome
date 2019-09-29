package com.st.spring.core.beans;

import com.st.spring.core.beans.interfaces.Ink;

public class BlackInk implements Ink {
	
	private String brandName;
	private String color;
	
	public BlackInk(final String brandName, final String color) {
		this.brandName = brandName;
		this.color = color;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public String getColor() {
		return this.color;
	}

}
