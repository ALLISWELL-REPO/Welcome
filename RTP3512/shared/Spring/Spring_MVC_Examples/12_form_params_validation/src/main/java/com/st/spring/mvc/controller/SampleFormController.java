package com.st.spring.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.spring.mvc.model.SampleFormData;

@Controller
public class SampleFormController {
	
	@RequestMapping(value = "/sample/form", 
			method = RequestMethod.GET)
	public String getSampleForm() {
		return "sampleForm";
	}
	
	@RequestMapping(value = "/sample/form", 
			method = RequestMethod.POST)
	public String processSampleForm(@Valid @ModelAttribute SampleFormData sampleFormData,
									BindingResult validationResult,
									Model model) {
		System.out.println("*** sampleFormData: " + sampleFormData);
		if (validationResult.hasErrors()) {
			System.out.println("**** Validation errors in the form data ****" + validationResult.getFieldErrors());
			model.addAttribute("status", "false");
			return "sampleForm";
		}
		System.out.println("#### Form processing successful ####");
		model.addAttribute("status", "true");
		return "sampleForm";
	}
	
	
	
	
	
	

}
