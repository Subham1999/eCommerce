package eCommerce.service;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import products_and_goods.ProductDAO;

@WebServlet(
		description = "Add products to database", 
		urlPatterns = { 
				"/AddProduct", 
				"/add-product"
		})
@MultipartConfig(maxFileSize = 30*1024*1024)
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddProduct() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO.storeProduct(
				request.getParameter("product_name"), 
				request.getParameter("product_type"), 
				request.getParameter("product_price"),
				request.getParameter("product_description"), 
				getServletContext().getRealPath(File.separator) + File.separator + "img",
				request.getPart("product_picture")
			);
		response.sendRedirect("admin_page.jsp");
		return;
	}

}
