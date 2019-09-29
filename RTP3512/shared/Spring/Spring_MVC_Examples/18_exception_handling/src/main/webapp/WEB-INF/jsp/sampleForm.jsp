<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample Form</title>
<%
	String contextPath = (String) request.getContextPath();
%>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
	<h1>Sample Form</h1>
	<form action="<%=contextPath%>/sample/form" method="post">
		<c:if test="${status == false}">
			<div class="alert alert-danger">
				<p>Form submitted has validation errors</p>
			</div>
		</c:if>
		<c:if test="${status == true}">
			<div class="alert alert-info">
				<p>Form processing successful</p>
			</div>
		</c:if>
		<div class="form-group">
			<label for="userLabel">First Name</label> 
			<input type="text" id="firstName" name="firstName">
		</div>
		
		<div class="form-group">
			<label for="userLabel">Last Name</label> 
			<input type="text" id="lastName" name="lastName">
		</div>
		
		<div class="form-group">
			<label for="userLabel">Area Name</label> 
			<input type="text" id="areaName" name="areaName">
		</div>
		
		<div class="form-group">
			<label for="userLabel">Pincode</label> 
			<input type="text" id="pincode" name="pincode">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</body>
</html>