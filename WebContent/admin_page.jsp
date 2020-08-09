<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="user.UserDAO"%>
<%@page import="user.User"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin page</title>

<%String status = (String)session.getAttribute("user_status");%>
<%
if(status == null){
	session.setAttribute("message", "Access denied");
	response.sendRedirect("error.jsp");
	return;
} else if(status.equals("not_admin")){
	session.setAttribute("message", "You're not an authorized admin");
	response.sendRedirect("error.jsp");
	return;
}
%>

<%@include file = "common_css_js.jsp" %>

</head>
<body class="container admin">
	<%@ include file = "components/navbar.jsp" %>
	
	<div class="container text-center"> <h3>ADMIN PAGE</h3> </div>
	
	<div class="row mt-5">
		<div class="col-2">
			<div class="list-group">
			  <button type="button" class="btn btn-success list-group-item list-group-item-action" data-toggle="modal" data-target="#add-product">
			  add product</button>
			  <button type="button" class="btn btn-warning list-group-item list-group-item-action">remove products</button>
			  <button type="button" class="btn btn-primary list-group-item list-group-item-action">products list</button>
			  <button type="button" class="btn btn-primary list-group-item list-group-item-action" data-toggle="modal" data-target="#list-all-user">
			   user list
			  </button>
			  <button type="button" class="btn btn-danger list-group-item list-group-item-action">remove user</button>
			</div>
		</div>
		
		<!-- Admin details -->
		<div class="col-6 text-center">
			Hey admin whatsup!!
		</div>
		
		
	</div>
	
	<!-- Modal for adding products -->
	
	<div class="modal fade" id="add-product" tabindex="-1" role="dialog" aria-labelledby="addProductModal" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header bg-success">
	      	<div class="container text-center"><h5 style="color:white"><b>Add product</b></h5></div>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<form action="add-product" enctype="multipart/form-data" method="post">
			  <div class="form-group">
			    <label for="product_name">product name</label>
			    <input type="text" class="form-control" id="product_name" name="product_name" placeholder="name of the product" required>
			  </div>
			  
			  <div class="form-group">
			    <label for="product_type">product type</label>
			    <select class="form-control" id="product_type" name="product_type" required>
			      <option>Laptop</option>
			      <option>Computer</option>
			      <option>Phone</option>
			    </select>
			  </div>
			  
			  <div class="form-group">
			    <label for="product_price">product price</label>
			    <input type="number" class="form-control" id="product_price" name="product_price" placeholder="price" required>
			  </div>
			  
			  <div class="form-group">
			    <label for="product_description">product description</label>
			    <textarea class="form-control" id="product_description" name="product_description" rows="3" required></textarea>
			  </div>
			  
			  <div class="form-group">
			    <label for="product_picture">choose file to upload</label>
			    <input type="file" class="form-control" id="product_picture" name="product_picture" required>
			  </div>
			  
			  <div class="container mr-5">
			  	<div>
			  		<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        		<button type="submit" class="btn btn-primary">submit</button>
	        	</div>
			  </div>
			</form>
	      </div>	
	    </div>
	  </div>
	</div>
	
	<div class="modal fade" id="list-all-user" tabindex="-1" aria-labelledby="list-all-user" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-scrollable">
	    <div class="modal-content">
	      <div class="modal-header custom-bg">
	        <h5 class="modal-title" id="list-all-user-modal-title">List of all user</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<%List<User> list = UserDAO.getUserList();%>
	      	<ul class="list-group">
	      	<% for(User user : list){%>		  
			  <li class="list-group-item">
			  	<ul class="list-group">
			  		<li class="list-group-item"><%=user.getName()%></li>
			  		<li class="list-group-item"><%=user.getPassword()%></li>
			  	</ul>
			  	<%if(user.getStatus().equalsIgnoreCase("not_admin")){%>
			  		<button class="btn-sm btn-danger">remove</button>
			  	<%}%>
			  </li>
			<%}%>
			</ul>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>
