<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sign up</title>
<%@include file = "common_css_js.jsp" %>
</head>
	<body class="container">
		<%@ include file = "components/navbar.jsp" %>	
		<div class="row mt-3">
		 	<div class="col-md-4 offset-md-4">
		 		<div class="card">
		 			<div class="card-body">
					 	<form action="Signup" method="post">
					 	 <h4 class="text-center"><b>Signup here</b></h4>
						 <div class="form-group">
						   <label for="user_name">user name</label>
						   <input type="text" class="form-control" id="user_name" name="user_name" required placeholder="your user name">
						 </div>
						 
						 <div class="form-group">
						   <label for="user_name">password</label>
						   <input type="password" class="form-control" id="user_password" name="user_password" required placeholder="your password" aria-describedby="password-help">
						   <small id="password-help" class="form-text text-muted">Don't worry!! your password is safe with us.</small>
						 </div>
						 
						 <button type="submit" class="btn btn-success">sign up</button>
						 <button type="reset" class="btn btn-secondary">reset</button>
						</form>
					</div>
				</div>
		 	</div>
		 </div>
	</body>
</html>