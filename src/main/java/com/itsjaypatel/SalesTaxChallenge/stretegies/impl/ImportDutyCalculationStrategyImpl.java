package com.itsjaypatel.SalesTaxChallenge.stretegies.impl;

import com.itsjaypatel.SalesTaxChallenge.constants.AppConstant;
import com.itsjaypatel.SalesTaxChallenge.stretegies.ImportDutyCalculationStrategy;
import com.itsjaypatel.SalesTaxChallenge.utils.CommonUtil;

import java.math.BigDecimal;

public class ImportDutyCalculationStrategyImpl implements ImportDutyCalculationStrategy {

    @Override
    public BigDecimal calculate(BigDecimal basePrice) {
        return CommonUtil.calculateTaxesByTaxRate(basePrice, BigDecimal.valueOf(AppConstant.IMPORT_DUTY_PERCENTAGE));
    }
}
