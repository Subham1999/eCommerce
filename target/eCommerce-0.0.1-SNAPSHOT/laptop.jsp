<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
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
	<% } else{ %>
		<div class="card-columns mt-5">
		<%
		for(Product product : list){
			%>
			
			<div class="container text-center">
				<div style="max-width: 350px"class="card">
					<div style="color:white;" class="card-header custom-bg-2">
						<%=product.getName()%>
					</div>
					<div class="card-body">
						<div class="container">
							<img class="img-fluid"src="data:image/jpg;base64,<%=product.base64image()%>" />
						</div>
						<div class="container">
							<%=product.getDescription()%>
						</div>
					</div>
					<div class="card-footer custom-bg-2">
						<!-- <form> -->
							<button class="btn btn-primary" 
							onclick="add_to_cart(
								'<%=(String)session.getAttribute("user_name")%>', <%=product.getProductID()%>, <%=product.getPrice()%>, '<%=product.getName()%>'
							)">
							add to cart
							</button>
						<!-- </form> -->
						<button class="btn btn-success">Rs. <%=product.getPrice()%></button>
					</div>
				</div>
			</div>
			<%
		}
		%>
		</div>
	<%
	}%>
</body>
</html>