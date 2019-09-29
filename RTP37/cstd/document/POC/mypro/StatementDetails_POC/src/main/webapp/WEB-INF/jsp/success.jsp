<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body bgcolor="lightblue">
<h1 style="color:green;text-align:center">Transaction History</h1>
	<form>
		<table border="1" style="width:100%"  bgcolor="aliceblue">
			<tr style="background-color: red" height="45" background="red">
				<th style="color: blue">TransId</th>
				<th style="color: blue">Date</th>
				<th style="color: blue">MerchantName</th>
				<th style="color: blue">Desc</th>
				<th style="color: blue">Amount</th>
				<th style="color: blue">Status</th>
				<th style="color: blue">Remarks</th>
			</tr>

			<c:forEach items="${webList}" var="webResult">
				<tr style="background-color: shyan" height="35">
					<td>${webResult.getId()}</td>
					<td>${webResult.getDate()}</td>
					<td>${webResult.getMerchantname()}</td>
					<td>${webResult.getDesc()}</td>
					<td>${webResult.getAmount()}</td>
					<td>${webResult.getStatus()}</td>
					<td>${webResult.getRemarks()}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>