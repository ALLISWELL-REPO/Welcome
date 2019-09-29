This is a webapp 3.1 version. Should be run in Tomcat 8.

This example uses Tomcat realm configuration and <security-constraint> <login-config> tags in web.xml to provide Basic authentication

Useful links for Tomcat realm configuration

https://tomcat.apache.org/tomcat-8.0-doc/realm-howto.html
https://tomcat.apache.org/tomcat-8.0-doc/config/realm.html

This example uses a database to authenticate users before letting them access the REST APIs
For this we need a database and a table. The query to create the table is as below

CREATE TABLE `st_user` (
       `id` bigint(20) NOT NULL AUTO_INCREMENT,
       `principal` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
       `password` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
       PRIMARY KEY (`id`),
       UNIQUE KEY `principal` (`principal`)
     ) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;  
     
CREATE TABLE `st_user_roles` (
  		`principal` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  		`role` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  		PRIMARY KEY (`principal`,`role`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
	
Add entries to these tables using below queries

INSERT INTO st_user (principal, password) VALUES ('admin', 'password123');
INSERT INTO st_user_roles (principal, role) VALUES ('admin', 'admin');


If you are running this example from Eclipse then do the following
------------------------------------------------------------------
1. Run the application on the server once
2. Open `<Workspace-location>/Servers/Tomcat <version> directory/server.xml` 
3. In server.xml at the end of the file, you should see an entry like below

	<Context docBase="01_rest_easy_role_based_auth_web_xml" path="/01_rest_easy_role_based_auth_web_xml" reloadable="true" 
											source="org.eclipse.jst.j2ee.server:01_rest_easy_role_based_auth_web_xml">
	
Replace this whole line with the below content
	
	<Context docBase="01_rest_easy_role_based_auth_web_xml" path="/01_rest_easy_role_based_auth_web_xml" reloadable="true" 
											source="org.eclipse.jst.j2ee.server:01_rest_easy_role_based_auth_web_xml">
        <Realm className="org.apache.catalina.realm.JDBCRealm"
               driverName="org.mariadb.jdbc.Driver"
               connectionURL="jdbc:mysql://localhost/st?user=dbuser&amp;password=dbpassword"
               userTable="st_user" userNameCol="principal" userCredCol="password"
               userRoleTable="st_user_roles" roleNameCol="role"
               debug="99" />
      </Context>
Update the user and password in connectionURL above accordingly

4. Add `mariadb-java-client-1.1.7.jar` in <tomcat-directory>/lib
5. Restart the tomcat server from eclipse
6. Access http://localhost:8080/01_rest_easy_role_based_auth_web_xml/services/customers in REST client or browser, it should prompt you for user name and password

If you are running this example directly on Tomcat server
---------------------------------------------------------
Follow all the steps specified above with one exception, that is as below
1. Instead of modifying `<Workspace-location>/Servers/Tomcat <version> directory/server.xml`, you should directly modify the tomcat server.xml in path 
	`<tomcat-directory>/conf/server.xml` 
