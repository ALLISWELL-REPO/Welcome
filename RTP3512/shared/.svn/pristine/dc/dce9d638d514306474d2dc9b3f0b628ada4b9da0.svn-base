package com.st.spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.st.spring.core.beans.BlackInk;
import com.st.spring.core.beans.BlueInk;
import com.st.spring.core.beans.FountainPen;
import com.st.spring.core.beans.Writer;
import com.st.spring.core.beans.interfaces.Ink;
import com.st.spring.core.beans.interfaces.Pen;

@Configuration
public class SpringConfig {
	
	@Bean
	public Writer writer(Pen pen) {
		return new Writer(pen);
	}

	@Bean
	public Pen fountainPen(/*@Qualifier("blueInk")*/ Ink ink) {
		return new FountainPen(ink);
	}
	
	@Bean
	//@Primary
	//@Qualifier("blackInk")
	public Ink blackInk() {
		return new BlackInk();
	}
	
	@Bean
	//@Qualifier("blueInk")
	public Ink blueInk() {
		return new BlueInk();
	}
}
