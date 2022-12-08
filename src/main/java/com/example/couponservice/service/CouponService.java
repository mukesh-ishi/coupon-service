package com.example.couponservice.service;

import com.example.couponservice.entity.Coupon;

public interface CouponService {
    public Coupon registerCoupon(Coupon coupon);

    public Coupon fetchCoupon(String code);

}
