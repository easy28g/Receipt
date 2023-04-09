package com.example.ecommerce.service;

import com.example.ecommerce.modules.Items;
import com.example.ecommerce.modules.dto.ReceiptDto;

import java.io.IOException;
import java.util.List;

public interface ReceiptService {

    ReceiptDto calculate(List<Items> items) throws IOException;
    ReceiptDto saveReceipt(ReceiptDto receiptDto);
}
