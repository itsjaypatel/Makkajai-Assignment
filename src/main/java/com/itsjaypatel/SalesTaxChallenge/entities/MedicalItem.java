package com.itsjaypatel.SalesTaxChallenge.entities;


import com.itsjaypatel.SalesTaxChallenge.stretegies.impl.BasicSalesTaxCalculationExemptItemStrategy;
import com.itsjaypatel.SalesTaxChallenge.stretegies.impl.ImportDutyCalculationStrategyImpl;

import java.math.BigDecimal;

public class MedicalItem extends Item {

    public MedicalItem(String name, int quantity, BigDecimal price, boolean isImported) {
        super(name, quantity, price, isImported,
                new BasicSalesTaxCalculationExemptItemStrategy(),
                new ImportDutyCalculationStrategyImpl());
    }
}
