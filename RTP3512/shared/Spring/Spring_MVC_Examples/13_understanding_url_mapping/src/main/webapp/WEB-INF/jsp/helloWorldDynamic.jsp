<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String contextPath = (String) request.getContextPath();

%>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1>Hello World ${name}</h1>
	
	<form action="<%=contextPath%>/helloWorld/" method="post">
		<div style="padding-left: 100px !important">
			<button type="submit" class="btn btn-default">Test Post Method</button>
		</div>
	</form>
</body>
</html>