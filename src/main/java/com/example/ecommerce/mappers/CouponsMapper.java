package com.example.ecommerce.mappers;

import com.example.ecommerce.mappers.impl.CouponsMapperImpl;
import com.example.ecommerce.modules.Coupons;
import com.example.ecommerce.modules.dto.CouponsDto;

import java.util.List;

public interface CouponsMapper {

    CouponsMapper INSTANCE = createInstance();

    static CouponsMapper createInstance(){
        return new CouponsMapperImpl();
    }

    Coupons toCoupons(CouponsDto couponsDto);
    CouponsDto toCouponsDto(Coupons coupons);

    List<Coupons> toCouponsList(List<CouponsDto> couponsDtoList);
    List<CouponsDto> toCouponsDtoList(List<Coupons> couponsList);
}
