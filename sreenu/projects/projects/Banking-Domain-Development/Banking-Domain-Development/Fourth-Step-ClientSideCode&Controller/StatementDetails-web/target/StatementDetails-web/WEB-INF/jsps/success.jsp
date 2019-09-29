<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ page isELIgnored="false"%>


</head>
<body style="backgroung-color: teal;">

	<table>

		<tr style="color: red;">

			<th>transid</th>
			<th>name</th>
			<th>desc</th>
			<th>merchantname</th>
			<th>amount</th>
			<th>status</th>
			<th>remarks</th>
		</tr>

		<c:forEach items="${webtranslist}" var="trans">
			<tr style="color: blue;">
				<th>${trans.getTransid()}</th>
				<th>${trans.getName()}</th>
				<th>${trans.getDesc()}</th>
				<th>${ trans.getMerchantname()}</th>
				<th>${ trans.getAmount()}</th>
				<th>${ trans.getStatus()}</th>
				<th>${trans.getRemarks()}</th>
			</tr>
		</c:forEach>

	</table>

</body>
</html>