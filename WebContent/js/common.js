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
	var user_name = document.getElementById('user_name').innerHTML;
	var raw_cart = localStorage.getItem("cart");
	if(raw_cart == null){
		document.getElementById('cart').innerHTML = 'cart(0)';
	} else{
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
function show_cart_list_in_modal_body(){
	var user_name = document.getElementById('user_name').innerHTML;
	var raw_cart = localStorage.getItem("cart");
	if(raw_cart == null){
		document.getElementById('modal-btn-save').classList.add("disabled");
		document.getElementById('modal-btn-save').innerHTML = "Nothing to save";
	} else{
		var cart = JSON.parse(raw_cart);
		var product_list = [];
		cart.map((item) => {
			if(item.user == user_name){
				product_list.push(item);
			}
		});
		if(product_list.length == 0){
			document.getElementById('modal-btn-save').classList.add("disabled");
			document.getElementById('modal-btn-save').innerHTML = "Nothing to save";
		} else{
			var list_of_products = "";
			var total_price = 0;
			for(var i = 0; i < product_list.length; i++){
				list_of_products += "<li class=\"list-group-item cart-modal-body-list-item\">"
					+ "<button type=\"button\" class=\"btn btn-sm btn-secondary\" disabled><b>" + product_list[i].name + "</b></button> "
			 		+ "<button type=\"button\" class=\"btn btn-sm btn-success\" disabled>Rs. " + product_list[i].price + "/-</button>\t"
			 		+ "<button type=\"button\" class=\"btn btn-sm btn-primary\" disabled>qty(" + product_list[i].qty + ")</button>\t"
			 		+ "<button type=\"button\" class=\"btn btn-sm btn-danger\" disabled> remove </button>"
			 		+ "</li>";
				total_price += product_list[i].qty * product_list[i].price;
			}
			document.getElementById('cart-modal-body-list').innerHTML = list_of_products;
			document.getElementById('total-price').innerHTML = "<button type=\"button\" class=\"btn btn-sm btn-success\" disabled>Total Rs. "
				+ total_price + "/--</button>\t";
		}
	}
}






