package com.citybank.spring.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.citybank.spring.rest.javaConfig.ClientJavaConfig;
import com.citybank.statementdtls.schema.res.StatementDtlsRespType;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebReq;
import com.citybank.stmtdtlssvc.client.beans.StatementDtlsWebRes;
import com.citybank.stmtdtlssvc.client.builder.StatementDtlsSvcClientResBuilder;

@Component
public class StatementDtlsSpringRestClient {

	@Autowired
	RestTemplate restTemplate = null;

	@Autowired
	StatementDtlsSvcClientResBuilder respBuilder = null;

	public StatementDtlsWebRes getTransactions(StatementDtlsWebReq webReq) {

		String uri = "http://localhost:8888/StatementDtlsSpringRest-war/statement/getTransactions.mvc";

		// adding headers to rest-template
		HttpHeaders headers = new HttpHeaders();

		headers.set("clientid", "web");
		headers.set("channelid", "online");
		headers.set("reqid", "reqid");
		headers.set("patner-key", "patner-key");
		headers.set("Accept", "application/json");

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<StatementDtlsRespType> resp = restTemplate.exchange(uri,
				HttpMethod.GET, entity, StatementDtlsRespType.class);

		System.err.println("Response" + resp);

		StatementDtlsRespType resType = resp.getBody();
		System.out.println("json object " + resType);

		StatementDtlsWebRes webResp = respBuilder.buildWebResponse(resType);

		return webResp;
	}

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				ClientJavaConfig.class);

		StatementDtlsWebReq req = new StatementDtlsWebReq();
		req.setCardnum("45900500000921478");
		req.setCvvnum("514");
		req.setNameoncard("srinu");
		req.setExpdate("2018-04-03");

		System.out.println("calling server");

		StatementDtlsSpringRestClient client = context
				.getBean(StatementDtlsSpringRestClient.class);

		StatementDtlsWebRes resp = client.getTransactions(req);
		System.out.println("main" + resp);
	}

}
