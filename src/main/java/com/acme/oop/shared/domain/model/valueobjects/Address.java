package com.acme.oop.shared.domain.model.valueobjects;

/**
 * Represents a physical address.
 * This value object is immutable and shared across bounded contexts.
 *
 * @author Open Source Application Development Team
 */
public record Address(String street, String city, String postalCode, String country) {
    /**
     * Constructs an Address with the specified details.
     *
     * @param street     the street address, must not be null or empty
     * @param city       the city, must not be null or empty
     * @param postalCode the postal code, must not be null or empty
     * @param country    the country, must not be null or empty
     * @throws IllegalArgumentException if any parameter is null or empty
     */
    public Address {
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Street is required");
        }
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City is required");
        }
        if (postalCode == null || postalCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Postal code is required");
        }
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country is required");
        }
    }
}