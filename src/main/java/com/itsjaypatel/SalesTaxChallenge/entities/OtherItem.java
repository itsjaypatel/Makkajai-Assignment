package com.itsjaypatel.SalesTaxChallenge.entities;

import java.math.BigDecimal;

import static com.itsjaypatel.SalesTaxChallenge.factories.BasicSalesTaxCalculationStrategyFactory.getBasicSalesTaxCalculationStrategy;
import static com.itsjaypatel.SalesTaxChallenge.factories.ImportDutyCalculationStrategyFactory.getImportDutyCalculationStrategy;

public class OtherItem extends Item {

    public OtherItem(String name, int quantity, BigDecimal price, boolean isImported) {
        super(name,quantity,price, isImported,
                getBasicSalesTaxCalculationStrategy(false),
                getImportDutyCalculationStrategy());
    }
}
