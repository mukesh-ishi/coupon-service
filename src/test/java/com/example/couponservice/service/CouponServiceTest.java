package com.example.couponservice.service;

import com.example.couponservice.entity.Coupon;
import com.example.couponservice.repository.CouponRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CouponServiceTest {

    @Mock
    CouponRepo couponRepo;

    @InjectMocks
    CouponServiceImpl couponService;

    @Test
    public void registerCouponTest() {
        Coupon coupon = new Coupon();
        coupon.setCode("SUPERSALE");
        when(couponRepo.save(coupon)).thenReturn(coupon);
        Coupon createCoupon = couponService.registerCoupon(coupon);
        verify(couponRepo).save(coupon);
        assertNotNull(createCoupon);
        assertEquals("SUPERSALE", coupon.getCode());
    }

    @Test
    public void fetchCouponTest() {
        Coupon coupon = new Coupon();
        coupon.setCId(123);
        coupon.setCode("SUPERSALE");
        coupon.setDiscount(new BigDecimal(10));
        coupon.setExpDate(LocalDate.of(2022, 07, 05));
        when(couponRepo.findByCode("SUPERSALE")).thenReturn(coupon);
        Coupon couponResponse = couponService.fetchCoupon("SUPERSALE");
        verify(couponRepo).findByCode("SUPERSALE");
        assertNotNull(couponResponse);
        assertEquals("SUPERSALE", couponResponse.getCode());
        assertEquals(new BigDecimal(10), couponResponse.getDiscount());
    }
}
