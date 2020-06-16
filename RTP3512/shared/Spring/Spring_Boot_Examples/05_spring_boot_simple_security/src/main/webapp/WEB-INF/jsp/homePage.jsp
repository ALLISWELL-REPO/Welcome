<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="/css/application.css"
	rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>	

</head>
<body class="container">
	
	<label for="login" class="login_text">Welcome to home page</label>
	<div class="login_container">
		<c:if test="${userName != null}">
			<label>User Name: ${userName}</label>
		</c:if>
		<form action="/logout" method="post">
			<button type="submit" class="btn btn-default">Log Out</button>
		</form>
	</div>
	
</body>
</html>