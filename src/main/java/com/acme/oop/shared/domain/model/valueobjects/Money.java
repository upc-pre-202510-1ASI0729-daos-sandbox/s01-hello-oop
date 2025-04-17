package com.acme.oop.shared.domain.model.valueobjects;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Represents a monetary amount with currency.
 * This value object is immutable and shared across bounded contexts.
 *
 * @author Open Source Application Development Team
 */
public record Money(BigDecimal amount, Currency currency) {
    /**
     * Constructs a Money instance with the specified amount and currency.
     *
     * @param amount   the monetary amount, must not be null
     * @param currency the currency, must not be null
     * @throws IllegalArgumentException if amount or currency is null, or if amount has too many decimal places
     */
    public Money {
        if (amount == null) throw new IllegalArgumentException("Amount cannot be null");
        if (currency == null) throw new IllegalArgumentException("Currency cannot be null");
        if (amount.scale() > currency.getDefaultFractionDigits()) {
            throw new IllegalArgumentException("Too many decimal places for currency");
        }
    }

    /**
     * Creates a zero-amount Money instance in USD.
     *
     * @return a Money instance with zero amount in USD
     */
    public static Money zero() {
        return new Money(BigDecimal.ZERO, Currency.getInstance("USD"));
    }

    /**
     * Adds another Money instance to this one.
     *
     * @param other the Money to add, must have the same currency
     * @return a new Money instance with the summed amount
     * @throws IllegalArgumentException if currencies differ
     */
    public Money add(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot add different currencies");
        }
        return new Money(amount.add(other.amount), currency);
    }

    /**
     * Multiplies this Money instance by a factor.
     *
     * @param multiplier the multiplication factor
     * @return a new Money instance with the multiplied amount
     */
    public Money multiply(int multiplier) {
        return new Money(amount.multiply(BigDecimal.valueOf(multiplier)), currency);
    }
}