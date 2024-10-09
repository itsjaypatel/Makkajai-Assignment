package com.itsjaypatel.SalesTaxChallenge.stretegies;

import java.math.BigDecimal;

public interface ImportDutyCalculationStrategy {
    BigDecimal calculate(BigDecimal basePrice);
}