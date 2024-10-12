package com.itsjaypatel.SalesTaxChallenge.services.impl;

import com.itsjaypatel.SalesTaxChallenge.entities.Item;
import com.itsjaypatel.SalesTaxChallenge.entities.Receipt;
import com.itsjaypatel.SalesTaxChallenge.services.ReceiptService;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {

    @Override
    public Receipt generate(List<Item> items) {

        BigDecimal salesTax = BigDecimal.ZERO, total = BigDecimal.ZERO;
        for (Item item : items) {
            BigDecimal priceAfterCalculation = item.priceAfterApplyingTaxes();
            BigDecimal applicableSalesTax = item.applicableSalesTax();
            salesTax = salesTax.add(applicableSalesTax);
            total = total.add(priceAfterCalculation);
        }
        return new Receipt(total, salesTax, items);
    }

    @Override
    public void print(Receipt receipt) {

        System.out.println("-----------------------------------------");
        for (Item item : receipt.getItems()) {
            String text = String.format("%d " + (item.isImported() ? "Imported " : "") + "%s :: %s", item
                    .getQuantity(), item.getName(), item.priceAfterApplyingTaxes());
            System.out.println(text);
        }
        System.out.println("-----------------------------------------");
        System.out.println("Sales Taxes :: " + receipt.getSalesTax());
        System.out.println("Total Amount  :: " + receipt.getTotalAmount());
        System.out.println("-----------------------------------------");
    }
}
