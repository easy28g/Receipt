package com.example.ecommerce.modules.dto;

public class ReceiptDto {

    private double subTotal;

    private double taxTotal;

    private double grandTotal;

    public ReceiptDto() {
    }

    public ReceiptDto(double subTotal, double taxTotal, double grandTotal) {
        this.subTotal = subTotal;
        this.taxTotal = taxTotal;
        this.grandTotal = grandTotal;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
