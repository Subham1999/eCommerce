<!DOCTYPE html>
<%@page import="user.UserDAO"%>
<%@page import="user.User"%>
<html>
<head>
<meta charset="ISO-8859-1">

<%@include file = "common_css_js.jsp" %>
<title>admin page</title>
</head>
<body class="container admin">
	<%@ include file = "components/navbar.jsp" %>
	
	<div class="container text-center"> <h3>ADMIN PAGE</h3> </div>
	
	<div class="container mt-5">
		<div class="row">
			<div class="col-6">
				<div class="card card-add-product">
					<div class="card-body"  data-toggle="modal" data-target="#add-product">
						<div class="container text-center">
						 <h5 style="color:white"><b>Add product</b></h5>
						</div>
					</div>
				</div>
			</div>
			<div class="col-6">
				<div class="card card-remove-product">
					<div class="card-body">
						<div class="container text-center">
						 <h5 style="color:white"><b>Remove product</b></h5>
						</div>
					</div>
				</div>
			</div> 
		</div>
	</div>
	
	
	<!-- Button trigger modal -->
	
	<!-- Modal -->
	<div class="modal fade" id="add-product" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header bg-success">
	      	<div class="container text-center"><h5 style="color:white"><b>Add product</b></h5></div>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<form action="add-product" method="post">
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
	
</body>
</html>
