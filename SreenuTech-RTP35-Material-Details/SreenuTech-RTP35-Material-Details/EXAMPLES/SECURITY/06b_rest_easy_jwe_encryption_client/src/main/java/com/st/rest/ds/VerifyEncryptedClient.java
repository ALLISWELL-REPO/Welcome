package com.st.rest.ds;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPublicKey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.jose.jwe.JWEBuilder;

import com.st.rest.ds.bean.Address;
import com.st.rest.ds.bean.Customer;

@Path("/send/encrypted")
public class VerifyEncryptedClient
{
   
   @GET
   @Produces("text/plain")
   public String helloPlainText() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException {
	   
	   Customer customer = getCustomer();
	   
	   // mapper for json conversion
	   ObjectMapper mapper = new ObjectMapper();
	   mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
	   mapper.setSerializationInclusion(Inclusion.NON_EMPTY);
	   
	   // convert customer to json
	   String requestContent = mapper.writeValueAsString(customer);
	   System.out.println("---------- Client Log: Sending customer json request to server as below ----------");
       System.out.println(requestContent);
 	   System.out.println("---------- --------------------------------------------------------------- ----------");
 	   System.out.println();
	   
	   // Load key store and private key
	  InputStream jks = this.getClass().getClassLoader().getResourceAsStream("client.jks");
	  KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
	  keystore.load(jks, "password123".toCharArray());
	  Key publicKey = keystore.getCertificate("serverkey").getPublicKey();
	  
	  // encrypt the data using server public key
	  String encrypted = new JWEBuilder().contentBytes(requestContent.getBytes()).RSA1_5((RSAPublicKey) publicKey);
	 
	   	   
	   // create rest easy client
	   ResteasyClient client = new ResteasyClientBuilder().build();
	   
	   WebTarget target = client.target("http://localhost:8080/06a_rest_easy_jwe_encryption_server/encrypted/verify");
	   
       System.out.println("---------- Client Log: Sending encrypted request to server as below ----------");
       System.out.println(encrypted);
 	   System.out.println("---------- --------------------------------------------------------------- ----------");
 	   System.out.println();
       
       // call the service
       Response response = target.request().post(Entity.text(encrypted));
       
       // check if the response obtained successfully
       Assert.assertEquals(200, response.getStatus());
       String responseContent = response.readEntity(String.class);
       Assert.assertEquals("Request decrypted successfully", responseContent);
	   
	   return responseContent;
	   
   }
   
   private Customer getCustomer() {
	   Address address = new Address();
	   address.setHouseNumber("1234");
	   address.setStreet("Community Hall Road");
	   address.setCity("Hyderabad");
	   address.setState("Telangana");
	   address.setPinCode(500045);
	   
	   Customer customer = new Customer();
	   customer.setId("abc123");
	   customer.setName("Cust One");
	   customer.setPhone(123456789);
	   customer.setEmail("cust@gm.com");
	   customer.setAddress(address);
	   
	   return customer;
   }

}
