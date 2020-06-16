<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.citybank.stmtdtls.web.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ page isELIgnored="false"%>

</head>
<body>

	<%
		String contextPath = request.getContextPath();
		CustomerDetails customerDetails = (CustomerDetails) session
				.getAttribute("custDetailssession");
	%>

	<h3 style="color: green;"><%=customerDetails.getCustName()%></h3>

	<table>

		<tr>
			<th>Name:</th>
			<th>${custDetails.getCustName()}</th>
		</tr>

		<tr>
			<th>Account No:</th>
			<th>${custDetails.getAccountNumber()}</th>
		</tr>

		<tr>
			<th>Balance:</th>
			<th>${custDetails.getBalance()}</th>
		</tr>
	</table>

	<a href="<%=contextPath%>/cards.mvc">cards</a>
</body>
</html>