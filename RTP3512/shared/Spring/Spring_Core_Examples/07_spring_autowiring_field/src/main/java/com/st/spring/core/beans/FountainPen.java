package com.st.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.spring.core.beans.interfaces.Ink;
import com.st.spring.core.beans.interfaces.Pen;

@Component
public class FountainPen implements Pen {
	
	@Autowired
	private Ink ink;
	
	public void write() {
		System.out.println("Writing with " + ink.getColor() + 
				" ink of " + ink.getBrandName() + " brand");
	}

}
