package eCommerce.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import user.UserDAO;

@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Login() { super();}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
    	String user_password = request.getParameter("user_password");
		try {
			User user = UserDAO.getUser(user_name, user_password);
			 	if(user == null) {
			 		request.getSession().setAttribute("message", user_name + " doesn't exist in our database!");
			 		response.sendRedirect("error.jsp");
			 	} else {
			 		request.getSession().setAttribute("user_name", user.getName());
			 		request.getSession().setAttribute("user_password", user.getPassword());
			 		request.getSession().setAttribute("user_status", user.getStatus());
			 		response.sendRedirect("index.jsp");
			 	}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
