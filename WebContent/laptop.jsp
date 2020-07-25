<%@page import="products_and_goods.Product"%>
<%@page import="java.util.List"%>
<%@page import="products_and_goods.ProductType"%>
<%@page import="products_and_goods.ProductDAO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file = "common_css_js.jsp" %>
<title>laptops</title>
<%String status = (String)session.getAttribute("user_status");
if(status == null){
	session.setAttribute("message", "Access denied");
	response.sendRedirect("error.jsp");
	return;
}
%>

</head>
<body class="container">
	<%@ include file = "components/navbar.jsp" %>
	
	<%
	final List<Product> list = ProductDAO.getLaptop();
	if(list == null){
	%>
		<div class="container text-center">
			<h5>Something isn't right</h5>
		</div>
	<%
	} else if(list.size() == 0){
	%>
		<div class="container text-center">
			<h5>No laptop is available</h5>
		</div>
	<%
	} else{
		
		for(Product product : list){
			%>
			<div class="container text-center">
				<%=product.getName() + " " + product.getPicture() + "\n" %>
			</div>
			<%
		}
	}%>
</body>
</html>