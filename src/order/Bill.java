package order;

import java.util.List;

import products_and_goods.ProductDAO;
import user.Customer;
import user.UserDAO;

public class Bill {
	private Customer customer;
	private double totalCost = 0;
	
	public void addPrice(long id) {
		totalCost += ProductDAO.getProduct(id).getPrice();
	}
	
	public String generateBill(Cart cart) {
		customer = UserDAO.getCustomer(cart.getUserID());
		List<Long> productList = cart.getProductList();
		productList.forEach(id -> addPrice(id));
		return "Name : " + customer.getFirstName() + " " + customer.getLastName() + "\n"
				+ "Total Amount Rs. " + totalCost + "/-\n"
						+ "No. of items in cart = " + productList.size() + ". ";
	}
	
	
}
