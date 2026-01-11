package com.agroexpress.service;

import com.agroexpress.exception.WishlistNotFoundException;
import com.agroexpress.model.Product;
import com.agroexpress.model.User;
import com.agroexpress.model.Wishlist;
import java.util.Optional;

public interface WishlistService {
    Wishlist createWishlist(User user);
    Wishlist getWishlistByUserId(User user);
    Wishlist addProductToWishlist(User user, Product product) throws WishlistNotFoundException;

}



