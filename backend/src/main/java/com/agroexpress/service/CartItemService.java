package com.agroexpress.service;


import com.agroexpress.exception.CartItemException;
import com.agroexpress.exception.UserException;
import com.agroexpress.model.CartItem;

public interface CartItemService {
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;
	public void removeCartItem(Long userId,Long cartItemId) throws CartItemException, UserException;
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
	
}


