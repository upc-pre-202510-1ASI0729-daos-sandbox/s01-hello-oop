package com.acme.oop.sales.domain.model.aggregates;

import com.acme.oop.shared.domain.model.valueobjects.Money;
import com.acme.oop.sales.domain.model.valueobjects.ProductId;
import lombok.Getter;

/**
 * Represents an item within a Sales Order.
 * This entity is managed by the SalesOrder aggregate root.
 *
 * @author Open Source Application Development Team
 */
@Getter
public class SalesOrderItem {
    private final ProductId productId;
    private final int quantity;
    private final Money unitPrice;

    /**
     * Constructs a new SalesOrderItem.
     *
     * @param productId the identifier of the product, must not be null
     * @param quantity  the quantity ordered, must be positive
     * @param unitPrice the price per unit, must be positive
     */
    SalesOrderItem(ProductId productId, int quantity, Money unitPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    /**
     * Calculates the subtotal for this item (quantity × unit price).
     *
     * @return the calculated subtotal
     */
    public Money calculateSubtotal() {
        return unitPrice.multiply(quantity);
    }
}