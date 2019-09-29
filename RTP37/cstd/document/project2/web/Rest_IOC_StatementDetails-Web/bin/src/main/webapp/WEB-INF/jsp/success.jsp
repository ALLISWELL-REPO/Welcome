<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: rgb(180, 180, 180);">
	<h3>response code ${webRes.getRespCode() }</h3>
	<c:if test="${webRes.getRespCode() != 000 }">

		<p style="font-size: 50px">please provide valid data
			${webRes.getRespCode()}</p>
	</c:if>
	<c:if test="${listSize le 0 && webRes.getRespCode() ==000}">
		<p style="font-size: 50px">No transactions found
			${webRes.getRespCode()}</p>
	</c:if>
	<c:if test="${listSize gt 0 }">
		<table>
			<tr style="color: red;">
				<th>id</th>
				<th>name</th>
				<th>desc</th>
				<th>merchantName</th>
				<th>amount</th>
				<th>status</th>
				<th>remarks</th>
			</tr>

			<c:forEach items="${webtranslist}" var="trans">
				<tr style="color: blue;">
					<th>${trans.getId()}</th>
					<th>${trans.getName()}</th>
					<th>${trans.getDesc()}</th>
					<th>${trans.getMerchantName()}</th>
					<th>${trans.getAmount()}</th>
					<th>${trans.getStatus()}</th>
					<th>${trans.getRemarks()}</th>
				</tr>
			</c:forEach>

		</table>
	</c:if>

</body>
</html>