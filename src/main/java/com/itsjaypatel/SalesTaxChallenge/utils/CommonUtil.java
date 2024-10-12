package com.itsjaypatel.SalesTaxChallenge.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CommonUtil {

    private CommonUtil() {
    }

    public static BigDecimal calculateTaxesByTaxRate(BigDecimal baseAmount, BigDecimal taxRate) {
        return baseAmount.multiply(taxRate)
                .divide(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(0.05), 0, RoundingMode.UP)
                .multiply(BigDecimal.valueOf(0.05));
    }
}
