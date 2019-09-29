<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	session="true" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@page	import="com.keybank.card.stmtsvc.client.beans.CardStatementWebRes"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction success</title>
</head>
<body>
	<table border=1 style="width: 100%" bgcolor="aliceblue">
		<caption align="top">Transaction Details</caption>
		<tr>
			<th style="background-color: orange">Transaction Id</th>
			<th style="background-color: orange">Name</th>
			<th style="background-color: orange">Date</th>
			<th style="background-color: orange">Description</th>
			<th style="background-color: orange">Merchant Name</th>
			<th style="background-color: orange">Amount</th>
			<th style="background-color: orange">Status</th>
			<th style="background-color: orange">Remarks</th>
		</tr>
		<c:forEach items="${webList}" var="web">
			<tr>
				<th>${web.getId()}</th>
				<th>${web.getName()}</th>
				<th>${web.getDate()}</th>
				<th>${web.getDesc()}</th>
				<th>${web.getMerchantname()}</th>
				<th>${web.getAmount()}</th>
				<th>${web.getStatus()}</th>
				<th>${web.getRemarks()}</th>
			<tr>
		</c:forEach>
	</table>

</body>
</html>