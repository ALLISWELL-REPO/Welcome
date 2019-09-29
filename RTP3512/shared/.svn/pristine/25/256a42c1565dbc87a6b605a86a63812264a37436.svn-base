package com.st.spring.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.st.spring.mvc.model.SampleModel;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = "/helloWorldDynamic/", method = RequestMethod.GET)
	public String helloWorld(Model model) {
		return "helloWorldDynamic";
	}
	
	@RequestMapping(value = "/getjson/", method = RequestMethod.GET)
	public ModelAndView getJsonResponse() {
		Map<String, Object> model = new HashMap<String, Object>();
		SampleModel sampleModel = getJsonModel();
		List<SampleModel> sampleModels = new ArrayList<SampleModel>();
		sampleModels.add(sampleModel);
		model.put("results", sampleModels);
		return new ModelAndView("jsonView", model);
	}
	
	private SampleModel getJsonModel() {
		SampleModel sampleModel = new SampleModel();
		sampleModel.setId("abc123");
		sampleModel.setName("HDFC");
		sampleModel.setAccount("1234567890");
		sampleModel.setBranch("S R Nagar");
		return sampleModel;
	}
	
	
	
	
	
	
	
	

}
