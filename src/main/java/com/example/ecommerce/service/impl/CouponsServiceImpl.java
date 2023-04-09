package com.example.ecommerce.service.impl;

import com.example.ecommerce.dao.CouponsRepository;
import com.example.ecommerce.mappers.CouponsMapper;
import com.example.ecommerce.modules.Coupons;
import com.example.ecommerce.modules.dto.CouponsDto;
import com.example.ecommerce.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponsServiceImpl implements CouponsService {

    @Autowired
    CouponsRepository couponsRepository;

    @Override
    public CouponsDto saveCoupon(CouponsDto couponsDto) {
        Coupons newCoupon = CouponsMapper.INSTANCE.toCoupons(couponsDto);
        couponsRepository.save(newCoupon);
        return CouponsMapper.INSTANCE.toCouponsDto(newCoupon);
    }

    @Override
    public List<CouponsDto> getAllCoupons() {
        List<Coupons> couponsList = couponsRepository.findAll();
        return CouponsMapper.INSTANCE.toCouponsDtoList(couponsList);
    }
}
