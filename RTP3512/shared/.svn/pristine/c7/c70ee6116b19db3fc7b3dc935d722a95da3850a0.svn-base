package com.st.spring.mvc.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.web.servlet.view.AbstractView;

public class JsonView extends AbstractView {
	
	private JsonConfig jsonConfig;
	
	public JsonView() {
		jsonConfig = new JsonConfig();
	}
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		// set content type and convert to Json
		response.setContentType("application/json; charset=UTF-8");
		JSON json = JSONSerializer.toJSON(model, this.jsonConfig);
		json.write(response.getWriter());
	}
	
	
	
	
	
	
	
	

}
