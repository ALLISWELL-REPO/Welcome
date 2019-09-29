<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String contextPath = (String) request.getContextPath();
%>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<script type="text/javascript">
	function getJsonResponse() {
		$.ajax({
			  type: "GET",
			  url: getContextPath() + "/getjson/",
			  success: function(response) {
				  var resp = response.results[0].id + ", " + response.results[0].name + ", " + response.results[0].account + ", " + response.results[0].branch;
				  $( "#json_resp_para" ).html( resp );
			  }
			});
	}
	
	function getContextPath() {
		return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	}
</script>
</head>

<body>
	<h1>Hello World Dynamic</h1>
	
	<button type="submit" class="btn btn-default" onclick="javascript:getJsonResponse()">Get Json Response</button>
	
	<p id="json_resp_para"></p>
	
</body>
</html>