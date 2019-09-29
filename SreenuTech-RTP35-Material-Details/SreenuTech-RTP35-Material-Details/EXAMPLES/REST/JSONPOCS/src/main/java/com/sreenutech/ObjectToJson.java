package com.sreenutech;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sreenutech.beans.OffersBean;

public class ObjectToJson {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		/*ObjectMapper mapper = new ObjectMapper();
		OffersBean bean = new OffersBean();
		bean.setOid("121212");
		bean.setName("mobile");
		bean.setInstock("yes");
		bean.setDesc("good");
		bean.setType("ele");

		mapper.writeValue(
				new File(
						"D:\\Sreenu-Stuff\\WebServices\\JAXRS\\Rest-Latest\\JSONPOCS\\src\\main\\resources\\offers.json"),
				bean);

		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
		System.out.println("json data is :" + json);*/

		OffersBean bean1 = mapper.readValue(
				new File(
						"D:\\Sreenu-Stuff\\WebServices\\JAXRS\\Rest-Latest\\JSONPOCS\\src\\main\\resources\\offers.json"),
				OffersBean.class);

		System.out.println(" java object is :" + bean1);

	}

}
