package com.acme.oop.crm.domain.model.aggregates;

import com.acme.oop.shared.domain.model.valueobjects.Address;
import com.acme.oop.shared.domain.model.valueobjects.CustomerId;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a customer entity in the CRM bounded context.
 * This class serves as an aggregate root managing customer identity and contact information.
 *
 * @author Open Source Application Development Team
 */
@Getter
public class Customer {
    private final CustomerId id;
    @Setter private String name;
    @Setter private String email;
    @Setter private Address address;

    /**
     * Constructs a new Customer with the specified details.
     *
     * @param name    the customer's full name, must not be null or empty
     * @param email   the customer's email address, must not be null or empty
     * @param address the customer's physical address, must not be null
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Customer(String name, String email, Address address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be null or empty");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address must not be null");
        }
        this.id = new CustomerId();
        this.name = name;
        this.email = email;
        this.address = address;
    }

    /**
     * Updates the customer's contact information.
     *
     * @param email   the new email address, must not be null or empty
     * @param address the new physical address, must not be null
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public void updateContactInfo(String email, Address address) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be null or empty");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address must not be null");
        }
        this.email = email;
        this.address = address;
    }
}