package com.example.ecommerce.modules.dto;

import java.math.BigDecimal;

public class CouponsDto {

    private Long id;

    private String couponName;

    private int appLiedSku;

    private double dicountPrice;

    public CouponsDto() {
    }

    public CouponsDto(Long id, String couponName, int appLiedSku, double dicountPrice) {
        this.id = id;
        this.couponName = couponName;
        this.appLiedSku = appLiedSku;
        this.dicountPrice = dicountPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public int getAppLiedSku() {
        return appLiedSku;
    }

    public void setAppLiedSku(int appLiedSku) {
        this.appLiedSku = appLiedSku;
    }

    public double getDicountPrice() {
        return dicountPrice;
    }

    public void setDicountPrice(double dicountPrice) {
        this.dicountPrice = dicountPrice;
    }
}
