package com.itsjaypatel.SalesTaxChallenge.entities;

import com.itsjaypatel.SalesTaxChallenge.stretegies.impl.BasicSalesTaxCalculationNonExemptItemStrategy;
import com.itsjaypatel.SalesTaxChallenge.stretegies.impl.ImportDutyCalculationStrategyImpl;

import java.math.BigDecimal;

public class OtherItem extends Item {

    public OtherItem(String name, int quantity, BigDecimal price, boolean isImported) {
        super(name, quantity, price, isImported,
                new BasicSalesTaxCalculationNonExemptItemStrategy(),
                new ImportDutyCalculationStrategyImpl());
    }
}
