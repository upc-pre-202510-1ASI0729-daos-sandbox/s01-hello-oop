package com.acme.oop;

import com.acme.oop.crm.domain.model.aggregates.Customer;
import com.acme.oop.sales.domain.model.aggregates.SalesOrder;
import com.acme.oop.sales.domain.model.valueobjects.ProductId;
import com.acme.oop.shared.domain.model.valueobjects.*;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Main entry point for the OOP Sample application.
 * Demonstrates the usage of CRM and Sales bounded contexts.
 *
 * @author Open Source Application Development Team
 */
public class Main {
    /**
     * Runs the sample application, creating a customer and a sales order.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // CRM context
        Address address = new Address("123 Main St", "Springfield", "62701", "USA");
        Customer customer = new Customer("John Doe", "john@example.com", address);
        Address anotherAddress = new Address("456 Elm St", "Springfield", "62701", "USA");
        customer.updateContactInfo("john.doe@example.com", anotherAddress);

        // Sales context
        SalesOrder order = new SalesOrder(customer.getId());
        Money price = new Money(new BigDecimal("29.99"), Currency.getInstance("USD"));
        ProductId productId = new ProductId();
        order.addItem(productId, 2, price);

        // Display results
        System.out.println("Customer: " + customer.getName());
        System.out.println("Order Total: " + order.getTotalAmount().amount() + " " +
                order.getTotalAmount().currency());
    }
}