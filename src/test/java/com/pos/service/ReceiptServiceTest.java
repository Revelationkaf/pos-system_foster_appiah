package com.pos.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.pos.model.CartItem;
import com.pos.model.Product;
import com.pos.model.Sale;

class ReceiptServiceTest {

    @Test
    void generateReceiptNumberCreatesExpectedPrefixAndLength() {
        String receiptNumber = ReceiptService.generateReceiptNumber();

        assertTrue(receiptNumber.startsWith("RCP-"));
        assertTrue(receiptNumber.matches("RCP-\\d{14}-\\d{4}"));
    }

    @Test
    void generateReceiptTextIncludesInvoiceSummaryAndItemLines() {
        Sale sale = new Sale();
        sale.setReceiptNumber("RCP-TEST-001");
        sale.setSaleDate(LocalDateTime.of(2024, 1, 2, 3, 4, 5));
        sale.setCashier("Alice");
        sale.setPaymentMethod("Cash");
        sale.setSubtotal(new BigDecimal("10.00"));
        sale.setTax(new BigDecimal("0.80"));
        sale.setDiscount(new BigDecimal("1.00"));
        sale.setTotal(new BigDecimal("9.80"));

        Product product = new Product();
        product.setName("Coffee");
        product.setPrice(new BigDecimal("5.00"));

        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(2);
        item.setSubtotal(new BigDecimal("10.00"));

        sale.addItem(item);

        String receipt = ReceiptService.generateReceiptText(sale);

        assertTrue(receipt.contains("POINT OF SALE SYSTEM"));
        assertTrue(receipt.contains("Receipt #:"));
        assertTrue(receipt.contains("Coffee"));
        assertTrue(receipt.contains("Discount:"));
        assertTrue(receipt.contains("TOTAL:"));
    }
}
