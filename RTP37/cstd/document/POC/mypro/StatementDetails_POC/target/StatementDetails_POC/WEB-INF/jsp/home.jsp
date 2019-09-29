<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body bgcolor="lightblue">
	<h1 style="color:gray; text-align: center">Welcome to City Bank</h1>
	<form>
		<table border="1" style="width: 100%" bgcolor="yellow">
			<tr style="background-color: aqua" height="35">
				<td>Account Number:</td>
				<td>${custDetails.getAccount_no()}</td>
			</tr>
			<tr style="background-color: aqua" height="35">
				<td>Balance :</td> <td>${custDetails.getBalance()}
				</td>
			</tr>
			<tr style="background-color: aqua" height="35">
				<td>Name :</td> <td>${custDetails.getCust_name()}
				</td>
			</tr>
		</table>
	</form>
</body>