package com.agroexpress.service;

import com.agroexpress.exception.OrderException;
import com.agroexpress.model.Address;
import com.agroexpress.model.Cart;
import com.agroexpress.model.Order;
import com.agroexpress.model.User;
import com.agroexpress.model.enums.OrderStatus;

import java.util.List;
import java.util.Set;

public interface OrderService {
	
	public Set<Order> createOrder(User user, Address shippingAddress, Cart cart);
	public Order findOrderById(Long orderId) throws OrderException;
	public List<Order> usersOrderHistory(Long userId);
	public List<Order>getShopsOrders(Long sellerId);
	public Order updateOrderStatus(Long orderId,
								   OrderStatus orderStatus)
			throws OrderException;
	public void deleteOrder(Long orderId) throws OrderException;
	Order cancelOrder(Long orderId,User user) throws OrderException;
	
}


