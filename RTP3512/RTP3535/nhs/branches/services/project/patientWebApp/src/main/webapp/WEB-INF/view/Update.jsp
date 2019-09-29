<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updatepatient" method="post">
FName<input type="text" id="fname" name="fname"/><br>
LName<input type="text" id="lname" name="lname"/><br>
PostalCode<input type="text" id="postalCode" name="postalCode"/><br>
Gender<input type="text" id="gender" name="gender"/><br>
NationalIdentifierType<input type="text" id="nationalIdentifierType" name="nationalIdentifierType"/><br>
NationalPatientId<input type="text" id="nationalPatientId" name="nationalPatientId"/><br>
DOB<input type="text" id="DOB" name="dob"/><br>
Id<input type="text" id="id" name="id"/><br>
CreatedDate<input type="text" id="createdDate" name="createdDate"/><br>
UpdatedDate<input type="text" id="updatedDate" name="updatedDate"/><br>
CreatedBy<input type="text" id="createdBy" name="createdBy"/><br>
UpdatedBy<input type="text" id="updatedBy" name="updatedBy"/><br>
NhsNumber<input type="text" id="nhsNumber" name="nhsNumber"/><br>
Hnum<input type="text" id="hnum" name="hnum"/><br>
<input type="submit" name="Update" value="Update"/>
</form>
</body>
</html>