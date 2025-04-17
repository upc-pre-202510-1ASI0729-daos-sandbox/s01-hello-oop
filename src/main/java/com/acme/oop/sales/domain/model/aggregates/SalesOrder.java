package com.acme.oop.sales.domain.model.aggregates;

import com.acme.oop.shared.domain.model.valueobjects.CustomerId;
import com.acme.oop.shared.domain.model.valueobjects.Money;
import com.acme.oop.sales.domain.model.valueobjects.ProductId;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a sales order aggregate root in the Sales bounded context.
 * This class manages the lifecycle of a sales order and its items.
 *
 * @author Open Source Application Development Team
 */
@Getter
public class SalesOrder {
    private final UUID id;
    private final CustomerId customerId;
    private final LocalDateTime orderDate;
    private final List<SalesOrderItem> items;
    private Money totalAmount;

    /**
     * Constructs a new SalesOrder for a given customer.
     *
     * @param customerId the identifier of the customer placing the order, must not be null
     * @throws IllegalArgumentException if customerId is null
     */
    public SalesOrder(CustomerId customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID must not be null");
        }
        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();
        this.totalAmount = Money.zero();
    }

    /**
     * Adds a new item to the sales order with validation.
     *
     * @param productId the identifier of the product being ordered, must not be null
     * @param quantity  the quantity to order, must be positive
     * @param unitPrice the price per unit, must be positive
     * @throws IllegalArgumentException if any parameter violates business rules
     */
    public void addItem(ProductId productId, int quantity, Money unitPrice) {
        if (productId == null) {
            throw new IllegalArgumentException("Product ID is required");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (unitPrice.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Unit price must be positive");
        }

        SalesOrderItem item = new SalesOrderItem(productId, quantity, unitPrice);
        items.add(item);
        totalAmount = calculateTotalAmount();
    }

    /**
     * Calculates the total amount for all items in the order.
     *
     * @return the total monetary amount of the order
     */
    public Money calculateTotalAmount() {
        return items.stream()
                .map(SalesOrderItem::calculateSubtotal)
                .reduce(Money.zero(), Money::add);
    }
}