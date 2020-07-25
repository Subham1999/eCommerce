<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>error</title>
<%@include file = "common_css_js.jsp" %>
</head>
<body class = "container">
	<%@ include file = "components/navbar.jsp" %>
	<div class="container text-center"><h1>ERROR 404!!</h1></div>
	<div class="container text-center">
		 <h3> <%= session.getAttribute("message") %></h3>	
		<%session.removeAttribute("message");%>
	</div>
</body>
</html>