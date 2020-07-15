package eCommerce.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.Admin;
import user.Customer;
import user.UserDAO;

/**
 * Servlet implementation class Signup
 */
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
    
    private boolean registerNewCustomer(String user_name, String user_password, String firstname, String lastname, String mail) {
    	Customer customer = new Customer();
    	customer.setName(user_name);
    	customer.setPassword(user_password);
    	customer.setFirstName(firstname);
    	customer.setLastName(lastname);
    	customer.setMailID(mail);
    	boolean result;
    	try {
    		UserDAO.storeCustomer(customer);
    		result = true;
    	} catch(Exception e) {
    		e.printStackTrace();
    		result = false;
    	}
    	return result;
    }
    
    private boolean registerNewAdmin(String user_name, String user_password, String firstname, String lastname, String mail) {
    	Admin admin = new Admin();
    	admin.setName(user_name);
    	admin.setPassword(user_password);
    	admin.setFirstName(firstname);
    	admin.setLastName(lastname);
    	admin.setMailID(mail);
    	boolean result;
    	try {
    		UserDAO.storeAdmin(admin);
    		result = true;
    	} catch(Exception e) {
    		e.printStackTrace();
    		result = false;
    	}
    	return result;
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String mail = request.getParameter("mail");
		String user_status= request.getParameter("user_status");
		boolean result;
		if(user_status.equals("admin")) {
			result = registerNewAdmin(user_name, user_password, firstname, lastname, mail);
		} else {
			result = registerNewCustomer(user_name, user_password, firstname, lastname, mail);
		}
		if(result) {
			Cookie cookies[] = new Cookie[3];
			cookies[0] = new Cookie("user_name", request.getParameter("user_name"));
			cookies[1] = new Cookie("user_password", request.getParameter("user_password"));
			if(request.getParameter("user_status").equals("admin")) {
				cookies[2] = new Cookie("user_status", "admin");
			} else {
				cookies[2] = new Cookie("user_status", "customer");
			}
			for(int i = 0; i < 3; ++i) {
				cookies[i].setMaxAge(10000);
				response.addCookie(cookies[i]);
			}
			response.sendRedirect("index.html");
		} else {
			response.sendRedirect("error.html");
		}
	}

}
