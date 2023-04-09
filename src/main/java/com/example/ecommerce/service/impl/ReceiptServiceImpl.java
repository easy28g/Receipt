package com.example.ecommerce.service.impl;

import com.example.ecommerce.dao.CouponsRepository;
import com.example.ecommerce.dao.ReceiptRepository;
import com.example.ecommerce.exceptions.GrandTotalException;
import com.example.ecommerce.mappers.CouponsMapper;
import com.example.ecommerce.mappers.ReceiptMapper;
import com.example.ecommerce.modules.Coupons;
import com.example.ecommerce.modules.Items;
import com.example.ecommerce.modules.Receipt;
import com.example.ecommerce.modules.dto.CouponsDto;
import com.example.ecommerce.modules.dto.ReceiptDto;
import com.example.ecommerce.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    CouponsRepository couponsRepository;

    @Autowired
    ReceiptRepository receiptRepository;

    @Override
    public ReceiptDto calculate(List<Items> itemList) throws IOException {

        //  We get all the discounts on items in the form of a list
        //  to pass to the calculatedFunc function

        List<Coupons> couponsList = couponsRepository.findAll();
        List<CouponsDto> couponsDtoList = CouponsMapper.INSTANCE.toCouponsDtoList(couponsList);

        //  counting the receipt
        ReceiptDto calculated = null;
        try {
            calculated = calculatedFunc(itemList, couponsDtoList);
        } catch (GrandTotalException e) {
            e.printStackTrace();
        }

        //  function for getting numbers that have only two digits after the decimal point
        ReceiptDto receiptDto = truncatedNumbers(calculated);

        return receiptDto;
    }

    @Override
    public ReceiptDto saveReceipt(ReceiptDto receiptDto) {
        Receipt receipt = ReceiptMapper.INSTANCE.toReceipt(receiptDto);
        receiptRepository.save(receipt);
        return ReceiptMapper.INSTANCE.toReceiptDto(receipt);
    }

    private ReceiptDto calculatedFunc(List<Items> itemList, List<CouponsDto> couponsDtoList) throws GrandTotalException {

        double subtotal = 0;
        double taxAbleSubtotal = 0;
        double taxTotal;
        double grandTotal;

        for(int i=0; i<itemList.size(); i++){
            for(int j=0; j<couponsDtoList.size(); j++){

                //  we are looking for the SKU whether there is a discount on a certain item
                if(couponsDtoList.get(j).getAppLiedSku() == itemList.get(i).getSku()){
                    itemList.get(i).setPrice(itemList.get(i).getPrice() - couponsDtoList.get(j).getDicountPrice());
                }
            }

            //  counting the items that are taxed
            if(itemList.get(i).isTaxable()==true){
                taxAbleSubtotal+=itemList.get(i).getPrice();
            }

            subtotal+=itemList.get(i).getPrice();
        }

        //  we calculate the tax only on those items that are taxed
        taxTotal = taxAbleSubtotal * 8.25 / 100;

        grandTotal = subtotal + taxTotal;

        ReceiptDto receipt = null;
        if(grandTotal>0) {
            receipt = new ReceiptDto(subtotal, taxTotal, grandTotal);
        } else {
            throw new GrandTotalException("grand total less than zero!");
        }

        return receipt;
    }

    private ReceiptDto truncatedNumbers(ReceiptDto calculated) {

        BigDecimal grandTotalBigDecimal = new BigDecimal(Double.toString(calculated.getGrandTotal()));
        grandTotalBigDecimal = grandTotalBigDecimal.setScale(2, RoundingMode.DOWN);

        BigDecimal taxTotalBigDecimal = new BigDecimal(Double.toString(calculated.getTaxTotal()));
        taxTotalBigDecimal = taxTotalBigDecimal.setScale(2, RoundingMode.DOWN);

        BigDecimal subtotalBigDecimal = new BigDecimal(Double.toString(calculated.getSubTotal()));
        subtotalBigDecimal = subtotalBigDecimal.setScale(2, RoundingMode.DOWN);

        ReceiptDto receiptDto = new ReceiptDto(subtotalBigDecimal.doubleValue(), taxTotalBigDecimal.doubleValue(), grandTotalBigDecimal.doubleValue());

        return receiptDto;

    }
}
