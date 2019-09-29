package com.st.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.spring.core.beans.interfaces.Pen;

@Component
public class Writer {
	
	@Autowired
	private Pen pen;
	
	public void write() {
		pen.write();
	}

}
