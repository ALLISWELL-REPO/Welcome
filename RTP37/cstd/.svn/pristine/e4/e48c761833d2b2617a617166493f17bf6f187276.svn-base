package com.citybank.stmtdtlssvc.rest.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.UUID;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.citybank.statementdtls_schema.req.StatementDtlsReqType;
import com.citybank.statementdtls_schema.resp.StatementDtlsResType;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.builder.StatementDtlsSvcClientResBuilder;
import com.citybank.stmtdtlssvc.client.util.StatementDtlsConstant;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class StatementSvcClientImpl {
	public StatementDtlsWebRes getTransactions(StatementDtlsWebReq webReq)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("enter into rest client");
		Client client = Client.create();
		String uri = getUri();
		WebResource resource = client.resource(uri);

		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("cardNumber", webReq.getCardNum());
		queryParams.add("cvv", String.valueOf(webReq.getCvvNum()));
		queryParams.add("expDate", webReq.getExpDate());
		queryParams.add("startDate", webReq.getStartDate());
		queryParams.add("endDate", webReq.getEndDate());
		queryParams.add("typeOfCate", webReq.getTypeOfCate());

		resource.setProperty("client-id", StatementDtlsConstant.CLIENT_ID);
		resource.setProperty("channel-id", StatementDtlsConstant.CHANNEL_ID);
		resource.setProperty("req-id", UUID.randomUUID().toString());
		resource.setProperty("patner-key", "1234");

		ClientResponse clientResponse = resource.queryParams(queryParams).accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		String jsonResp = clientResponse.getEntity(String.class);
		System.out.println(jsonResp);

		ObjectMapper mapper = new ObjectMapper();
		StatementDtlsResType resType = mapper.readValue(jsonResp, StatementDtlsResType.class);
		System.out.println(resType);

		StatementDtlsSvcClientResBuilder builder = new StatementDtlsSvcClientResBuilder();
		StatementDtlsWebRes webRes = builder.buildWebResponse(resType);
		System.out.println("from client WebRes " + webRes);
		System.out.println("exit from rest client");
		return webRes;
	}

	

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		StatementSvcClientImpl clientImpl = new StatementSvcClientImpl();
		StatementDtlsWebReq req = new StatementDtlsWebReq();
		req.setCardNum("45900500000321478");
		req.setCvvNum(514);
		// req.setEndDate("01-05-2018");
		req.setNameOnCard("sunny");
		// req.setStartDate("01-03-2018");
		// req.setTypeOfCate("ALL");
		req.setExpDate("2018-04-03");
		System.out.println("calling server");
		//StatementDtlsWebRes res = clientImpl.getTransactions(req);
		String uri=getUri();
		System.out.println("uri "+uri);
	}
	public static String getUri(){
		String uri="";
		Properties properties=new Properties();
		InputStream is = StatementSvcClientImpl.class.getClassLoader().getSystemResourceAsStream("restclient.properties");
		try {
			properties.load(is);
			uri=properties.getProperty("get_Uri_endpoint");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uri;
	}
}

/*
 * try { JSONObject jsonObject=new JSONObject(jsonResp);
 * System.out.println("-->"+jsonObject); Iterator it=jsonObject.keys();
 * while(it.hasNext()){ System.out.println(it.next());
 * 
 * }
 * 
 * } catch (JSONException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 */
