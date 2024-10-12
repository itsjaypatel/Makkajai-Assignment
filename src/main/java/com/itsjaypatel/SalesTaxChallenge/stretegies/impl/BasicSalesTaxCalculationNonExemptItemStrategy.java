package com.itsjaypatel.SalesTaxChallenge.stretegies.impl;

import com.itsjaypatel.SalesTaxChallenge.constants.AppConstant;
import com.itsjaypatel.SalesTaxChallenge.stretegies.BasicSalesTaxCalculationStrategy;
import com.itsjaypatel.SalesTaxChallenge.utils.CommonUtil;

import java.math.BigDecimal;

public class BasicSalesTaxCalculationNonExemptItemStrategy implements BasicSalesTaxCalculationStrategy {

    @Override
    public BigDecimal calculate(BigDecimal basePrice) {
        return CommonUtil.calculateTaxesByTaxRate(basePrice, BigDecimal.valueOf(AppConstant.BASIC_SALES_TAX_PERCENTAGE));
    }
}
