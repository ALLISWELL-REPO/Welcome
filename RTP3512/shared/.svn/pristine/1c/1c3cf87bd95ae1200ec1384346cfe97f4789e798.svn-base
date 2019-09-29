Steps
1. Extend the SpringBootServletIntializer class and override configure()

2. Change the package to 'war'

3. Make the spring-boot-starter-tomcat as provided in pom.xml. This is because we do not want the embedded tomcat server to be packaged along with the war that we are building in the lib directory. When this war is deployed in tomcat webapp directory, the application will start in the tomcat like regular app without using the embedded tomcat.

4. Build the war using maven and deploy the war manually into tomcat webapps folder

5. Since we have added build plugin, we can also run the war in command line using
			java -jar <war name>.war