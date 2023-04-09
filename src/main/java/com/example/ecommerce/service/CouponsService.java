package com.example.ecommerce.service;

import com.example.ecommerce.modules.dto.CouponsDto;

import java.util.List;

public interface CouponsService {

    CouponsDto saveCoupon(CouponsDto couponsDto);
    List<CouponsDto> getAllCoupons();

}
