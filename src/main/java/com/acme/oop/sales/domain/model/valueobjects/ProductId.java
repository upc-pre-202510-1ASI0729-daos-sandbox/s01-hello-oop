package com.acme.oop.sales.domain.model.valueobjects;

import java.util.UUID;

/**
 * Represents a unique identifier for a Product within the Sales bounded context.
 *
 * @author Open Source Application Development Team
 */
public record ProductId(UUID value) {
    /**
     * Constructs a ProductId with the specified UUID.
     *
     * @param value the UUID value, must not be null
     * @throws IllegalArgumentException if value is null
     */
    public ProductId {
        if (value == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
    }

    /**
     * Constructs a ProductId with a randomly generated UUID.
     */
    public ProductId() {
        this(UUID.randomUUID());
    }
}