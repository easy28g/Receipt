package com.example.ecommerce.controllers;

import com.example.ecommerce.modules.Items;
import com.example.ecommerce.modules.dto.ReceiptDto;
import com.example.ecommerce.service.ReceiptService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemControllers {

    @Autowired
    ReceiptService receiptService;

    //  calculating the bill for the receipt
    @PostMapping("/calculate")
    public void doPost(@RequestBody List<Items> itemsList, HttpServletResponse response) throws ServletException, IOException {

        //  passing the deserialized json items to the calculated function
        ReceiptDto receipt = receiptService.calculate(itemsList);

        //  save the purchase history in the database
        receiptService.saveReceipt(receipt);

        //  serializing the receipt object to send to the client
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(receipt);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter outResponse = response.getWriter();
        outResponse.print(jsonString);
        outResponse.flush();
    }
}
