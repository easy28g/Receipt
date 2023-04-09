package com.example.ecommerce.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coupons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String couponName;

    private int appLiedSku;

    private double discountPrice;

    public Coupons() {
    }

    public Coupons(String couponName, int appLiedSku, double discountPrice) {
        this.couponName = couponName;
        this.appLiedSku = appLiedSku;
        this.discountPrice = discountPrice;
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

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double dicountPrice) {
        this.discountPrice = dicountPrice;
    }
}
