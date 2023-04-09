package com.example.ecommerce.mappers;

import com.example.ecommerce.mappers.impl.ReceiptMapperImpl;
import com.example.ecommerce.modules.Receipt;
import com.example.ecommerce.modules.dto.ReceiptDto;

public interface ReceiptMapper {

    ReceiptMapper INSTANCE = createInstance();

    static ReceiptMapper createInstance() {
        return new ReceiptMapperImpl();
    }

    Receipt toReceipt(ReceiptDto receiptDto);
    ReceiptDto toReceiptDto(Receipt receipt);
}
