package com.st.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.spring.core.beans.interfaces.Pen;

@Component
public class Writer {
	
	private Pen pen;
	
	@Autowired
	public Writer(final Pen pen) {
		this.pen = pen;
	}
	
	public void write() {
		pen.write();
	}

}
