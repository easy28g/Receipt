package com.example.ecommerce.controllers;

import com.example.ecommerce.modules.dto.CouponsDto;
import com.example.ecommerce.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponControllers {

    @Autowired
    private CouponsService couponsService;

    //  adding new discounts for products
    @PostMapping("/save-coupon")
    public CouponsDto send(@RequestBody CouponsDto couponsDto){
        return couponsService.saveCoupon(couponsDto);
    }

    //  we get a list of discounts for items
    @GetMapping("/get-all-coupons")
    public List<CouponsDto> getAllCoupons(){
        return couponsService.getAllCoupons();
    }

}
