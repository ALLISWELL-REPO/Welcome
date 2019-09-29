1st setp : exception --> Null Pointer Exception :: Regarding date properties, so after comment out them its working .


2nd step : its about code refactoring (Mazi request ghe ani ali ka nahi ti ack kar, by  returning your requestv, mag mi check karto ani tally karun barobar ka nahi te sangto)


3rd Step : Its about deploying WAR server side. If internal server is not working then try for external server. 
Note : Collection Logic :  
After extracting the list to send to other layer we need use add() method in logic, otherwise in response i m getting [] (Empty list set), Just Basics.


4th step :
Service needed to be always in the alive state.Also chance of getting "FileNotFound" exception if  have server issue just like lab.

5th step : 
Take care about trim() method and ""(double quotes).
Make sure the no need to create obj explicitly using new keyword, here based on wsReq its returning object, otherwise excepted result does not match with actual result.

6th step : 
Null pointer exception getting due to backend not connection properly , forgot to add uname and password in intgimpl layer.1st tested in the soap client so comes to know anyhow.


note : if we are sending data to jsp that time model objct is useful
but from controller to controller 


Another Problem : 
org.springframework.web.servlet.PageNotFound noHandlerFound
WARNING: No mapping found for HTTP request with URI [/StatementDetails-web/statementdetails.mvc] in DispatcherServlet with name 'dispatcher'
Soln:

Another Probliem : Problems wrt Stord-Procedure , 
Here hypen(-) not allowded, so changed respective db column names.


Seventh-Step : Bean creation exception is there ,
dont forget @Import annotation , otherwise exception .Also be careful with your Java-Config
