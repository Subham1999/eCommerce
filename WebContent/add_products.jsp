<!DOCTYPE html>
<%@page import="user.UserDAO"%>
<%@page import="user.User"%>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file = "common_css_js.jsp" %>
<title>add product</title>
<%
String status = (String)session.getAttribute("user_status");
if(status == null){
	session.setAttribute("message", "access denied :(");
	response.sendRedirect("error.jsp");
	return;
}
if(status.equals("not_admin")){
	session.setAttribute("message", "You're not our admin :(");
	response.sendRedirect("error.jsp");
	return;
}
%>
</head>
<body class="container">
	<%@ include file = "components/navbar.jsp" %>
</body>
</html>
