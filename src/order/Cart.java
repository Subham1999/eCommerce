package order;

import java.util.List;

public class Cart {
	private List<Long> productList;
	private long userID;
	
	public Cart(long userID) {
		this.userID = userID;
	}
	
	public void addToCart(long productID) {
		this.productList.add(productID);
	}
	
	public void removeFromCart(long productID) {
		this.productList.remove(productID);
	}

	public List<Long> getProductList() {
		return productList;
	}

	public long getUserID() {
		return userID;
	}

}
