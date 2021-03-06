package eCommerce.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import user.User;
//import user.UserDAO;

@WebServlet(
		description = "Testing of Service module", 
		urlPatterns = { 
				"/TestService", 
				"/test-service"
		})
public class TestService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TestService() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append(System.getProperty("catalina.base"));
//		ServletContext context = getServletContext();
		response.getWriter().append(getServletContext().getRealPath(File.separator) + File.separator + "img");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
