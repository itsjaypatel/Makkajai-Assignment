package com.itsjaypatel.SalesTaxChallenge.factories;

import com.itsjaypatel.SalesTaxChallenge.stretegies.ImportDutyCalculationStrategy;
import com.itsjaypatel.SalesTaxChallenge.stretegies.impl.ImportDutyCalculationStrategyImpl;

public class ImportDutyCalculationStrategyFactory {

    private static final ImportDutyCalculationStrategy importDutyCalculationStrategy =
            new ImportDutyCalculationStrategyImpl();

    public static ImportDutyCalculationStrategy getImportDutyCalculationStrategy() {
        return importDutyCalculationStrategy;
    }
}
