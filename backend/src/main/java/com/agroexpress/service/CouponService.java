package com.agroexpress.service;



import com.agroexpress.model.Cart;
import com.agroexpress.model.Coupon;
import com.agroexpress.model.User;

import java.util.List;
import java.util.Optional;

public interface CouponService {
    Cart applyCoupon(String code, double orderValue, User user) throws Exception;
    Cart removeCoupon(String code, User user) throws Exception;
    Coupon createCoupon(Coupon coupon);
    void deleteCoupon(Long couponId);
    List<Coupon> getAllCoupons();
    Coupon getCouponById(Long couponId);
}


