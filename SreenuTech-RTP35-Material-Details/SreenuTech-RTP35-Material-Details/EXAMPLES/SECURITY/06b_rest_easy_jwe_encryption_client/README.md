Change the directory to /src/main/resources in the current project 
[Password will be password123 in all the places]

1. Create a keystore with key value pair, use password as password123 for both keystore as well as for the private key

	keytool -genkey -alias clientKey -keystore client.jks -keyalg RSA -sigalg SHA256withRSA
	
2. To check the contents of the keystore after creation use the below command
	
	keytool -v -list -keystore client.jks
	
3. Now go and read the README.md in the server project related to this and follow all the steps there.

4. After the above step create a directory called CA in resources directory

	mkdir ca
	cd ca/
	
5. Copy 'cacert.pem' file from server project ca directory to this project's ca directory

6. Also copy 'server.cer' file from server project resources directory to this project's resources directory

7. Import CA into client.jks. Execute the below command from this project's resources directory

	keytool -import -alias testCA -file ./ca/cacert.pem -keystore client.jks
	
8. You can use the below command to list and check that a new entry for CA is added with testCA as the alias

	keytool -v -list -keystore client.jks

9. Import server certificate into client.jks. Execute the below command from this project's resources directory

	keytool -import -alias serverKey -file server.cer -keystore client.jks
	
10. You can use the below command to list and check that a new entry for client certificate is added with serverKey as the alias

	keytool -v -list -keystore client.jks 
	
11. API URL is 

	http://localhost:8080/06b_rest_easy_jwe_encryption_client/send/encrypted