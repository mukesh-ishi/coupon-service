package com.example.couponservice.controller;

import com.example.couponservice.entity.Coupon;
import com.example.couponservice.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponApi")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @PostMapping("/addCoupon")
    public Coupon saveCoupon(@RequestBody Coupon coupon) {
        if (coupon == null) {
            throw new IllegalArgumentException("Coupon is required");
        }

        Coupon coupons = couponService.registerCoupon(coupon);
        return coupons;
    }

    @GetMapping("/getCoupon/{code}")
    public Coupon getCoupon(@PathVariable("code") String code) {
        Coupon coupon = couponService.fetchCoupon(code);
        return coupon;
    }
}
