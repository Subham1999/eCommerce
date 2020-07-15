package eCommerce.service;

import java.io.IOException;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import sessionmanagement.SessionHandler;

@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Login() { super();}

    private boolean performLoginOperation(HttpServletRequest request) throws Exception{
    	String user_name = request.getParameter("user_name");
    	String user_password = request.getParameter("user_password");
    	String user_status = request.getParameter("user_status");
    	
    	SessionHandler sessionHandler = SessionHandler.getSessionHandler();
    	Session session = sessionHandler.getSession();
    	String hql;
    	if(user_status.equals("admin")) {
    		hql = "from Admin where name=:user_name and password=:user_password";
    	} else {
    		hql = "from Customer where name=:user_name and password=:user_password";
    	}
    	Query query = session.createQuery(hql);
    	query.setParameter("user_name", user_name);
    	query.setParameter("user_password", user_password);
    	boolean notValid = query.getResultList().isEmpty();
    	sessionHandler.closeSession(session);
    	return notValid;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(request.getParameter("user_name")).append(request.getParameter("user_password"));
		try {
			boolean notValid = performLoginOperation(request);
			Cookie cookies[] = new Cookie[3];
			if(notValid == false) {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// HandleException
		}
	}

}
