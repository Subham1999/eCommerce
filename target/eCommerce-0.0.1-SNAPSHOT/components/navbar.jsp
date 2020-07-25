<%
 String nav_status = (String)session.getAttribute("user_status");
%>


<nav class="mt-2 navbar navbar-expand-lg navbar-dark custom-bg nav-bar-edit">
  <div class="container">
  <a class="navbar-brand" href="index.jsp"><b>your'Shop</b></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Category
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Laptop</a>
          <a class="dropdown-item" href="#">Computer</a>
          <a class="dropdown-item" href="#">Phone</a>
        </div>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
    <%
    	if(nav_status == null){
    %>
    	<li class="nav-item">
    		<a class="nav-link" href="login.jsp">log in</a>
    	</li>
    	<li class="nav-item">
    		<a class="nav-link" href="signup.jsp">sign up</a>
    	</li>
    <%
    	} else {
    		if(nav_status.equals("admin")){
    %>
    	<li class="nav-item">
    		<a class="nav-link" href="admin_page.jsp"><b>admin portal</b></a>
    	</li>
    <%}%>
    	<li class="nav-item">
   			<a class="nav-link" href="#!"><%=session.getAttribute("user_name")%></a>
    	</li>
    	<li class="nav-item">
    		<form action="Logout" method = "post">
    		<button type="submit" class="btn btn-outline-warning">log out</button>
    		</form>
    	</li>
    <%}%>	
    </ul>
    
  </div>
  </div>
</nav>