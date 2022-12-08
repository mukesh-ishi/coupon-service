package com.example.couponservice.service;

import com.example.couponservice.entity.Coupon;
import com.example.couponservice.repository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

@Service("couponService")
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponRepo couponRepo;

    @Override
    public Coupon registerCoupon(Coupon coupon) {
        return couponRepo.save(coupon);
    }

    @Override
    public Coupon fetchCoupon(String code) {
        return couponRepo.findByCode(code);
    }
}
