package com.agroexpress.service;


import com.agroexpress.exception.ProductException;
import com.agroexpress.model.Cart;
import com.agroexpress.model.CartItem;
import com.agroexpress.model.Product;
import com.agroexpress.model.User;

public interface CartService {
	
	public CartItem addCartItem(User user,
								Product product,
								String size,
								int quantity) throws ProductException;
	public Cart findUserCart(User user);

}


