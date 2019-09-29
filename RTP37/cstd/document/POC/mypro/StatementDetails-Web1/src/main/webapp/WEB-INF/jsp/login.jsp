<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body bgcolor="lightblue">
	<p align="center"></p>
	<center style="margin-top: 80px;">
		<h1 style="color: green;">Welcome to Login Page</h1>
		<form action="citybank.html" method="post">
		<!-- 	<fieldset
				style="height: 187px; width: 298px; color: blue; border-color: blue"> -->
				<table bgcolor="gray" border="1">
					<tr>
						<td>UserName:</td>
						<td><input type="text" name="username" required
							style="height: 35px; width: 160px; font-size: 20px; color: blue;"/></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="pwd" required
							style="height: 35px; width: 160px; font-size: 20px; color: blue;"/></td>
					</tr>

					<tr>
						<td colspan="2" sytyle="text-align:center"><input type="submit" value="Login" 
							style="height: 35px; width: 160px; font-size: 20px; color: blue; text-align:center;" /></td>
					</tr>
				</table>
			<!-- </fieldset> -->
		</form>
	</center>
</body>