package products_and_goods;

/*
 *	Types are supported 
 *   PHONE,
 *   COMPUTER,
 *   WASHINGMACHINE,
 *   LAPTOP
*/
final class BuildProduct {

	public static final Product buildProduct(String name, String type, double price, String description, byte[] imageData) {
		ProductType productType = null;
		if(type.equalsIgnoreCase("phone")) {
			productType = ProductType.PHONE;
		} else if(type.equalsIgnoreCase("computer")) {
			productType = ProductType.COMPUTER;
		} else {
			productType = ProductType.LAPTOP;
		}
		
		Product product = new Product();
		product.setDescription(description);
		product.setPrice(price);
		product.setProductType(productType);
		product.setName(name);
		product.setData(imageData);
		return product;
	}
	
	
}
