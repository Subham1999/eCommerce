package order;

import java.util.List;

import products_and_goods.ProductDAO;
public class Bill {
	private double totalCost = 0;
	
	public void addPrice(long id) {
		totalCost += ProductDAO.getProduct(id).getPrice();
	}
	
	public double generateBill(Cart cart) {
		List<Long> productList = cart.getProductList();
		productList.forEach(id -> addPrice(id));
		return this.totalCost;
	}
}
