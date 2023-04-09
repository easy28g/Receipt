package com.example.ecommerce.modules;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Items {

    private String itemName;

    private int sku;

    @JsonFormat(shape = JsonFormat.Shape.BOOLEAN)
    private boolean isTaxable;

    private boolean ownBrand;

    private double price;

    public Items() {
    }

    public Items(String itemName, int sku, boolean isTaxable, boolean ownBrand, double price) {
        this.itemName = itemName;
        this.sku = sku;
        this.isTaxable = isTaxable;
        this.ownBrand = ownBrand;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public boolean isTaxable() {
        return isTaxable;
    }

    public void setTaxable(boolean taxable) {
        isTaxable = taxable;
    }

    public boolean isOwnBrand() {
        return ownBrand;
    }

    public void setOwnBrand(boolean ownBrand) {
        this.ownBrand = ownBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
