package com.citybank.spring.rest.client;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.citybank.spring.rest.javaConfig.ClientJavaConfig;
import com.citybank.statementdtls_schema.req.StatementDtlsReqType;
import com.citybank.statementdtls_schema.resp.StatementDtlsResType;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.builder.StatementDtlsSvcClientReqBuilder;
import com.citybank.stmtdtlssvc.client.builder.StatementDtlsSvcClientResBuilder;

@Component
public class StatementDtlsSpringClient {
	@Autowired
	RestTemplate restTemplate = null;
	@Autowired
	StatementDtlsSvcClientResBuilder respBuilder = null;
	@Autowired
	StatementDtlsSvcClientReqBuilder clientReqBuilder = null;

	public StatementDtlsWebRes getTransactions(StatementDtlsWebReq webReq)
			throws JsonParseException, JsonMappingException, IOException {
		String url = "http://localhost:9090/StatementDtlsSpringRest-war/statement/getTransaction.mvc";

		Map<String, String> params = new HashMap<>();
		params.put("cardNumber", webReq.getCardNum());

		// URI uri =
		// UriComponentsBuilder.fromUriString(url).buildAndExpand(params).toUri();

		// URI
		// uri=UriComponentsBuilder.fromUriString(url).queryParam("cardNumber",
		// webReq.getCardNum()).queryParam("cvv",
		// webReq.getCvvNum()).build().toUri();

		// adding headers to rest template
		HttpHeaders headers = new HttpHeaders();
		headers.set("client-id", "web");
		headers.set("channel-id", "online");
		headers.set("req-id", "1234");
		headers.set("patner-key", "321");
		headers.set("Accept", "application/json");

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<StatementDtlsResType> resp = restTemplate.exchange(url, HttpMethod.GET, entity,
				StatementDtlsResType.class);

		System.out.println("Response " + resp);

		StatementDtlsResType resType = resp.getBody();

		System.out.println("json object " + resType);

		// ObjectMapper mapper = new ObjectMapper();
		// StatementDtlsResType resourceResp = mapper.readValue(jsonInStr,
		// StatementDtlsResType.class);
		// StatementDtlsWebRes webResp =
		// respBuilder.buildWebResponse(resourceResp);
		StatementDtlsWebRes webResp = respBuilder.buildWebResponse(resType);

		return webResp;
	}

	public StatementDtlsWebRes postTransactions(StatementDtlsWebReq webReq)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("enter into post method");
		String url = "http://localhost:9090/StatementDtlsSpringRest-war/statement/postTransaction.mvc";

		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();

		StatementDtlsReqType wsReq = clientReqBuilder.buildWsRequest(webReq);

		// adding headers to rest template
		HttpHeaders headers = new HttpHeaders();
		headers.set("client-id", "web");
		headers.set("channel-id", "online");
		headers.set("req-id", "1234");
		headers.set("patner-key", "321");
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/json");

		HttpEntity<StatementDtlsReqType> httpEntity = new HttpEntity<StatementDtlsReqType>(wsReq, headers);

		// RequestEntity<StatementDtlsReqType> requestEntity=new
		// RequestEntity<StatementDtlsReqType>(wsReq, headers, HttpMethod.POST,
		// uri);

		ResponseEntity<StatementDtlsResType> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
				StatementDtlsResType.class);

		System.out.println("Response " + resp);

		StatementDtlsResType resType = resp.getBody();

		System.out.println("json object " + resType);

		// ObjectMapper mapper = new ObjectMapper();
		// StatementDtlsResType resourceResp = mapper.readValue(jsonInStr,
		// StatementDtlsResType.class);
		// StatementDtlsWebRes webResp =
		// respBuilder.buildWebResponse(resourceResp);
		StatementDtlsWebRes webResp = respBuilder.buildWebResponse(resType);

		return webResp;
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext(ClientJavaConfig.class);
		StatementDtlsWebReq req = new StatementDtlsWebReq();
		req.setCardNum("45900500000321478");
		req.setCvvNum(514);
		// req.setEndDate("01-05-2018");
		req.setNameOnCard("sunny");
		// req.setStartDate("01-03-2018");
		// req.setTypeOfCate("ALL");
		req.setExpDate("2018-04-03");
		System.out.println("calling server");
		StatementDtlsSpringClient client = context.getBean(StatementDtlsSpringClient.class);
		StatementDtlsWebRes resp = client.postTransactions(req);
		System.out.println("main " + resp);
		System.out.println("hi");
	}

}
