package eCommerce.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		description = "help user to log out", 
		urlPatterns = { 
				"/Logout", 
				"/logout", 
				"/log-out"
		})
public final class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Logout() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("user_name");
			session.removeAttribute("user_password");
			session.removeAttribute("user_status");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			response.sendRedirect("index.jsp");
		}
		return;
	}

}
