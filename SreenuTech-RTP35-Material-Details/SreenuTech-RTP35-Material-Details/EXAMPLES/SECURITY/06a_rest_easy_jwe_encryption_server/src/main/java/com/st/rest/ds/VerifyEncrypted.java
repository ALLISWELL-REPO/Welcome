package com.st.rest.ds;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectMapper.DefaultTyping;
import org.jboss.resteasy.jose.jwe.JWEInput;

import com.st.rest.ds.bean.Customer;

@Path("/encrypted/verify")
public class VerifyEncrypted {

   @POST
   @Consumes("text/plain")
   @Produces("text/plain")
   public String post(String request) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException {
	   
	  System.out.println();
	  System.out.println("---------- Server Log: Received a encrypted message from client and it is as below ----------");
	  System.out.println(request);
	  System.out.println("---------- --------------------------------------------------------------- ----------");
	  System.out.println();
	  
	  // Load key store and private key
	  InputStream jks = this.getClass().getClassLoader().getResourceAsStream("server.jks");
	  KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
	  keystore.load(jks, "password123".toCharArray());
	  Key key = keystore.getKey("serverkey", "password123".toCharArray());
	  
	  // decrypt the request
	  byte[] raw = new JWEInput(request).decrypt((RSAPrivateKey) key).getRawContent();
      String decrypted = new String(raw);
	  
      System.out.println();
	  System.out.println("---------- Server Log: Decryption successful and the data is as below ----------");
	  System.out.println(decrypted);
	  System.out.println("---------- --------------------------------------------------------------- ----------");
	  System.out.println();
	  
	  // Mapper for json to object conversion
	  ObjectMapper mapper = new ObjectMapper();
	  mapper.enableDefaultTyping(DefaultTyping.JAVA_LANG_OBJECT);
	  mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	  
	  // convert to customer
	  Customer customer = mapper.readValue(decrypted, Customer.class);
	  System.out.println();
	  System.out.println("---------- Server Log: After converting json to customer and the data is as below ----------");
	  System.out.println(customer);
	  System.out.println("---------- --------------------------------------------------------------- ----------");
	  System.out.println();
      
      return "Request decrypted successfully";
   }


}
