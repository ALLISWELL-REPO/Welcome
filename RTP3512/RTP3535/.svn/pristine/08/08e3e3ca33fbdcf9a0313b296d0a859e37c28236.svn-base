<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function searchId(){
	var btn2=document.getElementById("btn2").value;
	console.log(btn2);
	var id=document.getElementById("id")
	id.readOnly=false;
	id.value=""
	var fname=document.getElementById("fname");
	fname.readOnly=true;
	console.log(fname);
	fname.value="";
	var lname=document.getElementById("lname")
	lname.readOnly=true;
	lname.value="";
	console.log(lname);
	var dob=document.getElementById("dob");
	dob.value="";
	var gender=document.getElementById("gender");
	gender.readOnly=true;
	gender.value=""
	var p=document.getElementById("postalCode");
	p.readOnly=true;
	p.value="";
	
}
function exsearch(){
	var btn1=document.getElementById("btn1").value;
	console.log(btn1);
	document.getElementById("id").readOnly=false;
	document.getElementById("fname").readOnly=false;
	document.getElementById("lname").readOnly=false;
	document.getElementById("dob").readOnly=false;
	document.getElementById("gender").readOnly=false;
	document.getElementById("postalCode").readOnly=false;
}
</script>
</head>
<body>

<form action="search" method="post">
<button type="button" id="btn1"  value="Ex" onclick="exsearch()" >Extended search</button>
<button type="button" id="btn2" value="search" onclick="searchId()" value=search>Search</button>
Id<input type="text" id="id" name="id" readonly="true"/><br><br><br>
Fname<input type="text" id="fname" name="fname" readonly="true"/><br>
Lname<input type="text" id="lname" name="lname" readonly="true"/><br><br>
DOB<input type="text" id="dob"readonly="true" name="dob"/><br>
Gender<input type="text" id="gender"  name="gender" readonly="true"/><br>
Postal code<input type="text" id="postalCode" name="postalCode" readonly="true"/>
<input type="submit" value="Search"/>
</form>
</body>
</html>