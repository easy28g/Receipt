package com.example.ecommerce.mappers.impl;

import com.example.ecommerce.mappers.ReceiptMapper;
import com.example.ecommerce.modules.Receipt;
import com.example.ecommerce.modules.dto.ReceiptDto;

public class ReceiptMapperImpl implements ReceiptMapper {
    @Override
    public Receipt toReceipt(ReceiptDto receiptDto) {
        Receipt receipt = new Receipt();
        receipt.setSubTotal(receiptDto.getSubTotal());
        receipt.setTaxTotal(receiptDto.getTaxTotal());
        receipt.setGrandTotal(receiptDto.getGrandTotal());
        return receipt;
    }

    @Override
    public ReceiptDto toReceiptDto(Receipt receipt) {
        ReceiptDto receiptDto = new ReceiptDto();
        receiptDto.setSubTotal(receipt.getSubTotal());
        receiptDto.setTaxTotal(receipt.getTaxTotal());
        receiptDto.setGrandTotal(receipt.getGrandTotal());
        return receiptDto;
    }
}
