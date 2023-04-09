package com.example.ecommerce.mappers.impl;

import com.example.ecommerce.mappers.CouponsMapper;
import com.example.ecommerce.modules.Coupons;
import com.example.ecommerce.modules.dto.CouponsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponsMapperImpl implements CouponsMapper {

    @Override
    public Coupons toCoupons(CouponsDto couponsDto) {
        Coupons coupons = new Coupons();
        coupons.setId(couponsDto.getId());
        coupons.setCouponName(couponsDto.getCouponName());
        coupons.setAppLiedSku(couponsDto.getAppLiedSku());
        coupons.setDiscountPrice(couponsDto.getDicountPrice());
        return coupons;
    }

    @Override
    public CouponsDto toCouponsDto(Coupons coupons) {
        CouponsDto couponsDto = new CouponsDto();
        couponsDto.setId(coupons.getId());
        couponsDto.setCouponName(coupons.getCouponName());
        couponsDto.setAppLiedSku(coupons.getAppLiedSku());
        couponsDto.setDicountPrice(coupons.getDiscountPrice());
        return couponsDto;
    }

    @Override
    public List<Coupons> toCouponsList(List<CouponsDto> couponsDtoList) {
        List<Coupons> couponsList = new ArrayList<>();
        for(CouponsDto couponsDto : couponsDtoList){
            couponsList.add(toCoupons(couponsDto));
        }
        return couponsList;
    }

    @Override
    public List<CouponsDto> toCouponsDtoList(List<Coupons> couponsList) {
        List<CouponsDto> couponsDtoList = new ArrayList<>();
        for(Coupons coupons : couponsList){
            couponsDtoList.add(toCouponsDto(coupons));
        }
        return couponsDtoList;
    }
}
