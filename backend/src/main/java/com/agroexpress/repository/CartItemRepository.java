package com.agroexpress.repository;

import com.agroexpress.model.Cart;
import com.agroexpress.model.CartItem;
import com.agroexpress.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartAndProductAndSize(Cart cart, Product product, String size);

}


