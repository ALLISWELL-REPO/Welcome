<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body bgcolor="lightgreen">
	<h1 style="color:red; text-align: center">Welcome to City Bank</h1>
	<form>
		<table border="1" style="width: 100%" bgcolor="white">
			<tr style="background-color: lightblue" height="35">
				<td>Account Number:</td>
				<td>${custDetails.getAccount_no()}</td>
			</tr>
			<tr style="background-color: lightblue" height="35">
				<td>Balance :</td> <td>${custDetails.getBalance()}
				</td>
			</tr>
			<tr style="background-color: lightblue" height="35">
				<td>Name :</td> <td>${custDetails.getCust_name()}
				</td>
			</tr>
			<tr style="background-color: lightblue" height="35">
				<td>Address :</td> <td>${custDetails.getAddress()}
				</td>
			</tr>
		
			<tr style="background-color: lightblue" height="35">
				<td>City :</td> <td>${custDetails.getCity()}
				</td>
			</tr>
			
			<tr style="background-color: lightblue" height="35">
				<td>State :</td> <td>${custDetails.getState()}
				</td>
			</tr>
			
			<tr style="background-color: lightblue" height="35">
				<td>Pin :</td> <td>${custDetails.getPin()}
				</td>
			</tr>
			
			<tr style="background-color: lightblue" height="35">
				<td>Enrollment_date :</td> <td>${custDetails.getEnrollment_date()}
				</td>
			</tr>
			<tr style="background-color: lightblue" height="35">
				<td>Card :</td> <td>${custDetails.getCardnum()}
				</td>
			</tr>
			
			<tr style="background-color: lightblue" height="35">
				<td>Card :</td> <td>${custDetails.getStatus()}
				</td>
			</tr>
			
			<tr style="background-color: lightblue" height="35">
				<td>Mobile :</td> <td>${custDetails.getMobile()}
				</td>
			</tr>
			<tr style="background-color: lightblue" height="35">
				<td>Email :</td> <td>${custDetails.getEmailid()}
				</td>
			</tr>
		</table>
	</form>
</body>