package com.itsjaypatel.SalesTaxChallenge.stretegies;

import java.math.BigDecimal;

public interface BasicSalesTaxCalculationStrategy {

    BigDecimal calculate(BigDecimal basePrice);
}