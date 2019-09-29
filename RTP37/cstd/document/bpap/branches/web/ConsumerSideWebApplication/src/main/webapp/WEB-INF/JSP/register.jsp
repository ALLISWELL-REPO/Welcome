<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<body bgcolor="lightblue">
	<center style="margin-top: 100px;">
		<h1 style="color: green;">Welcome to O2Login Page</h1>
		<form action="register" method="post">
			<fieldset
				style="height: 170px; width: 80px; color: darkblue; border-color: lightgreen">
				<table>

					<tr>
						<td>MobileNo:</td>
						<td><input type="number" name="mobNo" required
							value="${regFormData.mobNo}"
							style="height: 20px; width: 160px; font-size: 14px; color: darkblue;"></td>
					</tr>
					<tr>
						<td>CardNumb:</td>
						<td><input type="number" name="cardNumb" required
							value="${regFormData.cardNumb}"
							style="height: 20px; width: 160px; font-size: 14px; color: darkblue;"></td>
					</tr>
					<tr>
						<td>CVV:</td>
						<td><input type="number" name="cvv" value="${regFormData.cvv}" required
							style="height: 20px; width: 160px; font-size: 14px; color: darkblue;"></td>
					</tr>
					<tr>
						<td>ExpDate:</td>
						<td><input type="text" name="expDate" required
							value="${regFormData.expDate}"
							style="height: 20px; width: 160px; font-size: 14px; color: darkblue;"></td>
					</tr>
					<tr>
						<td>NameOnCard:</td>
						<td><input type="text" name="nameOnCard" required
							value="${regFormData.nameOnCard}"
							style="height: 20px; width: 160px; font-size: 14px; color: darkblue;"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Register" 
							style="height: 23px; width: 165px; font-size: 16px; color: darkblue;"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</center>
</body>