package com.itsjaypatel.SalesTaxChallenge.services;

import com.itsjaypatel.SalesTaxChallenge.entities.Item;
import com.itsjaypatel.SalesTaxChallenge.entities.Receipt;

import java.util.List;

public interface ReceiptService {

    Receipt generate(List<Item> items);

    void print(Receipt receipt);
}
