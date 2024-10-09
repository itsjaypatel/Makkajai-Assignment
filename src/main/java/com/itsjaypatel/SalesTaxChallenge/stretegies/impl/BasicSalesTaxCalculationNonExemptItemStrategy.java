package com.itsjaypatel.SalesTaxChallenge.stretegies.impl;

import com.itsjaypatel.SalesTaxChallenge.constants.AppConstant;
import com.itsjaypatel.SalesTaxChallenge.stretegies.BasicSalesTaxCalculationStrategy;
import com.itsjaypatel.utils.CommonUtil;

import java.math.BigDecimal;

public class BasicSalesTaxCalculationNonExemptItemStrategy implements BasicSalesTaxCalculationStrategy {

    @Override
    public BigDecimal calculate(BigDecimal basePrice) {
        return CommonUtil.calculateTaxes(basePrice,BigDecimal.valueOf(AppConstant.BASIC_SALES_TAX_PERCENTAGE));
    }
}
