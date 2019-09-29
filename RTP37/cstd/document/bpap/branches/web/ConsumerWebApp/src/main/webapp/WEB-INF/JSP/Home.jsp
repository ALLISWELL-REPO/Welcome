<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%-- <%
	session.invalidate();
%> --%>
<body bgcolor="lightblue">

	<center style="margin-top: 80px;">

		<h1 style="color: green;">Welcome to Home Page</h1>
		<table>
			<tr>
				<!-- <td><a href="register"><b
						style="margin-right: 25px; font: 40px;">Register</b></a></td>
				<td><a href="payments"><b
						style="margin-left: 25px; font: 40px;">Payments</b></a></td>
				<td><a href="o2login"><b
						style="margin-left: 50px; font: 40px;">Logout</b></a></td> -->

				<td><form action="o2login" method="get">
						<input type="submit" value="Logout">
					</form></td>
				<td><form action="payments" method="get">
						<input type="submit" value="Payments">
					</form></td>
				<td><form action="register" method="get">
						<input type="submit" value="Register">
					</form></td>

			</tr>
		</table>
	</center>
</body>