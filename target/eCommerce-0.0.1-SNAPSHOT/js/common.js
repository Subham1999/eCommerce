function add_to_cart(user_name, p_id, p_price, p_name){
	var raw_cart = localStorage.getItem("cart");
	var new_product = {user: user_name, id: p_id, price: p_price, name: p_name, qty: 1};
	if(raw_cart == null){
		var cart = [];
		cart.push(new_product);
		localStorage.setItem("cart", JSON.stringify(cart));
	} else{
		var cart = JSON.parse(raw_cart);
		var if_present = false;
		cart.map((item) => {
			if(item.id == p_id && item.user == user_name){
				item.qty = item.qty + 1;
				if_present = true;
		}});
		if(if_present == false){ cart.push(new_product);}
		localStorage.setItem("cart", JSON.stringify(cart));
	}
	update_cart();
}
function update_cart(){
	var raw_cart = localStorage.getItem("cart");
	if(raw_cart == null){
		document.getElementById('cart').innerHTML = 'cart(0)';
	} else{
		var user_name = document.getElementById('user_name').innerHTML;
		console.log(user_name);
		var cart = JSON.parse(raw_cart);
		var length = 0;
		cart.map((item) => {
			if(item.user == user_name){
				length = length + 1;
			}
		});
		document.getElementById('cart').innerHTML = 'cart('+ length + ')';
	}
}