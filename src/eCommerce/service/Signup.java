package eCommerce.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import user.UserDAO;

@WebServlet(
		description = "Registering a new user", 
		urlPatterns = { 
				"/Signup", 
				"/signup"
		})
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Signup() {
        super();
    }
    
    private boolean storeUser(String name, String password) {
    	String status = "not_admin";
    	User user = new User();
    	user.setName(name);
    	user.setPassword(password);
    	user.setStatus(status);
    	return UserDAO.storeUser(user);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		
		// Check if an user with same credential already exists or not;
		// By calling DAO
		
		if(UserDAO.getUser(name, password) == null) {
			if(storeUser(name, password)) {
				request.getSession().setAttribute("user_name", name);
				request.getSession().setAttribute("user_status", "not_admin");
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}
		} else {
			request.getSession().setAttribute("message", "Same user already exist");
			response.sendRedirect("error.jsp");
		}
	}

}
