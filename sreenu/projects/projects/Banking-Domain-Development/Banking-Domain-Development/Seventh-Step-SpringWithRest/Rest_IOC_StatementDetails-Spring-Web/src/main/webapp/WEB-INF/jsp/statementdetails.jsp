<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: rgb(180,180,180);">


<%
String contextPath = (String) request.getContextPath();

%>


<a href="<%=contextPath %>/pagination.mvc">ministatement</a>

<h1>${currentPageNo}</h1>
<h1>${noOfPages }</h1>


</body>
</html>