package products_and_goods;

/*
 *	Types are supported 
 *   PHONE,
 *   COMPUTER,
 *   WASHINGMACHINE,
 *   LAPTOP
*/
final class BuildProduct {
	public static final Product buildProduct(int type, double price, String description) {
		ProductType productType = null;
		if(type == 0) {
			productType = ProductType.PHONE;
		} else if(type == 1) {
			productType = ProductType.COMPUTER;
		} else if(type == 2) {
			productType = ProductType.WASHINGMACHINE;
		} else if(type == 3) {
			productType = ProductType.LAPTOP;
		}
		
		Product product = new Product();
		product.setDescription(description);
		product.setPrice(price);
		product.setProductType(productType);
		
		return product;
	}
}
