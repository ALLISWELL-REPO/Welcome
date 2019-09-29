Change the directory to /src/main/resources in the current project 
[Password will be password123 in all the places]

1. Create a keystore with key value pair

	keytool -genkey -alias serverKey -keystore server.jks -keyalg RSA -sigalg SHA256withRSA
	
2. To check the contents of the keystore after creation use the below command
	
	keytool -v -list -keystore server.jks
	
3. Create a CSR for the server certificate
	
	keytool -certreq -alias serverKey -keystore server.jks -file server.csr
	
4. Create a directory in /src/main/resources called ca and set random file 
	
	mkdir ca
	cd ca/
	set RANDFILE=rand
	
5. Create a CA in ca directory

	openssl req -new -keyout cakey.pem -out careq.pem
	
6. Create a self signed certificate for the CA

	openssl x509 -signkey cakey.pem -req -days 3650 -in careq.pem -out cacert.pem -extfile openssl.cnf -extensions v3_ca
	
7. Create a serial number text file

	echo 02 > serial.txt
	
8. Now sign the server certificate we generated in step 3

	openssl x509 -CA cacert.pem -CAkey cakey.pem -CAserial serial.txt -req -in ../server.csr -out ../server.cer -days 3650 
	
9. Move back to resources directory and import the CA into server jks

	keytool -import -alias testCA -file ./ca/cacert.pem -keystore server.jks
	
10. You can use the below command to list and check that a new entry for CA is added with testCA as the alias

	keytool -v -list -keystore server.jks
	
11. API URL is

	http://localhost:8080/06a_rest_easy_jwe_encryption_server/encrypted/verify