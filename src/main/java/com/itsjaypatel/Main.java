package com.itsjaypatel;

import com.itsjaypatel.SalesTaxChallenge.entities.*;
import com.itsjaypatel.SalesTaxChallenge.services.ReceiptService;
import com.itsjaypatel.SalesTaxChallenge.services.impl.ReceiptServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final List<Item> items = new ArrayList<>();
        boolean hasMoreProducts = true;
        while (hasMoreProducts) {

            String name, type;
            BigDecimal price;
            int quantity;
            boolean isImported;

            while (true) {
                System.out.println("ENTER PRODUCT NAME :");
                name = scanner.nextLine().trim().toUpperCase();
                if (!name.isBlank()) {
                    break;
                }
                System.out.println("INVALID PRODUCT NAME! TRY AGAIN!");
            }

            while (true) {
                System.out.println("ENTER PRODUCT TYPE(BOOK,FOOD,MEDICAL,OTHER): ");
                type = scanner.nextLine().trim().toUpperCase();
                if (Set.of("BOOK", "FOOD", "MEDICAL", "OTHER").contains(type)) {
                    break;
                }
                System.out.println("INVALID PRODUCT TYPE! TRY AGAIN!");
            }

            while (true) {
                System.out.println("ENTER PRODUCT PRICE: ");
                try {
                    price = new BigDecimal(scanner.nextLine().trim());
                    if (price.compareTo(BigDecimal.ZERO) > 0) {
                        break;
                    }
                    throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.out.println("INVALID PRODUCT PRICE! TRY AGAIN!");
                }
            }

            while (true) {
                System.out.println("ENTER PRODUCT QUANTITY: ");
                try {
                    quantity = Integer.parseInt(scanner.nextLine().trim());
                    if (quantity > 0) {
                        break;
                    }
                    throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.out.println("INVALID QUANTITY! TRY AGAIN!");
                }
            }

            while (true) {
                System.out.println("IS PRODUCT IMPORTED (Y/N)?");
                String input = scanner.nextLine().trim().toUpperCase();
                if (input.equals("Y") ||
                        input.equals("N")) {
                    input = input.replace("Y", "TRUE").replace("N", "FALSE");
                    isImported = Boolean.parseBoolean(input);
                    break;
                }
                System.out.println("INVALID IMPORTED STATUS! TRY AGAIN!");
            }

            switch (type) {
                case "BOOK":
                    items.add(new Book(name, quantity, price, isImported));
                    break;
                case "FOOD":
                    items.add(new Food(name, quantity, price, isImported));
                    break;
                case "MEDICAL":
                    items.add(new MedicalItem(name, quantity, price, isImported));
                    break;
                default:
                    items.add(new OtherItem(name, quantity, price, isImported));
            }

            while (true) {
                System.out.println("DO YOU WANT TO ADD MORE PRODUCTS (Y/N)?");
                String input = scanner.nextLine().trim().toUpperCase();
                if (input.equals("Y") ||
                        input.equals("N")) {
                    input = input.replace("Y", "TRUE").replace("N", "FALSE");
                    hasMoreProducts = Boolean.parseBoolean(input);
                    break;
                }
                System.out.println("INVALID INPUT! TRY AGAIN!");
            }
        }

        // Close the scanner
        scanner.close();

        ReceiptService receiptService = new ReceiptServiceImpl();
        Receipt receipt = receiptService.generate(items);
        receiptService.print(receipt);

    }
}