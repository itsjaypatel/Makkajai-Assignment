package com.itsjaypatel.SalesTaxChallenge.factories;

import com.itsjaypatel.SalesTaxChallenge.stretegies.BasicSalesTaxCalculationStrategy;
import com.itsjaypatel.SalesTaxChallenge.stretegies.impl.BasicSalesTaxCalculationExemptItemStrategy;
import com.itsjaypatel.SalesTaxChallenge.stretegies.impl.BasicSalesTaxCalculationNonExemptItemStrategy;

public class BasicSalesTaxCalculationStrategyFactory {

    private static final BasicSalesTaxCalculationStrategy basicSalesTaxCalculationExemptItemStrategy
            = new BasicSalesTaxCalculationExemptItemStrategy();

    private static final BasicSalesTaxCalculationStrategy basicSalesTaxCalculationNonExemptItemStrategy
            = new BasicSalesTaxCalculationNonExemptItemStrategy();

    public static BasicSalesTaxCalculationStrategy getBasicSalesTaxCalculationStrategy(boolean isExempted) {
        if (isExempted) {
            return basicSalesTaxCalculationExemptItemStrategy;
        }
        return basicSalesTaxCalculationNonExemptItemStrategy;
    }
}
