package com.itsjaypatel.SalesTaxChallenge.entities;

import com.itsjaypatel.SalesTaxChallenge.stretegies.BasicSalesTaxCalculationStrategy;
import com.itsjaypatel.SalesTaxChallenge.stretegies.ImportDutyCalculationStrategy;

import java.math.BigDecimal;

public abstract class Item {

    private final String name;
    private final int quantity;
    private final BigDecimal basePrice;
    private final boolean isImported;
    private final BasicSalesTaxCalculationStrategy basicSalesTaxCalculationStrategy;
    private final ImportDutyCalculationStrategy importDutyCalculationStrategy;

    protected Item(String name,int quantity, BigDecimal basePrice, boolean isImported,BasicSalesTaxCalculationStrategy
                   basicSalesTaxCalculationStrategy, ImportDutyCalculationStrategy importDutyCalculationStrategy) {
        this.name = name;
        this.quantity = quantity;
        this.basePrice = basePrice;
        this.isImported = isImported;
        this.basicSalesTaxCalculationStrategy = basicSalesTaxCalculationStrategy;
        this.importDutyCalculationStrategy = importDutyCalculationStrategy;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public boolean isImported() {
        return isImported;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    private BigDecimal basicSalesTaxCalculation(){
        return basicSalesTaxCalculationStrategy.calculate(basePrice).multiply(BigDecimal.valueOf(quantity));
    }

    private BigDecimal importDutyCalculation(){
        if(!isImported) return BigDecimal.ZERO;
        return importDutyCalculationStrategy.calculate(basePrice).multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal priceAfterTaxCalculation(){
        return basePrice.add(applicableSalesTax());
    }

    public BigDecimal applicableSalesTax(){
        BigDecimal tax1 =  basicSalesTaxCalculation();
        BigDecimal tax2 = importDutyCalculation();
        return tax1.add(tax2);
    }
}
