package com.st.spring.mvc.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.st.spring.mvc.exception.InvalidFormDataException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidFormDataException.class)
	public String handleInvalidFormData(Model model,
			HttpServletResponse response) {
		System.out.println("Exception handler called");
		model.addAttribute("status", "false");
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return "sampleForm";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleIllegalArgument(Model model) {
		System.out.println("Exception handler called");
		model.addAttribute("status", "false");
		return "sampleForm";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Model model,
								 HttpServletResponse response) {
		model.addAttribute("status", "false");
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return "sampleForm";
	}
	
	
	
	
	
	
	
	

}
