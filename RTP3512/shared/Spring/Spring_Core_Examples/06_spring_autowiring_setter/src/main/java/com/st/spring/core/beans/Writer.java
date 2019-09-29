package com.st.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.spring.core.beans.interfaces.Pen;

@Component
public class Writer {
	
	private Pen pen;
	
	public void write() {
		pen.write();
	}

	public Pen getPen() {
		return pen;
	}

	@Autowired
	public void setPen(Pen pen) {
		this.pen = pen;
	}

}
