package com.itsjaypatel;

import com.itsjaypatel.SalesTaxChallenge.entities.Book;
import com.itsjaypatel.SalesTaxChallenge.entities.Food;
import com.itsjaypatel.SalesTaxChallenge.entities.OtherItem;
import com.itsjaypatel.SalesTaxChallenge.entities.Receipt;
import com.itsjaypatel.SalesTaxChallenge.services.ReceiptService;
import com.itsjaypatel.SalesTaxChallenge.services.impl.ReceiptServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ReceiptService receiptService = new ReceiptServiceImpl();

        Receipt receipt = receiptService.generate(
                List.of(
                new Book("Book",1,new BigDecimal("12.49"),false),
                new OtherItem("Music CD",1,new BigDecimal("14.99"),false),
                new Food("Chocolate Bar",1,new BigDecimal("0.85"),false))
        );
        receiptService.print(receipt);

        /*
            Receipt receipt = receiptService.generate(
                    List.of(
                            new Food("Box of Chocolates",1,BigDecimal.valueOf(10.00),true),
                            new OtherItem("Bottle of Perfume",1,BigDecimal.valueOf(47.50),true))
            );
            receiptService.print(receipt);
         */

        /*
            Receipt receipt = receiptService.generate(
                    List.of(
                            new OtherItem("Bottle of Perfume",1,new BigDecimal("27.99"),true),
                            new OtherItem("Bottle of Perfume",1,new BigDecimal("18.99"),false),
                            new MedicalItem("Packet of Headache Pills",1,new BigDecimal("9.75"),false),
                            new Food("Box of Chocolates",1,new BigDecimal("11.25"),true))
            );
            receiptService.print(receipt);
         */

    }
}