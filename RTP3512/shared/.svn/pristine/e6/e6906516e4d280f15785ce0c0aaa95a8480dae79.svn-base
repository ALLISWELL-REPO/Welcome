package com.st.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.st.spring.core.beans.interfaces.Pen;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
