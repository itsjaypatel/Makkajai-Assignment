package com.itsjaypatel.SalesTaxChallenge.stretegies.impl;

import com.itsjaypatel.SalesTaxChallenge.stretegies.BasicSalesTaxCalculationStrategy;

import java.math.BigDecimal;

public class BasicSalesTaxCalculationExemptItemStrategy implements BasicSalesTaxCalculationStrategy {

    @Override
    public BigDecimal calculate(BigDecimal basePrice) {
        return BigDecimal.ZERO;
    }
}
