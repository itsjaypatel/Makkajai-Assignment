package com.itsjaypatel.SalesTaxChallenge.entities;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

    private BigDecimal totalAmount;
    private BigDecimal  salesTax;
    private List<Item>  items;

    public Receipt(BigDecimal totalAmount, BigDecimal salesTax, List<Item> items) {
        this.totalAmount = totalAmount;
        this.salesTax = salesTax;
        this.items = items;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public List<Item> getItems() {
        return items;
    }

}
