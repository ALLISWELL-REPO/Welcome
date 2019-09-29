This is a webapp 3.1 version. Should be run in Tomcat 8

This example uses a database to authenticate users before letting them access the REST APIs
For this we need a database and a table. The query to create the table is as below

CREATE TABLE `st_user` (
       `id` bigint(20) NOT NULL AUTO_INCREMENT,
       `principal` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
       `password` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
       PRIMARY KEY (`id`),
       UNIQUE KEY `principal` (`principal`)
     ) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
     
To insert rows into this table
1. Use PasswordEncoder to generate a digest for the user password you need.
2. Once the password digest is generated insert a row for the user using the below query

INSERT INTO st_user (principal, password) VALUES ('admin', 'keep the password hash generated here');
     
Update the database connection details accordingly in `/src/main/resources/jdbc.properties`

On running the application if you see `ClassNotFoundException: org.springframework.web.context.ContextLoaderListener`, then do the following
1. Right click on the project -> properties -> Deployment Assembly -> Add -> Java Build Path Entries -> Next -> Maven Dependencies -> Finish -> Apply -> Ok -> Re run the application
 